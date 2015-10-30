package com.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class XML_Transformer {
	
	public JSONObject processXML(String path){
		JSONObject json =null;
		try {
			File file = new File(path);
			FileInputStream loadedXML=new FileInputStream(file);
			StringBuilder builder = new StringBuilder();
			int ch;
			while((ch = loadedXML.read()) != -1){
			    builder.append((char)ch);
			}

			String stringXML = builder.toString();
			json = XML.toJSONObject(stringXML);
			System.out.println(json);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

}
