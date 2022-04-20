package com.jasonz.designpattern.behavioralPatterns.ChainOfResponsibility;

public class SubtractNumbers implements IChain
{
	private IChain nextInChain;
	
	public SubtractNumbers()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setNextChain(IChain nextChain)
	{
		this.nextInChain = nextChain;
	}

	@Override
	public void calculate(Numbers request)
	{
		if (request.getClaculaionWanted().equals("sub"))
		{
			System.out.println(request.getNumber1() 
					+ " - " 
					+ request.getNumber2() 
					+ " = " 
					+ (request.getNumber1() - request.getNumber2()));
		}else
		{
			nextInChain.calculate(request);
		}
		
		
		
	}

}
