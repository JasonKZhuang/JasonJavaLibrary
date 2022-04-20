package com.jasonz.designpattern.creationalPatterns.FactoryMethod.LoggerExample;

public abstract class LoggerFactoryAbstract
{
	public void writeLog() 
	{
		ILoggerProduct logger = this.createLogger();
		logger.writeLog();
	}
	
	public abstract ILoggerProduct createLogger();
}
