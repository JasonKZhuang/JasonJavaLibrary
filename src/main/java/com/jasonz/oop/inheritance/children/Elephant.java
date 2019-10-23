package com.jasonz.oop.inheritance.children;

import com.jasonz.oop.inheritance.base.BaseAnimal;
import com.jasonz.oop.inheritance.base.Food;

public class Elephant extends BaseAnimal
{

	public Elephant()
	{
		this.setName("Elephant");
	}

	@Override
	public void eat(Food food)
	{
		System.out.println("Elephant eat "+food.getName());
	}

}
