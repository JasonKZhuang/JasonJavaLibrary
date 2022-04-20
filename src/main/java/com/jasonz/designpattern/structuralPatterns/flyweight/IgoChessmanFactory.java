package com.jasonz.designpattern.structuralPatterns.flyweight;

import java.util.Hashtable;

public class IgoChessmanFactory
{
	private static IgoChessmanFactory instance = new IgoChessmanFactory();
	
	private static Hashtable<String, ABS_IgoChessman> hashTable;
	
	private IgoChessmanFactory()
	{
		hashTable = new Hashtable<String, ABS_IgoChessman>();
		ABS_IgoChessman black = new BlackIgoChessman();
		ABS_IgoChessman white = new WhiteIgoChessman();
		
		hashTable.put("b",black);
		hashTable.put("w",white);
	}

	public static IgoChessmanFactory getInstance()
	{
		return instance;
	}

	public static ABS_IgoChessman getIgoChessman(String color)
	{
		return (ABS_IgoChessman)hashTable.get(color);
	}

	
	
}
