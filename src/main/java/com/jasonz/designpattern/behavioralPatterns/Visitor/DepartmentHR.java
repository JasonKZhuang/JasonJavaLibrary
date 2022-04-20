package behavioralPatterns.Visitor;

public class DepartmentHR implements IAbstractVisitorDepartment
{

	public DepartmentHR()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(EmployeeFulltime employee)
	{
		// TODO Auto-generated method stub
		int workTime = employee.getWorkTime();
		System.out.println("----Human Resource Department.----");
		System.out.println("Full time employee:" + employee.getName()
				+ ",the work hours is ：" + workTime);

		if (workTime > 40)
		{
			System.out.println("Full time employee:" + employee.getName()
					+ ",additional working hours is ：" + (workTime - 40));
		} else if (workTime < 40)
		{
			System.out.println("Full time employee:" + employee.getName()
					+ ",not working hours is ：" + (40 - workTime));
		}
	}

	@Override
	public void visit(EmployeeParttime employee)
	{
		// TODO Auto-generated method stub
		int workTime = employee.getWorkTime();
		System.out.println("----Human Resource Department.----");
		System.out.println("Part time employee:" + employee.getName()
				+ ", the working hours is ：" + workTime);
	}

}
