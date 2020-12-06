package com.letsKodeIt.testclasses;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class CheckPoint {
	private static final Logger loggers= LogManager.getLogger(CheckPoint.class);
	
	private static final String PASS="PASS";
	private static final String FAIL="FAIL";

	
	private static HashMap<String, String> marking= new HashMap<String, String>();
	
	public static void cleanHashMap()
	{
		marking.clear();
	}
	private static void loadInHashMap(String key,String value)
	{
		marking.put(key, value);
	}
	
	public static void mark(String methodname,boolean result,String information)
	{
		
		String key= methodname.toLowerCase();
		
		if(result)
		{
			loggers.info(key+" :"+"passed");
			loggers.info(information);
			loadInHashMap(key, PASS);
		}
		else
		{
			loggers.info(information);
			loggers.error(key+" : "+"failed");
		}
		
		
	}
	
	public static void markfinal(String methodname,boolean result,String information)
	{
		
		String key= methodname.toLowerCase();
		
		if(result)
		{
			loggers.info(key+" :"+"passed");
			loggers.info(information);
			loadInHashMap(key, PASS);
		}
		else
		{
		loggers.info(information);
			loggers.error(key+" : "+"failed");
		}
		
		ArrayList<String> finalList= new ArrayList<String>();
		for (String string : finalList) {
			
			if(string.contains("fAIL"))
			{
				Assert.assertTrue(false);
			}
			
			else {
				Assert.assertTrue(true);
			}
			
		}
		
	}
	
	
}
