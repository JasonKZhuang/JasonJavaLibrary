package com.jasonz.designpattern.structuralPatterns.bridge.painImageExample;

public abstract class AbstractImage
{
	IImageOperation imageOperation;
	
	public AbstractImage()
	{
		// TODO Auto-generated constructor stub
	}

	public IImageOperation getImageOperation()
	{
		return imageOperation;
	}

	public void setImageOperation(IImageOperation imageOperation)
	{
		this.imageOperation = imageOperation;
	}

	public abstract void parseFile(String fileName);
}
