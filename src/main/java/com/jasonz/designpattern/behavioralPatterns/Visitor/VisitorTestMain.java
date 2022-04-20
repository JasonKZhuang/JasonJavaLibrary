package behavioralPatterns.Visitor;

public class VisitorTestMain
{
	public static void main(String[] args)
	{
		EmployeeList list = new EmployeeList();
		AbstractElementEmployee fte11,fte12,fte13,pte21,pte22,pte23;
		fte11 = new EmployeeFulltime("张无忌",3200.00,45);
		fte12 = new EmployeeFulltime("杨过",2000.00,40);
		fte13 = new EmployeeFulltime("段誉",2400.00,38);
		pte21 = new EmployeeParttime("洪七公",80.00,20);
		pte22 = new EmployeeParttime("郭靖",60.00,18);
		pte23 = new EmployeeParttime("黄蓉",60.00,18);
		
		list.addEmployee(fte11);
		list.addEmployee(fte12);
		list.addEmployee(fte13);
		list.addEmployee(pte21);
		list.addEmployee(pte22);
		list.addEmployee(pte23);
		IAbstractVisitorDepartment dep1 = new DepartmentFinance();
		list.accept(dep1);
		System.out.println("====================================");
		IAbstractVisitorDepartment dep2 = new DepartmentHR();
		list.accept(dep2);

	}

}
