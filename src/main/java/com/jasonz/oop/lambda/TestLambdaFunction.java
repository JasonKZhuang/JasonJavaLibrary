package com.jasonz.oop.lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class TestLambdaFunction
{

	public static void main(String[] args)
	{
		TestLambdaFunction self = new TestLambdaFunction();
		// ===========================================================//
//		self.testFuncInterface();
		self.testArrayList();
//		self.runThreadUseLambda();
//		self.runThreadUseInnerClass();

		// =====the example to simplify Comparator Interface======//
		self.testComparisonMethod();
		// =======================================================//

		// ====================The example of using function as a parameter
		// =================//
		// lambda expression for Addition for two parameters
		// This expression implements 'FuncInter1' interface
		IFuncInter1 add = (int x, int y) -> x + y;

		// lambda expression Multiplication for two parameters
		// This expression also implements 'FuncInter1' interface
		IFuncInter1 multiply = (int x, int y) -> x * y;

		// using different implementations using lambda Expressions
		// 1. Add two numbers using lambda expression
		System.out.println("Addition is " + self.operate(6, 3, add));

		// 2. Multiply two numbers using lambda expression
		System.out.println("Multiplication is " + self.operate(6, 3, multiply));
		// =======================================================//

		// ============= lambda expression for single parameter ==============//
		// This expression implements 'FuncInter2' interface
		IFuncInter2 fobj = message -> System.out.println("Hello " + message);
		fobj.sayMessage("Geek");
		// =======================================================//

	}

	public void testComparisonMethod()
	{
		// ==for the old fashion in java 7 or before
		Comparator<String> stringComparator = new Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return o1.compareTo(o2);
			}
		};
		int oldFashion = stringComparator.compare("Hello", "World");
		System.out.println(oldFashion);

		// ===Using Java Lambda expression
		Comparator<String> stringComparatorLambda = (String o1, String o2) -> {
			return o1.compareTo(o2);
		};
		// or More simplified, if only one return line
		stringComparatorLambda = (o1, o2) -> o1.compareTo(o2);
		//so, we just use this interface to call compare method
		int newFashion = stringComparatorLambda.compare("Hello", "World");
		System.out.println(newFashion);

	}

	public void testFuncInterface()
	{
		// lambda expression to implement a functional interface.
		// This interface implements abstractFun() by default
		FuncInterface fobj = (int x) -> System.out.println(2 * x);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);
	}

	public void testArrayList()
	{
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(1);
		arrList.add(2);
		arrList.add(3);
		arrList.add(4);

		// Using lambda expression to print all elements of arrList
		arrList.forEach(itemValue -> System.out.println(itemValue));

		// Using lambda expression to print even elements of arrList
		arrList.forEach(itemValue -> {
			if (itemValue % 2 == 0)
				System.out.println("even:" + itemValue);
			else
				System.out.println("odd:" + itemValue);
		});
	}

	/**
	 * Replace interface parameters with concrete implementation code snippets
	 * rather than an implementation class This code snippet follows the expression
	 * rules As you can see, code designed with lambda expressions is much cleaner
	 * and readable.
	 */
	public void runThreadUseLambda()
	{
		Thread myThread = new Thread(() -> System.out.println("==================="));
		myThread.start();
	}

	/**
	 * the previous method before Java 8
	 */
	public void runThreadUseInnerClass()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("==========================");
			}
		}).start();
	}

	// ==========================================///
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
