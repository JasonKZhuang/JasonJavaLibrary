package com.jasonz.oop.methodReferences;

public class ConcreteClass
{
	public ConcreteClass()
	{
		System.out.println("Hello, this is construct method.");
	}
	
	public static void staticFunc1()
	{
		System.out.println("Hello, this is static method.");
	}

	public static void myThreadStatus()
	{
		System.out.println("This is static method, Thread is running...");
	}

	public static int add(int a, int b)
	{
		return a + b;
	}

	// override static methods "add"
	public static float add(int a, float b)
	{
		return a + b;
	}
	//=====================================//
	public void instanceMethod1()
	{
		System.out.println("Hello, this is an instance method.");
	}

}
