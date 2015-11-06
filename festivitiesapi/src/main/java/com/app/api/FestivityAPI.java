package com.app.api;

import static spark.Spark.*;


import com.app.db.DataBaseManager;
import com.app.model.Festivity;

public class FestivityAPI {

	public static void main(String[] args) {

		// Create the manager to handle the DB
		DataBaseManager manager = new DataBaseManager();

		// Create the add REST method
		get("/add/:name/:start/:end/:place",
				(request, response) -> {
					Festivity festivity = new Festivity(request
							.params("name"), request.params("start"), request
							.params("end"), request.params("place"));
					manager.add(manager, festivity);
					response.status(200);
					return "Added";
				});
		// Create the search REST method
		get("/search/:key/:value",
				(req, res) -> {
					String result = manager.search(manager, req.params("key"),
							req.params("value"));
					res.status(200);
					return result;
				});
		// Create the update REST method.
		put("/update",
				(req, res) -> {
					manager.modify(manager, req.params("id"), req.params("key"), req.params("value"));
					res.status(200);
					return "Updated";
				});

		// Create the delete REST method		
		delete("/delete",
				(req, res) -> {
					manager.delete(manager, req.params("id"));
					res.status(200);
					return "Erased";
				});


	}

}
