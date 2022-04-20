package behavioralPatterns.Visitor;

public class EmployeeParttime extends AbstractElementEmployee
{
	private String name;

	private double hourWage;

	private int workTime;

	public EmployeeParttime()
	{
		// TODO Auto-generated constructor stub
	}

	public EmployeeParttime(String name, double hourWage, int workTime)
	{
		this.name = name;
		this.hourWage = hourWage;
		this.workTime = workTime;
	}

	@Override
	public void accept(IAbstractVisitorDepartment handler)
	{
		handler.visit(this);
	}

	//=========================================//
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getHourWage()
	{
		return hourWage;
	}

	public void setHourWage(double hourWage)
	{
		this.hourWage = hourWage;
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
