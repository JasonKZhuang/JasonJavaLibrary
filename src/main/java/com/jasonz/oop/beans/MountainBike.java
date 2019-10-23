package com.jasonz.oop.beans;

public class MountainBike extends Bicycle
{
	private String suspension;

	public MountainBike(int startCadence, int startSpeed, int startGear,
			String suspensionType)
	{
		super(startCadence, startSpeed, startGear);
		this.setSuspension(suspensionType);
	}

	public void printDescription()
	{
		super.printDescription();
		System.out.println("The " + "MountainBike has a " + getSuspension()
				+ " suspension.");
	}

	public String getSuspension()
	{
		return suspension;
	}

	public void setSuspension(String suspension)
	{
		this.suspension = suspension;
	}

}
