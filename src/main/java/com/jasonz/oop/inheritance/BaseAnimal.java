package com.jasonz.oop.inheritance;

/**
 * @creator Jason Zhuang
 * @create-time 2013-6-25
 * copywrite kkcms.com
 */
public abstract class BaseAnimal extends Creature
{
	private String name;
	
	public abstract void eat(Food food);

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}

