package com.jasonz.designpattern.structuralPatterns.proxy.DynamicProxy;

public class RealSubjectA implements AbstractSubject
{	
	public void request()
	{
		System.out.println("RealSubjectA requests Proxy");
	}
}