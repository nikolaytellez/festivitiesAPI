package com.app.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.app.model.Festivities;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

public class DataBaseManager {

	//Create the Mongo DB conection
	private final MongoClient client = new MongoClient();
	private final MongoDatabase dbFestivities = client
			.getDatabase("festivities");
	private final MongoCollection<Document> collection = dbFestivities
			.getCollection("festivitiesColl");
	//Create the mongo add method
	public void add(DataBaseManager manager, Festivities festivitie) {
		manager.collection.insertOne(new Document()
				.append("name", festivitie.getName())
				.append("startDate", festivitie.getStartDate())
				.append("endDate", festivitie.getEndDate())
				.append("place", festivitie.getPlace()));
	}
	//Create the mongo search method
	public String search(DataBaseManager manager, String key, String value) {
		String result = "";
		Bson filter = new Document(key, value);
		List<Document> all = manager.collection.find(filter).into(
				new ArrayList<Document>());
		for (Document doc : all) {
			result = doc.toJson();
		}
		return result;
	}
	//Create the update method
	public void modify(DataBaseManager manager, String id,String value){
		Bson filter = new Document("$set", new Document("name",value));
		manager.collection.updateOne(eq("_id", id), filter);
	}

}
