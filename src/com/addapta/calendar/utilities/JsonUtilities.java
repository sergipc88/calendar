package com.addapta.calendar.utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtilities  {

	static public String jsonConverter(Object obj) {
		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String ObjConvert = prettyGson.toJson(obj);	
		
		return ObjConvert;
	}
	
	
	
	
	
}
