package behavioralPatterns.Visitor;

public class EmployeeFulltime extends AbstractElementEmployee
{
	private String name;

	private double weeklyWage;

	private int workTime;

	public EmployeeFulltime()
	{
		// TODO Auto-generated constructor stub
	}

	public EmployeeFulltime(String name, double weeklyWage, int workTime)
	{
		this.name = name;
		this.weeklyWage = weeklyWage;
		this.workTime = workTime;
	}

	@Override
	public void accept(IAbstractVisitorDepartment handler)
	{
		// TODO Auto-generated method stub
		handler.visit(this);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getWeeklyWage()
	{
		return weeklyWage;
	}

	public void setWeeklyWage(double weeklyWage)
	{
		this.weeklyWage = weeklyWage;
	}

	public int getWorkTime()
	{
		return workTime;
	}

	public void setWorkTime(int workTime)
	{
		this.workTime = workTime;
	}

	
}
