package com.app.util;


import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class InsertDocumentApp {
	public static void main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("festivities");

			DBCollection collection = db.getCollection("festivitiesColl");
			XML_Transformer xml = new XML_Transformer();
			JSONObject json = xml.processXML("src/resources/festivities.xml");

			DBObject dbObject = (DBObject)JSON.parse(json.toString());
			collection.insert(dbObject);

			DBCursor cursorDocJSON = collection.find();
			while (cursorDocJSON.hasNext()) {
				System.out.println(cursorDocJSON.next());
			}

		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}