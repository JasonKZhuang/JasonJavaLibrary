package com.jasonz.oop.inherit;
/**
 * @creator Jason Zhuang
 * @create-time 2013-6-25
 * copywrite kkcms.com
 */
public abstract class Animal
{
	private String name;
	
	protected abstract void eat(Food food);

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}

