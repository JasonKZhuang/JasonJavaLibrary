package com.jasonz.designpattern.creationalPatterns.FactoryMethod.LoggerExample;

public class LoggerFactoryFile implements ILoggerFactory
{

	public LoggerFactoryFile()
	{
		System.out.println("Do some initialized work for File Logger Factory.");
	}
	
	public ILoggerProduct createLogger()
	{
		//You can wite some code for the default method to open file
		//
		//
		ILoggerProduct logger = new LoggerProductFile();
		//Here you can initialize dealwithLegacyCode by invoke the initilized method in File Logger
		//
		//
		System.out.println("You create a FileLogger Instance by default");
		return logger;
	}

	public ILoggerProduct createLogger(String args)
	{
		//You can wite some code open file by giving parameter
		//
		//
		ILoggerProduct logger = new LoggerProductFile();
		//Here you can initialize dealwithLegacyCode by invoke the initilized method in File Logger
		//
		//
		System.out.println("You create a FileLogger Instance by String");
		return logger;
	}

	public ILoggerProduct createLogger(Object obj)
	{
		//You can wite some code open file by giving Object
		//
		//
		ILoggerProduct logger = new LoggerProductFile();
		//Here you can initialize dealwithLegacyCode by invoke the initilized method in File Logger
		//
		//
		System.out.println("You create a FileLogger Instance by Object");
		return logger;
	}

}
