package com.app.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spark.Spark;
import spark.utils.IOUtils;

import com.app.api.FestivityAPI;
import com.google.gson.Gson;

public class FestivityAPITest {

	

	@Before
	public void setUp() throws Exception {
		FestivityAPI.main(null);
	}

	@After
	public void tearDown() throws Exception {
		Spark.stop();
	}

	@Test
	public void testAdd() {
		TestResponse res = request("GET", "/add/d%C3%ADadelaindependencia/24.12.2015/25.12.2015/world");
		assertEquals(200, res.status);

		
	}
	
	@Test
	public void testSearch() {
		
		TestResponse res = request("GET", "/search/name/Navidad");
		assertEquals(200, res.status);

		
	}
	
	//@Test
	public void testUpdate() {
		
		TestResponse res = request("PUT", "/update");
		assertEquals(200, res.status);

		
	}
	
	//@Test
	public void testDelete() {
		
		TestResponse res = request("DELETE", "/delete");
		assertEquals(200, res.status);

		
	}
	
	
	private TestResponse request(String method, String path) {
		try {
			URL url = new URL("http://localhost:4567" + path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}

}




class TestResponse {

	public final String body;
	public final int status;

	public TestResponse(int status, String body) {
		this.status = status;
		this.body = body;
	}
}
