package com.jasonz.designpattern.structuralPatterns.bridge.painImageExample;

public class JPGImage extends AbstractImage
{

	public JPGImage()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseFile(String fileName)
	{
		Matrix m = new Matrix();
		this.imageOperation.doPaint(m);
		System.out.println(fileName + "JPG file.");
	}

}
