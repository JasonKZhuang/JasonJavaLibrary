package com.jasonz.designpattern.structuralPatterns.bridge.painImageExample;

public class PNGImage extends AbstractImage
{

	public PNGImage()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseFile(String fileName)
	{
		// TODO Auto-generated method stub
		Matrix m = new Matrix();
		this.imageOperation.doPaint(m);
		System.out.println(fileName + "PNG file.");
	}

}
