package com.jasonz.designpattern.behavioralPatterns.ChainOfResponsibility;

public class DivideNumbers implements IChain
{
	private IChain nextInChain;
	
	public DivideNumbers()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setNextChain(IChain nextChain)
	{
		this.setNextInChain(nextChain);
	}

	@Override
	public void calculate(Numbers request)
	{
		if (request.getClaculaionWanted().equals("div"))
		{
			if (request.getNumber2() != 0)
			{
			System.out.println(request.getNumber1() 
					+ " / " 
					+ request.getNumber2() 
					+ " = " 
					+ (request.getNumber1() / request.getNumber2()));
			}else
			{
				System.out.println("0");
			}
		}else
		{
			System.out.println("Only works for add, sub,mul and div.");
		}
		
		
		
	}

	public IChain getNextInChain()
	{
		return nextInChain;
	}

	public void setNextInChain(IChain nextInChain)
	{
		this.nextInChain = nextInChain;
	}

}
