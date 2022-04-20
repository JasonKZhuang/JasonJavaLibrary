package com.jasonz.designpattern.behavioralPatterns.ChainOfResponsibility;

public class TestChainMain
{

	public TestChainMain()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		IChain chainAdd = new AddNumbers();
		IChain chainSub = new SubtractNumbers();
		IChain chainMul = new MultiplyNumbers();
		IChain chainDiv = new DivideNumbers();
		
		chainAdd.setNextChain(chainSub);
		chainSub.setNextChain(chainMul);
		chainMul.setNextChain(chainDiv);
		
		Numbers request = new Numbers(2, 3, "add");
		chainAdd.calculate(request);
		
		request.setClaculaionWanted("div");
		chainAdd.calculate(request);
		
		request.setClaculaionWanted("pow");
		chainAdd.calculate(request);
		
		
	}

}
