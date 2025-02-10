package com.jasonz.designpattern.creationalPatterns.FactoryMethod.LoggerExample;

public class LoggerFactoryDatabase implements ILoggerFactory
{

	public LoggerFactoryDatabase()
	{
		System.out.println("Do some initialized work for Database Logger Factory.");
	}
	
	public ILoggerProduct createLogger()
	{
		//You can wite some code for the default method of connecting database
		//
		//
		ILoggerProduct logger = new LoggerProductDatabase();
		//Here you can initialize dealwithLegacyCode by invoke the initilized method in DatabaseLogger
		//
		//
		System.out.println("You create a DatabaseLogger Instance by default");
		return logger;
	}

	public ILoggerProduct createLogger(String args)
	{
		//using the parameter to connect database
		//
		//
		ILoggerProduct logger = new LoggerProductDatabase();
		//Here you can initialize dealwithLegacyCode by invoke the initilized method in DatabaseLogger
		//
		//
		System.out.println("You create a DatabaseLogger Instance by String");
		return logger;
	}

	public ILoggerProduct createLogger(Object obj)
	{
		//using the string that is encapsulated in the obj to connect database
		//
		//
		ILoggerProduct logger = new LoggerProductDatabase();
		//Here you can initialize dealwithLegacyCode by invoke the initilized method in DatabaseLogger
		//
		//
		System.out.println("You create a DatabaseLogger Instance by object");
		return logger;
	}

}
