package com.jasonz.oop.inheritance.test;

public class B extends A
{
	public int modifyVal(int val) {
		if (checkValue(val))
		{
			return val;
		}else
		{
			return 0;
		}
	}
	
	public static void main(String[] args)
	{
		B b = new B();
		System.out.println(b.modifyVal(10));
	}
}
