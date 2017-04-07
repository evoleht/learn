package com.evoleht.mongodb;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class DaoImpl implements Dao {

	@Override
	public Document getMongoData(MongoCollection<Document> collection, long id)
			throws Exception {
		BsonDocument filter = new BsonDocument();
		filter.append("id", new BsonInt64(id));
		MongoCursor<Document> uDocs = MongodbDao.find(collection, filter);
		if (uDocs != null) {
			while (uDocs.hasNext()) {
				Document uDoc = uDocs.next();
				System.out.println(uDoc);  
				return uDoc;
			}
		}
		return null;
	}

}
