package com.app.api;

import static spark.Spark.*;

import java.util.Date;

import com.app.db.DataBaseManager;
import com.app.model.Festivities;

public class festivitiesAPI {

	public static void main(String[] args) {

		// Create the manager to handle de DB
		DataBaseManager manager = new DataBaseManager();

		// Create the add REST method
		get("/post/:name/:start/:end/:place",
				(request, response) -> {
					Festivities festivitie = new Festivities(request
							.params(":name"), request.params(":start"), request
							.params(":end"), request.params(":place"));
					manager.add(manager, festivitie);
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
		put("/put",
				(req, res) -> {
					manager.modify(manager, req.params("id"), req.params("name"));
					System.out.println(req.headers("id"));
					//System.out.println(req.attribute("id"));
					//System.out.println(req.body());
					res.status(200);
					return "";
				});

		// Create the delete REST method
		delete("/delete", (req, res) -> "eliminar");

	}

}
