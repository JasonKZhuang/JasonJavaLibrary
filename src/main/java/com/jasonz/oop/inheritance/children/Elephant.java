package com.jasonz.oop.inheritance.children;

import com.jasonz.oop.inheritance.BaseAnimal;
import com.jasonz.oop.inheritance.Food;

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
