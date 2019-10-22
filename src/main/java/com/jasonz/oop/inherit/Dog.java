package com.jasonz.oop.inherit;
/**
 * @creator Jason Zhuang
 * @create-time 2013-6-25
 * copywrite kkcms.com
 */
public class Dog extends Animal
{

	@Override
	protected void eat(Food food)
	{
		System.out.println("Dog eat "+food.getName());
		
	}

	
}

