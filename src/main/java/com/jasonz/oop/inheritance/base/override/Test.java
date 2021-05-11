package com.jasonz.oop.inheritance.base.override;

import com.jasonz.oop.exception.ExceptionBase;

public class Test
{
	public static void main(String[] args)
	{
		ParentClass p1 = new GrandChildClass();
		try
		{
			p1.write();
		} catch (ExceptionBase e)
		{
			e.printStackTrace();
		}
		
		ParentClass p2 = new GrandChildClass();
		try
		{
			p2.write();
		} catch (ExceptionBase e)
		{
			e.printStackTrace();
		}
	}
}
