package com.jasonz.designpattern.behavioralPatterns.ChainOfResponsibility;

public class AddNumbers implements IChain
{
	private IChain nextInChain;
	
	public AddNumbers()
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
		if (request.getClaculaionWanted().equals("add"))
		{
			System.out.println(request.getNumber1() 
					+ " + " 
					+ request.getNumber2() 
					+ " = " 
					+ (request.getNumber1()+request.getNumber2()));
		}else
		{
			nextInChain.calculate(request);
		}
		
		
		
	}

}
