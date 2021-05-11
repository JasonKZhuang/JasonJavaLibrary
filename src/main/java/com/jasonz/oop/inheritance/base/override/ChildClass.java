package com.jasonz.oop.inheritance.base.override;

import com.jasonz.oop.exception.ExceptionSub1;

public abstract class ChildClass extends ParentClass
{

	@Override
	public void write() throws ExceptionSub1
	{
		System.out.println("this is the write method in the Child Class");
	}

	@Override
	public void testParentInstanceMethod()
	{
		System.out.println("This is an override parent instance method in Child class");
	}
	
	
	public static void testParentStaticMethod()
	{
		System.out.println("This is the parent static method in <Child Class>");
	}

	/**
	 * implement parent abstract method and extends access to public 
	 */
	@Override
	public int absMethod1InParent()
	{
		System.out.println("This method implements the abstract method in Parent class");
		return 0;
	}

	/**
	 * redeclare parent abstract method and extends access to public 
	 */
	public abstract int absMethod2InParent();
		
	
}
