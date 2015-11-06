package com.app.util;




import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertDocumentApp {
	
	
	private static MongoClient client;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		try {

			client = new MongoClient();
			MongoDatabase dbFestivities = client
					.getDatabase("festivities");
			MongoCollection<Document> collection = dbFestivities
					.getCollection("festivitiesColl");

			
			XML_Transformer xml = new XML_Transformer();
			JSONObject json = xml.processXML("src/resources/festivities.xml");

			Document festivitie = new Document();
			
			JSONArray array=(JSONArray) ((JSONObject)json.get("festivities")).get("festivity");
			System.out.println(array);
			
			
			
			for (int i = 0; i < array.length(); i++) {	
				collection.insertOne(festivitie.parse(JSONObject.valueToString(array.get(i))));
			}

		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}