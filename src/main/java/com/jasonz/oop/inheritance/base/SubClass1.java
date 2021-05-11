package com.jasonz.oop.inheritance.base;

public class SubClass1 extends BaseClass
{
	public void testMethodOfSub()
	{
		varPublicOfBase = "I can access the public variable in Base class";
		varProtectedOfBase= 100;//"I can access the protected variable in Base class";
		varDefaultOfBase= "I can access the default variable in Base class because of the same package";
		//varPrivateOfBase = ""; //the private variables cannot be accessed. 	
		testBaseMethod(varPublicOfBase);
	};
	
	public static void main(String[] args)
	{
		SubClass1 sub = new SubClass1();
		sub.testPublicMethod("test"); // Test public method in base class
		sub.testMethodOfSub();
	}
}
