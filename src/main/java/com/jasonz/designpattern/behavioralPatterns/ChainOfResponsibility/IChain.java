package com.jasonz.designpattern.behavioralPatterns.ChainOfResponsibility;

public interface IChain
{
	public void setNextChain(IChain nextChain);
	
	public void calculate(Numbers request);
}
