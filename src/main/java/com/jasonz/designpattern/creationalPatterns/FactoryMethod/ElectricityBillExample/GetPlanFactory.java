package com.jasonz.designpattern.creationalPatterns.FactoryMethod.ElectricityBillExample;

public class GetPlanFactory
{
	// use getPlan method to get object of type Plan
	public Plan getPlan(int planType)
	{
		if (planType == 1)
		{
			return new DomesticPlan();
		} else if (planType == 2)
		{
			return new CommercialPlan();
		} else if (planType == 3)
		{
			return new InstitutionalPlan();
		}
		
		return null;
	}
}
