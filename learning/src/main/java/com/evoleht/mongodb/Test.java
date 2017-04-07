package com.evoleht.mongodb;

import org.bson.Document;

import com.evoleht.util.PropertiesUtils;
import com.evoleht.util.StringUtil;
import com.mongodb.client.MongoCollection;

public class Test {
	
	public void test() throws Exception {
		Dao dao = new DaoImpl();
 		String collection_name = "user_doc";
		String dbName = PropertiesUtils.getPropValue("kaolereport");
		dbName = StringUtil.isEmpty(dbName)?"kaolereport":dbName;
		MongoCollection<Document> uDocs = MongodbDao.getCollection(dbName, collection_name);
		Document resultDoc = dao.getMongoData(uDocs, 1000);
	}
}
