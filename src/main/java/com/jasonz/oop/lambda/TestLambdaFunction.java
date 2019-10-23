package com.jasonz.oop.lambda;

import java.util.ArrayList;

public class TestLambdaFunction
{

	public static void main(String[] args)
	{
		TestLambdaFunction self = new TestLambdaFunction();
		//===========================================================//
		self.testFuncInterface();
		self.testArrayList();
		self.runThreadUseLambda();
		self.runThreadUseInnerClass();
		
		//===========================================================//
		// lambda expression for addition for two parameters 
        // This expression implements 'FuncInter1' interface 
        IFuncInter1 add = (int x, int y) -> x + y; 
  
        // lambda expression multiplication for two parameters 
        // This expression also implements 'FuncInter1' interface 
        IFuncInter1 multiply = (int x, int y) -> x * y; 
  
        // using different implementations using lambda Expressions 
        // 1. Add two numbers using lambda expression 
        System.out.println("Addition is " + self.operate(6, 3, add)); 
  
        // 2. Multiply two numbers using lambda expression 
        System.out.println("Multiplication is " + self.operate(6, 3, multiply)); 
  
        // lambda expression for single parameter 
        // This expression implements 'FuncInter2' interface 
        IFuncInter2 fobj = message ->System.out.println("Hello " + message); 
        fobj.sayMessage("Geek"); 
        
	}
	
	public void testFuncInterface()
	{
		// lambda expression to implement a functional interface. 
		// This interface implements abstractFun() by default
        FuncInterface fobj = (int x)->System.out.println(2 * x); 
  
        // This calls above lambda expression and prints 10. 
        fobj.abstractFun(5); 
	}
	
	public void testArrayList()
	{
	    ArrayList<Integer> arrL = new ArrayList<Integer>(); 
        arrL.add(1); 
        arrL.add(2); 
        arrL.add(3); 
        arrL.add(4); 
  
        // Using lambda expression to print all elements of arrL 
        arrL.forEach(itemValue -> System.out.println(itemValue)); 
  
        // Using lambda expression to print even elements of arrL 
        arrL.forEach(itemValue -> { 
        	if (itemValue%2 == 0) 
        		System.out.println("even:"+ itemValue);
        	else
        		System.out.println("odd:"+ itemValue);
        });
	}

	/**
	 * Replace interface parameters with concrete implementation code snippets 
	 * rather than an implementation class
	 * This code snippet follows the expression rules
	 * As you can see, code designed with lambda expressions is much cleaner and readable.
	 */
	public void runThreadUseLambda() 
	{
        //Runnableæ˜¯ä¸€ä¸ªå‡½æ•°æŽ¥å�£ï¼Œå�ªåŒ…å�«äº†æœ‰ä¸ªæ— å�‚æ•°çš„ï¼Œè¿”å›žvoidçš„runæ–¹æ³•ï¼›
        //æ‰€ä»¥lambdaè¡¨è¾¾å¼�å·¦è¾¹æ²¡æœ‰å�‚æ•°ï¼Œå�³è¾¹ä¹Ÿæ²¡æœ‰returnï¼Œå�ªæ˜¯å�•çº¯çš„æ‰“å�°ä¸€å�¥è¯�
        Thread myThread = new Thread(
        	() ->System.out.println("lambdaå®žçŽ°çš„çº¿ç¨‹")
        ); 
        myThread.start();
    }
	
	/**
	 * the previous method before Java 8
	 */
	public void runThreadUseInnerClass() 
	{
        new Thread(
        	new Runnable() 
        	{
	            @Override
	            public void run() 
	            {
	                System.out.println("==========================");
	            }
        }).start();
    }
	
	//==========================================///
	// operation is implemented using lambda expressions 
    interface IFuncInter1 
    { 
        int operation(int a, int b); 
    } 
  
    // sayMessage() is implemented using lambda expressions
    interface IFuncInter2 
    { 
        void sayMessage(String message); 
    } 
  
    // Performs FuncInter1's operation on 'a' and 'b' 
    private int operate(int a, int b, IFuncInter1 fobj) 
    { 
        return fobj.operation(a, b); 
    } 
	
	
}
