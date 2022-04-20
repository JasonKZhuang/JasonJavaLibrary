package com.jasonz.designpattern.creationalPatterns.FactoryMethod.ElectricityBillExample;

public class CommercialPlan extends Plan
{

	@Override
	public void getRate()
	{
		rate=7.50; 
	}

}
