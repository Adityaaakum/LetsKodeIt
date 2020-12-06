package com.letsKodeIt.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {
	private static final Logger loggers= LogManager.getLogger(LoggingExample.class);
	public static void main(String[] args) {
		
		
		loggers.info("Logging info");
		loggers.debug("debug info");
		loggers.error("error info");
		loggers.trace("trace message");
		loggers.warn("warn message");
		
		
		
	}
	

}
