package com.jasonz.oop.inherit;
/**
 * @creator Peter Zhuang
 * @create-time 2013-6-24
 * copywrite kkcms.com
 */
public class ExtentsParent
{
	public int pubParentVal=1;
	
	protected int proParentVal=2;
	
	int    pagParentVal = 3;
	
	private   int priParentVal=4;
	
	public String pubParentMethod()
	{
		System.out.println("This is the parent PUBLIC Method");
		return "";
	}
	
	protected String proParentMethod()
	{
		System.out.println( "This is the parent PROTECTED Method");
		return "";
	}
	
	String pagParentMethod()
	{
		System.out.println("This is the parent PACKAGE Method");
		return "";
	}
	
	private String priParentMethod()
	{
		System.out.println( "This is the parent PRIVATE Method");
		return "";
	}
	
	//this method use to Overload for sub class
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
	
	//this  method use to Overload for sub class
	public float max(float a,float b)
	{
		return a>b?a:b;
	}
	//this method use to Override	
	public int  draw()
	{
		System.out.println("This is Parent Method draw use to Override!");
		return 0;
	}
	
	protected int  write()
	{
		System.out.println("This is Parent Method write use to Override!");
		return 0;
	}
	
	protected int  exceptiontest() throws Exception
	{
		System.out.println("This is Parent Method exceptiontest use to Override!");
		return 0;
	}
	
	protected static int staticMethodTest()
	{
		System.out.println("This is Parent static Method  use to Override!");
		return 0;
	}
}

