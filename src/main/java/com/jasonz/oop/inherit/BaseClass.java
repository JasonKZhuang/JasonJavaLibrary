package com.jasonz.oop.inherit;

public class BaseClass
{
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
	String          varPackageOfBase;
	
	//=======================================================//
	public static String testBaseStaticMethod(String as_Arg)
	{
		return "这是父类自己 静态 方法 testBaseStaticMethod --->"+as_Arg;
	}
	
	public String testBaseMethod(String as_Arg)
	{
		return "这是父类自己方法testBaseMethod --->"+as_Arg;
	}
	
	
	public String testPublicMethod(String as_Arg)
	{
		return "testPublicMethod --->"+as_Arg;
	}
	
	protected String testProtectedMethod(String as_Arg)
	{
		return "testProtectedMethod --->"+as_Arg;
	}
	
	String testPackageMethod(String as_Arg)
	{
		return "testPackageMethod --->"+as_Arg;
	}
	
	@SuppressWarnings("unused")
	private String testPrivateMethod(String as_Arg)
	{
		return "testPrivateMethod --->"+as_Arg;
	}
	//=======================================================//
	public BaseClass()
	{
		super();
	}

	public String getVarPublicOfBase()
	{
		return varPublicOfBase;
	}

	public void setVarPublicOfBase(String varPublicOfBase)
	{
		this.varPublicOfBase = varPublicOfBase;
	}

	public int getVarProtectedOfBase()
	{
		return varProtectedOfBase;
	}

	public void setVarProtectedOfBase(int varProtectedOfBase)
	{
		this.varProtectedOfBase = varProtectedOfBase;
	}

	public String getVarPrivateOfBase()
	{
		return varPrivateOfBase;
	}

	public void setVarPrivateOfBase(String varPrivateOfBase)
	{
		this.varPrivateOfBase = varPrivateOfBase;
	}

	public String getVarPackageOfBase()
	{
		return varPackageOfBase;
	}

	public void setVarPackageOfBase(String varPackageOfBase)
	{
		this.varPackageOfBase = varPackageOfBase;
	}

}
