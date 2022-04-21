package com.jasonz.designpattern.creationalPatterns.builder.MealExample;

public class SubMealBuilderA extends MealBuilder
{
	public void buildFood()
	{
		meal.setFood("һ�����ȱ�");
	}
	public void buildDrink()
	{
	    meal.setDrink("һ������");
	}
}