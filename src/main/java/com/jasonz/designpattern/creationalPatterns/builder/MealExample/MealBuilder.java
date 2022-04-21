package com.jasonz.designpattern.creationalPatterns.builder.MealExample;

public abstract class MealBuilder
{
	protected Meal meal=new Meal();
	public abstract void buildFood();
	public abstract void buildDrink();
	public Meal getMeal()
	{
		return meal;
	}
}