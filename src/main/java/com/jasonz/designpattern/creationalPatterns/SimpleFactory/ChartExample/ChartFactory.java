package com.jasonz.designpattern.creationalPatterns.SimpleFactory.ChartExample;

public class ChartFactory
{
	public static Chart getChart(String chartType)
	{
		Chart chart = null;
		if (chartType.equalsIgnoreCase("histogram"))
		{
			chart = new HistogramChart();
			System.out.println("Initialize Histogram Chart.");
		}else if (chartType.equalsIgnoreCase("pie"))
		{
			chart = new PieChart();
			System.out.println("Initialize Pie Chart.");
		}else if (chartType.equalsIgnoreCase("line"))
		{
			chart = new LineChart();
			System.out.println("Initialize Line Chart.");
		}
		
		return chart;
	}
}
