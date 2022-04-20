package com.jasonz.designpattern.creationalPatterns.FactoryMethod.LoggerExample;

import creationalPatterns.FactoryMethod.LoggerExample.XMLUtilLogger;

public class ClientLogger
{

	public static void main(String[] args)
	{
		ILoggerFactory factory;
		ILoggerProduct logger;
		
		///
		factory = new LoggerFactoryFile();
		logger = factory.createLogger();
		logger.writeLog();

		//
		factory = new LoggerFactoryDatabase();
		logger = factory.createLogger();
		logger.writeLog();
		
		//use XML 
		ILoggerFactory factory2;
		ILoggerProduct logger2;
		//the type of return object need to be convertted
		factory2 = (ILoggerFactory)XMLUtilLogger.getBean();
		logger2 = factory2.createLogger();
		logger2.writeLog();

		
	}

}
