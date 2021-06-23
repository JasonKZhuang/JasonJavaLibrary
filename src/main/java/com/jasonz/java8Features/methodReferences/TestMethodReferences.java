package com.jasonz.java8Features.methodReferences;

import java.util.function.BiFunction;

/**
 * @author Jason.Zhuang
 * Oct 22, 2019
 * TestMethodReferences.java
 * Describe: Method references are a special type of lambda expressions. 
 * They are often used to create simple lambda expressions by referencing existing methods. 
 * There are three types of method references in java: 
 * 
 * 	Reference to a static method => ContainingClass::staticMethodName 
 * 	Reference to an instance method => containingObject::instanceMethodName 
 * 	Reference to a constructor => ClassName::new  
 * 
 * Actually, this is just change the pointer of the fuction in an interface 
 * to point to a new method address. (If you understand c programming)
 * in another word: change the reference address
 */
public class TestMethodReferences
{
	public static void main(String[] args)
	{
		TestMethodReferences tmr = new TestMethodReferences();

		//all these priciple is changing the pointer address
		tmr.testStaticMethodReference();
		//
		tmr.testInstanceMethodReference();
		//
		tmr.testConstructorReference();
		
	}

	///Reference to a static method
	public void testStaticMethodReference()
	{
		// Referring static method
		IMethodReferences mr = ConcreteClass::staticFunc1;
		mr.myUniqueFunction();// Calling interface method
		
		// another example using static method in Thread
		Thread t2=new Thread(ConcreteClass::myThreadStatus);  
	    t2.start();

	    BiFunction<Integer, Integer, Integer> adder1 = ConcreteClass::add;  
	    int result1 = adder1.apply(10, 20);
	    System.out.println(result1);  
	    
	    BiFunction<Integer, Float, Float> adder2 = ConcreteClass::add;
	    float result2 = adder2.apply(10, 20.123f);
	    System.out.println(result2);  
	    
	}
	
	public void testInstanceMethodReference()
	{
		ConcreteClass cc = new ConcreteClass();
        
		// Referring non-static method using reference  
		IMethodReferences mr = cc::instanceMethod1;
        // Calling interface method  
		mr.myUniqueFunction();
		
		//
		Thread myThread = new Thread(cc::instanceMethod1);  
		myThread.start();       
    }  
	
	public void testConstructorReference()
	{
		// Referring non-static method using reference  
		IMethodReferences mr = ConcreteClass::new;
		mr.myUniqueFunction();
	}
	
}
