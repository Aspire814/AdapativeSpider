package com.storm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

	private final static Logger logger = LoggerFactory.getLogger(LoggingUtil.class);
	
	public static void info(String key,String message) {
		logger.info("["+key+" INFO "+"{ || "+ message + "}]");
	}
	
	public static void debug(String key,String message) {
        logger.debug("["+key+" INFO "+"{ || "+ message + "}]");
    }
	
	public static void error(String key,String message) {
        logger.error("["+key+" INFO "+"{ || "+ message + "}]");
    }
}
