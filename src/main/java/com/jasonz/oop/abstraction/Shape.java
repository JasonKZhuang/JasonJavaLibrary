package com.jasonz.oop.abstraction;

public abstract class Shape
{
	public Shape()
	{
		System.out.println("Shape is created");
	}

	public abstract void draw();

	public void changeColor()
	{
		System.out.println("Color changed");
	}
}
