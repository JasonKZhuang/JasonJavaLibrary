package com.jasonz.oop.string;

import java.util.GregorianCalendar;

public class ExampleComparation
{
	public static void main(String[] args)
	{
		ExampleComparation example = new ExampleComparation();
		example.testStringBuffer();
		example.testStringBuilder();
				
	}

	private void testStringBuffer()
	{
		System.gc();
		long start = new GregorianCalendar().getTimeInMillis();
		long startMemory = Runtime.getRuntime().freeMemory();
		StringBuffer sb = new StringBuffer();
		// StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000000; i++)
		{
			sb.append(":").append(i);
		}
		long end = new GregorianCalendar().getTimeInMillis();
		long endMemory = Runtime.getRuntime().freeMemory();
		System.out.println("Time Taken:" + (end - start));
		System.out.println("Memory used:" + (startMemory - endMemory));
	}

	private void testStringBuilder()
	{
		System.gc();
		long start = new GregorianCalendar().getTimeInMillis();
		long startMemory = Runtime.getRuntime().freeMemory();
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000000; i++)
		{
			sb.append(":").append(i);
		}
		long end = new GregorianCalendar().getTimeInMillis();
		long endMemory = Runtime.getRuntime().freeMemory();
		System.out.println("Time Taken:" + (end - start));
		System.out.println("Memory used:" + (startMemory - endMemory));
	}
}
