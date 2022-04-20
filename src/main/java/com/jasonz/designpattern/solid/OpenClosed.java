/*
 * Software components should be open for extension, but closed for modification
 * For example, spring framework has class DispatcherServlet. 
 * This class acts as front controller for String based web applications. 
 * To use this class, we are not required to modify this class. 
 * All we need is to pass initialization parameters 
 * and we can extend it’s functionality the way we want.
 * 
 * Apart from passing initialization parameters during application startup, 
 * we can override methods as well to modify the behavior of target class 
 * by extending the classes.
 */
package solid;

public class OpenClosed
{

	public static void main(String[] args)
	{
		AbstractChart pie = new PieChart();
		ChartDisplay  chartDisplay1 = new ChartDisplay();
		chartDisplay1.setChart(pie);
		chartDisplay1.display();
		
		AbstractChart bar = new BarChart();
		ChartDisplay  chartDisplay2 = new ChartDisplay();
		chartDisplay2.setChart(bar);
		chartDisplay2.display();

	}

}

class ChartDisplay
{
	AbstractChart chart;
	
	public void display()
	{
		chart.display();
	}
	
	public AbstractChart getChart()
	{
		return chart;
	}

	public void setChart(AbstractChart chart)
	{
		this.chart = chart;
	}
	
}

abstract class AbstractChart
{
	public abstract void display();
}

class PieChart extends AbstractChart
{

	@Override
	public void display()
	{
		System.out.println("Display Pie Chart!");
	}
	
}

class BarChart extends AbstractChart
{

	@Override
	public void display()
	{
		System.out.println("Display Bar Chart!");
	}
	
}