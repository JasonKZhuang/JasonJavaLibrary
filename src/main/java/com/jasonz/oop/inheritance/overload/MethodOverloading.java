package com.jasonz.oop.inheritance.overload;

public class MethodOverloading
{
	private static void display(int a)
	{
		System.out.println("Arguments: " + a);
	}

	private static void display(int a, int b)
	{
		System.out.println("Arguments: " + a + " and " + b);
	}

	// this method accepts String object
	private static void display(String a)
	{
		System.out.println("Got String object " + a);
	}

	public static void main(String[] args)
	{
		display(1);
		display(1, 4);
		display("Hello World");
	}
	


}
