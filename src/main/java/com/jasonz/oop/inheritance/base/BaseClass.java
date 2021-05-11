package com.jasonz.oop.inheritance.base;

public class BaseClass
{
	//=======================================================//
	/**
	 * public  String
	 */
	public  String  varPublicOfBase;
	
	/**
	 * protected  int
	 */
	protected  int  varProtectedOfBase;
	
	/**
	 *private String
	 */
	private String  varPrivateOfBase;
	
	/**
	 *default is package String
	 */
	String	varDefaultOfBase;
	
	/**
	 * a variable for default access
	 */
	String 	var = "This is a var in Base Class";
	
	/**
	 * Static method in Base class
	 */
	static String staticVar = "This is static var in Base Class";
	
	//=======================================================//
	//=======================================================//
	/**
	 * Public method in Base class
	 * @param as_Arg
	 * @return
	 */
	public String testPublicMethod(String as_Arg)
	{
		return "testPublicMethod in Base Class--->"+as_Arg;
	}
	
	/**
	 * Protected method in Base class
	 * @param as_Arg
	 * @return
	 */
	protected String testProtectedMethod(String as_Arg)
	{
		return "testProtectedMethod in Base Class --->"+as_Arg;
	}
	
	/**
	 * default access method in Base class
	 * @param as_Arg
	 * @return
	 */
	String testDefaultMethod(String as_Arg)
	{
		return "testPackageMethod in Base Class --->"+as_Arg;
	}
	
	/**
	 * private method in Base class
	 * @param as_Arg
	 * @return
	 */
	@SuppressWarnings("unused")
	private String testPrivateMethod(String as_Arg)
	{
		return "testPrivateMethod in Base Class --->"+as_Arg;
	}
	
	//=======================================================//
	
	/**
	 * the method with default access
	 */
	void method() 
	{
		System.out.println("This is a method in Base Class");
	}

	public String testBaseMethod(String as_Arg)
	{
		return "这是父类自己方法testBaseMethod in Base Class --->"+as_Arg;
	}
	
	public static void staticMethod(String as_Arg)
	{
		System.out.println("This is a static method in Base Class --->"+as_Arg);
	}
	
	//=======================================================//
	/**
	 * the construction method
	 */
	public BaseClass()
	{
		super();
	}

	public String getVarPrivateOfBase()
	{
		return varPrivateOfBase;
	}

	public void setVarPrivateOfBase(String varPrivateOfBase)
	{
		this.varPrivateOfBase = varPrivateOfBase;
	}
	
	
}
