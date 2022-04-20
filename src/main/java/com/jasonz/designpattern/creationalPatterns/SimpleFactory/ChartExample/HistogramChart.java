package com.jasonz.designpattern.creationalPatterns.SimpleFactory.ChartExample;

public class HistogramChart implements Chart
{

	public HistogramChart()
	{
		System.out.println("This is Histogram Chart Constructor.");
	}
	
	public void display()
	{
		System.out.println("Do something to display Histogram Chart.");
	}

}
