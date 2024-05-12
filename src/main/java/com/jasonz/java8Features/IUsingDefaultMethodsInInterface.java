package com.jasonz.java8Features;

/**
 * We can use default and static keyword to create interfaces with method
 * implementation.
 * 
 * @author Jason Zhuang 23 Jun. 2021
 *
 */
@FunctionalInterface
public interface IUsingDefaultMethodsInInterface
{

	void method1(String str);

	default void log(String str)
	{
		System.out.println("I1 logging::" + str);
	}

	static void print(String str)
	{
		System.out.println("Printing " + str);
	}

	// trying to override Object method gives compile-time error as
	// "Lesson6Distinct default method cannot override a method from java.lang.Object"

	// default String toString(){
	// return "i1";
	// }

}
