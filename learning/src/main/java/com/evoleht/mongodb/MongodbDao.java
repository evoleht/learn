package com.evoleht.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.evoleht.util.PropertiesUtils;
import com.evoleht.util.StringUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

/**
 * 
 * % com.ikaole.datalayer.common.mongodb.MongodbDao %。
 * <p>% Mongodb 数据库操作类%。</p> 
 * 
 * @author wang
 * @version v1.0.0
 * <p><B>last update </B> by wang @ 2016年4月29日</p>
 * @since v1.0.0
 */
public class MongodbDao {

	private static String mongo_seed1;
	private static int seed1_port;
	private static String mongo_seed2;
	private static int seed2_port;
	private static ServerAddress seed1;
	private static ServerAddress seed2;
	private static String DEFAULT_DB;
	private static String username;
	private static String password;
	private static String ReplSetName;
	//连接池中连接数目
	private static int maxPoolSize = 100;
	
	private static MongoClient mongoClient;
	
	private static Logger errLog = Logger.getLogger("ExceptionLog");

	private static String mongoIP;
	private static int mongoPort;
	
	static{
		try{
			mongo_seed1 = PropertiesUtils.getPropValue("mongo.seed1");
			seed1_port = Integer.parseInt(PropertiesUtils.getPropValue("mongo.seed1.port"));
			mongo_seed2 = PropertiesUtils.getPropValue("mongo.seed2");
			seed2_port = Integer.parseInt(PropertiesUtils.getPropValue("mongo.seed2.port"));

			seed1 = new ServerAddress(mongo_seed1,seed1_port);
			seed2 = new ServerAddress(mongo_seed2,seed2_port);
			DEFAULT_DB = PropertiesUtils.getPropValue("mongo.dbname");
			username = PropertiesUtils.getPropValue("mongo.username");
			password = PropertiesUtils.getPropValue("database.password");
			// 副本集名称
			ReplSetName = PropertiesUtils.getPropValue("ReplSetName"); 
			// mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
			MongoClientURI connectionString = new MongoClientURI("mongodb://"
					+ username + ":" + password + "@" + seed1 + "," + seed2 + "/"
					+ DEFAULT_DB + "?replicaSet=" + ReplSetName+"&maxPoolSize="+maxPoolSize);
			mongoClient = new MongoClient(connectionString);
		
		}catch(Exception es){
			errLog.error(es+",parameters:{"+"username:"+username+",password:"+password+
					",seed1:"+seed1+",seed2:"+seed2+",DEFAULT_DB:"+DEFAULT_DB+
					",ReplSetName:"+ReplSetName+"}");
			errLog.error(es+",parameters:{"+"username:"+username+",password:"+password+"}");
//			System.out.println("parameters:{"+"username:"+username+",password:"+password+
//				",seed1:"+seed1+",seed2:"+seed2+",DEFAULT_DB:"+DEFAULT_DB+
//				",ReplSetName:"+ReplSetName+"}");
			//连接本地mongodb库
//			mongoIP = PropertiesUtils.getPropValue("mongoIP");
//			mongoPort = Integer.valueOf(PropertiesUtils.getPropValue("mongoPort"));
//			mongoClient = new MongoClient(mongoIP,mongoPort);
			
			//正式
			mongoIP = PropertiesUtils.getPropValue("mongoIP");
			mongoPort = Integer.valueOf(PropertiesUtils.getPropValue("mongoPort"));
			//mongoClient = new MongoClient(mongoIP,mongoPort);
			seed1 = new ServerAddress(mongoIP,mongoPort);
			List<MongoCredential> credentialList = new ArrayList<MongoCredential>(1);
			MongoCredential cred = MongoCredential.createCredential("root", PropertiesUtils.getPropValue("authenticationDatabase"), 
					"wei_wE98nf23viewEWJO".toCharArray());
			credentialList.add(cred);
			mongoClient = new MongoClient(seed1, credentialList);
		}
	}
	
	/**
	 * 获取DB实例 - 指定DB
	 * 
	 * @param dbName
	 * @return
	 */
	public static MongoDatabase getDB(String dbName) {
		if (!StringUtil.isEmpty(dbName)) {
			MongoDatabase database = mongoClient.getDatabase(dbName);
			return database;
		}
		return null;
	}

	/**
	 * 获取collection对象 - 指定Collection
	 * 
	 * @param collName
	 * @return
	 */
	public static MongoCollection<Document> getCollection(String dbName,
			String collName) {
		if (StringUtil.isEmpty(dbName) || StringUtil.isEmpty(collName)) {
			return null;
		}
		MongoCollection<Document> collection = mongoClient.getDatabase(dbName)
				.getCollection(collName);
		return collection;
	}

	
	/**
	 * 添加
	 * @param coll
	 * @param doc
	 * @return
	 */
	public static boolean save(MongoCollection<Document> coll, Document doc) {
		boolean falg = false;
		try {
			coll.insertOne(doc);
			falg = true;
		} catch (Exception e) {
			errLog.error(e+","+e.getMessage());
		} 
		return falg;
	}

	/**
	 * 通过ID删除
	 * 
	 * @param coll
	 * @param id
	 * @return
	 */
	public static int deleteById(MongoCollection<Document> coll, String id) {
		try {
			int count = 0;
			ObjectId _id = null;
			_id = new ObjectId(id);
			Bson filter = Filters.eq("_id", _id);
			DeleteResult deleteResult = coll.deleteOne(filter);
			count = (int) deleteResult.getDeletedCount();
			return count;
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"id="+id);
			close();
		}
		return 0;
	}
	
	/***
	 * 删除文档
	 * 
	 * @param dbName
	 * @param collName
	 */
	public static void dropCollection(String dbName, String collName) {
		getDB(dbName).getCollection(collName).drop();
	}

	/**
	 * 修改
	 * 
	 * @param coll
	 * @param id
	 * @param newdoc
	 * @return
	 */
	public static Document updateById(MongoCollection<Document> coll,
			String id, Document newdoc) {
		ObjectId _idobj = null;
		try {
			_idobj = new ObjectId(id);
			Bson filter = Filters.eq("_id", _idobj);
			// coll.replaceOne(filter, newdoc); // 完全替代
			coll.updateOne(filter, new Document("$set", newdoc));
			return newdoc;
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"id="+id+",newdoc="+newdoc);
			close();
		}
		return null;
	}

	/**
	 * 查询DB下的所有表名
	 */
	public static List<String> getAllCollections(String dbName) {
		MongoIterable<String> colls = getDB(dbName).listCollectionNames();
		List<String> _list = new ArrayList<String>();
		for (String s : colls) {
			_list.add(s);
		}
		return _list;
	}

	/**
	 * 获取所有数据库名称列表
	 * 
	 * @return
	 */
	public static MongoIterable<String> getAllDBNames() {
		MongoIterable<String> s = mongoClient.listDatabaseNames();
		return s;
	}

	/**
	 * 查找对象 - 根据主键_id
	 * 
	 * @param collection
	 * @param id
	 * @return
	 */
	public static Document findById(MongoCollection<Document> coll, String id) {
		try {
			ObjectId _id = null;
			try {
				_id = new ObjectId(id);
			} catch (Exception e) {
				errLog.error(e+",input parameter:"+"id="+id);
				return null;
			}
			Document myDoc = coll.find(Filters.eq("_id", _id)).first();
			return myDoc;
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"id="+id);
			close();
		}
		return null;
	}

	/***
	 * 条件查询对象
	 * 
	 * @param coll
	 * @param filter
	 * @return
	 */
	public static Document findByNames(MongoCollection<Document> coll,
			Bson filter) {
		try {
			return coll.find(filter).first();
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"filter="+filter.toString());
			close();
		}
		return null;
	}

	/***
	 * 多条件查询对象
	 * 
	 * @param coll
	 * @param filter
	 * @return
	 */
	public static Document findByNames(MongoCollection<Document> coll,
			Map<String, Object> map) {
		try {
			return coll.find(new BasicDBObject(map)).first();
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"map="+map.toString());
			close();
		}
		return null;

	}

	/** 统计数 */
	public static int getCount(MongoCollection<Document> coll) {
		try {
			int count = (int) coll.count();
			return count;
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"coll="+coll.toString());
			close();
		}
		return 0;

	}

	/** 查询 多个集合文档 */
	public static MongoCursor<Document> find(MongoCollection<Document> coll,
			Bson filter) {
		try {
			return coll.find(filter).iterator();
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"filter="+filter.toString());
		}
		return null;
	}

	/**
	 * map集合 多条件查询
	 * 
	 * @param coll
	 * @param map
	 * @return
	 */
	public static MongoCursor<Document> find(MongoCollection<Document> coll,
			Map<String, Object> map) {
		try {
			return coll.find(new BasicDBObject(map)).iterator();
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"map="+map.toString());
			close();
		}
		return null;

	}
	 
	/**
	 * 分页查询 符合条件的集合数量。
	 * @param coll
	 * @param filter
	 * @return 
	 * @author wangzs @ 2016-8-19
	 */
	public static int findByPageCount(
			 MongoCollection<Document> coll, Bson filter) {
		 try {
			 return (int)coll.count(filter);
		 } catch (Exception e) {
			 errLog.error(e+","+e.getMessage());
			 close();
		 }
		 return 0;
	 }

	/**
	 * 分页查询 默认按_id字段降序。
	 * <p>%方法详述（简单方法可不必详述）%。</p>
	 * @param coll
	 * @param filter
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @author wangzs @ 2016-6-29
	 */
	public static MongoCursor<Document> findByPage(
			MongoCollection<Document> coll, Bson filter,
			int pageNo, int pageSize) {
		try {
			Bson orderBy = new BasicDBObject("_id", 1);
			return coll.find(filter).sort(orderBy)
					.skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
		} catch (Exception e) {
			errLog.error(e+","+e.getMessage());
			close();
		}
		return null;
	}
	
	public static MongoCursor<Document> findByPage(
			MongoCollection<Document> coll, Bson filter,
			int pageNo, int pageSize, String orderField, int orderType) {
		try {
			if (orderType >=0 ) {
				orderType = 1;
			}else {
				orderType = -1; 
			}
			Bson orderBy = new BasicDBObject(orderField, orderType);
			return coll.find(filter).sort(orderBy)
					.skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
		} catch (Exception e) {
			errLog.error(e+","+e.getMessage());
			close();
		}
		return null;
	}
	
	/***
	 * 分页查询 默认按_id字段降序
	 * 
	 * @param coll
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static MongoCursor<Document> findByPage(
			MongoCollection<Document> coll, Map<String, Object> map,
			int pageNo, int pageSize) {
		try {
			Bson orderBy = new BasicDBObject("_id", -1);
			return coll.find(new BasicDBObject(map)).sort(orderBy)
					.skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
		} catch (Exception e) {
			errLog.error(e+",input parameter:"+"map="+map.toString()+",pageNo="+pageNo+",pageSize="+pageSize);
			close();
		}
		return null;

	}

	/**
	 * 分页查询 自定义排序
	 * 
	 * @param coll
	 * @param sorting
	 * @param name
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static MongoCursor<Document> findByPage(
			MongoCollection<Document> coll, String sorting, String name,
			Map<String, Object> map, int pageNo, int pageSize) {
		try {
			Bson orderBy = null;
			// 降序
			if (sorting.equals("desc")) {
				orderBy = new BasicDBObject(name, -1);
			} else {
				orderBy = new BasicDBObject(name, 1);
			}
			return coll.find(new BasicDBObject(map)).sort(orderBy)
					.skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
		} catch (Exception e) {
			errLog.error(e+",method=findByPage"+",input parameter:"+"map="+map.toString()+",pageNo="+pageNo+",pageSize="+pageSize);
			close();
		}
		return null;

	}

	

	/**
	 * 关闭Mongodb
	 */
	public static void close() {
		if (mongoClient != null) {
			mongoClient.close();
			mongoClient = null;
		}
	}

	/*
	 * public static void main(String args[]) {
	 *  MongoClient client = createMongoDBClientWithURI(); 
	 * try { String demo_coll = "test"; //
	 * 取得Collecton句柄 MongoDatabase database = client.getDatabase(DEFAULT_DB);
	 * MongoCollection<Document> collection = database
	 * .getCollection(demo_coll); 
	 * // 插入数据
	 *  Document doc = new Document();
	 * doc.put("exam_id", 1054); doc.put("name", "京师大附中15年度第二次月考");
	 * doc.put("grade", 12); doc.put("description", "京师大附中15年度第二次月考");
	 * collection.insertOne(doc); System.out.println("insert document: " + doc);
	 * 
	 * // 读取数据 
	 * BsonDocument filter = new BsonDocument();
	 * filter.append("exam_id", new BsonString("1054")); 
	 * MongoCursor<Document> cursor = collection.find(filter).iterator();
	 *  while (cursor.hasNext()) {
	 		System.out.println("find document: " + cursor.next()); 
	 		} 
	 	} finally { //
	 * 关闭Client，释放资源
	 *  client.close(); } return; }
	 */
//	public static void main(String[] args) {
//		String db = "kaolereport";
//		String collName = "sturesult_docs";
//		MongoCollection<Document> sturesult_docs = getCollection(db, collName);
//		System.out.println(sturesult_docs.toString());
//		
//	}
}
