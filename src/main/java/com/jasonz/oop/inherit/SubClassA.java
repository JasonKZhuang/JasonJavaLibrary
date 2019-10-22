package com.jasonz.oop.inherit;

public class SubClassA extends BaseClass
{

	/***********************************************************/
	/* java 不支持多继承
	/***********************************************************/
	public void subClassMethod()
	{
		this.varPackageOfBase="a";
		this.varPublicOfBase="b";
		this.varProtectedOfBase=1;
	}
	
	public static void main(String[] args)
	{
		SubClassA sub = new SubClassA();
		
		sub.varPublicOfBase="public var ";
		sub.varProtectedOfBase=2;
		sub.varPackageOfBase="package var";
		
		sub.testBaseMethod("aaaaaaaaaaaaaaaa");
		sub.subClassMethod();
	}

}
