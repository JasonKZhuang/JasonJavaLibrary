package com.jasonz.oop.inheritance.base;

public class SubClass2 extends BaseClass
{
	public void testMethodOfSub()
	{
		varPublicOfBase = "I can access the public variable in Base class";
		varProtectedOfBase= 100;//"I can access the protected variable in Base class";
		//varDefaultOfBase= ""; //I cannot access the default variable in Base class because of the different package
		//varPrivateOfBase = ""; //the private variables cannot be accessed. 	
		System.out.println(testBaseMethod(varPublicOfBase));
	};
	
	public static void main(String[] args)
	{
		SubClass2 sub = new SubClass2();
		System.out.println(sub.testPublicMethod("test")); // Test public method in base class
		sub.testMethodOfSub();
	}
}
