package com.jasonz.oop.beans;

public class Bicycle
{
	// the Bicycle class has three fields
	public int cadence;

	public int gear;

	public int speed;

	// the Bicycle class has one constructor
	public Bicycle(int startCadence, int startSpeed, int startGear)
	{
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
	}

	// the Bicycle class has four methods
	public void setCadence(int newValue)
	{
		cadence = newValue;
	}

	public void setGear(int newValue)
	{
		gear = newValue;
	}

	public void applyBrake(int decrement)
	{
		speed -= decrement;
	}

	public void speedUp(int increment)
	{
		speed += increment;
	}

	public void printDescription()
	{
	    System.out.println("\nBike is " + "in gear " + this.gear
	        + " with a cadence of " + this.cadence +
	        " and travelling at a speed of " + this.speed + ". ");
	}

}
