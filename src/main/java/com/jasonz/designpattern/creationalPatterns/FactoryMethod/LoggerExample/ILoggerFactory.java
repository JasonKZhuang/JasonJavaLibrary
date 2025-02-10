package com.jasonz.designpattern.creationalPatterns.FactoryMethod.LoggerExample;

public interface ILoggerFactory
{
	/**
	 * Create a dealwithLegacyCode Object
	 * @return
	 */
	public ILoggerProduct createLogger();
	
	public ILoggerProduct createLogger(String args);
	
	public ILoggerProduct createLogger(Object obj);
}
