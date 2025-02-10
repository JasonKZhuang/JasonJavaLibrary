package com.jasonz.designpattern.structuralPatterns.bridge.painImageExample;

public class WindowsImpl implements IImageOperation
{

	public WindowsImpl()
	{
	}

	@Override
	public void doPaint(Matrix m)
	{
		// TODO Auto-generated method stub
		System.out.println("Display Image in Windows OS.");
	}

}
