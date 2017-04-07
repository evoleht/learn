package com.evoleht.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public interface Dao {
	
	public Document getMongoData(MongoCollection<Document> collection,
			long id) throws Exception;
}
