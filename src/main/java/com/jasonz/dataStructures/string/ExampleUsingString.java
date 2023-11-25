package com.jasonz.dataStructures.string;

public class ExampleUsingString
{

	public static void main(String[] args)
	{
		char[] ch = { 'j', 'a', 'v', 'a', 't', 'p', 'o', 'i', 'n', 't' };
		String sNew = new String(ch);
		// is same as following:
		String str = "javatpoint";
		System.out.println(sNew == str);//false
		
		String str1 = "HelloWorld";
		String str2 = "HelloWorld";// It doesn't create a new instance
		String str3 = new String("HelloWorld");
		String str4 = "GreateWorld";
		
		System.out.println(str1 == str2);//true (because both refer to same instance)
		System.out.println(str1 == str3);//false(because str3 refers to instance created in non-pool) 
		System.out.println(str1.equals(str3));//true (because the content between str1 and str3 is same)

		//compareTo function: first string is less than, equal to or greater than second string.
		System.out.println(str1.compareTo(str2));//0  
		System.out.println(str1.compareTo(str4));//1(because str1>str4)  
		System.out.println(str4.compareTo(str1));//-1(because str4 < str1 )  
		
		String text1 = new String("apple");
		String text2 = new String("apple");

		// since two strings are different object result should be false
		// //Reference comparison
		boolean result = (text1 == text2);
		System.out.println("Comparing two strings with == operator: " + result);

		// since strings contains same content , equals() should return true
		// Content comparison
		result = text1.equals(text2);
		System.out.println("Comparing two Strings with same content using equals method: " + result);

		text2 = text1;
		// since both text2 and text1 reference variable are pointing to same object
		// "==" should return true
		result = (text1 == text2);
		System.out.println("Comparing two reference pointing to same String with == operator: " + result);
		
		ExampleUsingString  self = new ExampleUsingString();
		self.testingContains();

		String test = null;
		System.out.println(test==null);
		test ="";
		System.out.println(test.isEmpty());
		test =" ";
		System.out.println(test.isEmpty());


	}
	
	private void testingContains()
	{
		String test  = "CPAYJRZ0023226";
		System.out.println(test.contains("CPAY"));
	}

}
