package com.jasonz.oop.inheritance.children;

import com.jasonz.oop.inheritance.base.BaseClass;

public class SubClass2 extends BaseClass
{
	public void testMethodOfSub()
	{
		varPublicOfBase = "I can access the public variable in Base class";
		varProtectedOfBase= 100;//"I can access the protected variable in Base class";
		
		//varDefaultOfBase= "I can access the default variable in Base class because of the same package";
		//varPrivateOfBase = ""; //the private variables cannot be accessed. 	
		
		String v1 = testPublicMethod("public method in Base class");
		System.out.println(v1);
		
		String v2 = testProtectedMethod("protected method in Base class");
		System.out.println(v2);
		
		//String v3 = testDefaultMethod("default method in Base class");
		//System.out.println(v3);
		
		testBaseMethod(varPublicOfBase);
	};
	
	public static void main(String[] args)
	{
		SubClass2 sub = new SubClass2();
		
		sub.testMethodOfSub();
	}
}
