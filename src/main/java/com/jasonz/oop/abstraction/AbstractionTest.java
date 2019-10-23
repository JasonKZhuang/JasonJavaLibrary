package com.jasonz.oop.abstraction;

public class AbstractionTest
{

	public static void main(String[] args)
	{
		IMyInterface obj = new MyImplementB();
		obj.a();
		obj.b();
		obj.c();
		obj.d();
	}

}
