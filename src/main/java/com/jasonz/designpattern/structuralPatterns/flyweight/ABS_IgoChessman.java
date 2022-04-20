package com.jasonz.designpattern.structuralPatterns.flyweight;

public abstract class ABS_IgoChessman
{
	public abstract String getColor();
	
	public void display(Coordinates coordinates) 
	{
		System.out.println("The chess color is：" + this.getColor()
				+" and coordinate is " + coordinates.getX()+","+coordinates.getY());
	}
}
