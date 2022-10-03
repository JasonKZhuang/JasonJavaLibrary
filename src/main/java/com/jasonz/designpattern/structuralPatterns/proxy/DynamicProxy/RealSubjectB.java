package com.jasonz.designpattern.structuralPatterns.proxy.DynamicProxy;

public class RealSubjectB implements AbstractSubject
{	
	public void request()
	{
		System.out.println("RealSubjectB requests Proxy");
	}
}