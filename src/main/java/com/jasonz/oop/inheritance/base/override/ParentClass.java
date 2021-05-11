package com.jasonz.oop.inheritance.base.override;

import com.jasonz.oop.exception.ExceptionBase;

@SuppressWarnings("unused")
public abstract class ParentClass
{
	public void write() throws ExceptionBase
	{
		System.out.println("This is the write method in Parent Class");
	}

	public static void testParentStaticMethod()
	{
		System.out.println("This is the parent static method in Parent Class");
	}

	public void testParentInstanceMethod()
	{
		System.out.println("This is the parent instance method in Parent Class");
	}

	abstract int absMethod1InParent();

	abstract int absMethod2InParent();
	
	private int myPrivateMethod()
	{
		System.out.println("This is a private method in Parent Class");
		return 0;
	}
}
