package com.jasonz.oop.inheritance.base;

public class SubClass extends BaseClass
{
	//hide the var in Base class
	String var = "This is Sub Class var";
	
	static String staticVar = "This is static var in Sub Class";
	
	String subVar = "This is an instance sub var";

	//override method in Base class
	@Override
	void method()
	{
		System.out.println("This is a sub class method which override base method");
	}
	
	public static void staticMethod(String as_Arg)
	{
		System.out.println("This is static method in sub class --->"+as_Arg);
	}
	
	void subMethod()
	{
		System.out.println("This is a method in Sub Class");
	}

	void test()
	{
		//the variable in local method
		String var = "Local Variable";
		System.out.println("var is " + var);
		
		//print instance var which is in sub class
		System.out.println("This.var is "+ this.var);
		
		//print instance var which is in Base class 
		System.out.println("Super.var is " + super.var);
		
		method(); //call method in sub class
		this.method();//call method in sub class
		super.method();//call method in Base class
	}

	public static void main(String[] args)
	{
		
		//定义一个子类实例变量
//		SubClass sub = new SubClass();
//		sub.test();
//		System.out.println("======================================================");
		
		//Testing Polymorphism ======================///
		
		//myClass 被声明为BaseClass 类型，但是是引用SubClass 实例
		BaseClass myClass = new SubClass();

		//实例方法与引用变量实际引用的对象的方法绑定
		myClass.method();
		
		//静态方法与引用变量所声明的类型的方法绑定
		myClass.staticMethod("Hello");
				
		//成员变量（包括静态变量和实例变量）	与引用所声明的类型的变量绑定 
		//打印BaseClass的var
		System.out.println("myClass.var is => " + myClass.var);
		//打印BaseClass的static var
		System.out.println("myClass.staticVar is => " + myClass.staticVar);
		
		
		
//		((SubClass)myClass).subVar = " convert class into sub class";
//		((SubClass)myClass).subMethod();

	}

}
