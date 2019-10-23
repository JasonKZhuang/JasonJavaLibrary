package com.jasonz.oop.inheritance.children;

import com.jasonz.oop.inheritance.base.BaseAnimal;
import com.jasonz.oop.inheritance.base.Food;

/**
 * @creator Jason Zhuang
 * @create-time 2013-6-25 copywrite kkcms.com
 */
public class Dog extends BaseAnimal
{

	@Override
	public void eat(Food food)
	{
		System.out.println("Dog eat " + food.getName());
	}

	public void bark()
	{
		System.out.println("barking...");
	}

}
