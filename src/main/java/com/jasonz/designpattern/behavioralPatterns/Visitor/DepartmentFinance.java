package behavioralPatterns.Visitor;

/**
 * this class is the concerate visiter for financial department
 * @author Jason.Zhuang
 * @studentId s3535252
 * May 3, 2018
 * DepartmentFinance.java
 * Describe:
 */
public class DepartmentFinance implements IAbstractVisitorDepartment
{
	public DepartmentFinance()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(EmployeeFulltime employee)
	{
		int workTime = employee.getWorkTime();
		double weekWage = employee.getWeeklyWage();

		if (workTime > 40)
		{
			weekWage = weekWage + (workTime - 40) * 100;
		} else if (workTime < 40)
		{
			weekWage = weekWage - (40 - workTime) * 80;
			if (weekWage < 0)
			{
				weekWage = 0;
			}
		}
		System.out.println("----Financial Department.----");
		System.out.println("Full time employee:" + employee.getName());
	}

	@Override
	public void visit(EmployeeParttime employee)
	{
		// TODO Auto-generated method stub
		int workTime = employee.getWorkTime();
		double hourWage = employee.getHourWage();
		System.out.println("----Financial Department.----");
		System.out.println("Part time employee:" + employee.getName()
				+" the wage is "+ (workTime * hourWage));
	}

}
