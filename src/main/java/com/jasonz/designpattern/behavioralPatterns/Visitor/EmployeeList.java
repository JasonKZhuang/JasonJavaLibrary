package com.jasonz.designpattern.behavioralPatterns.Visitor;

import java.util.ArrayList;

public class EmployeeList
{

	private ArrayList<AbstractElementEmployee> list = new ArrayList<AbstractElementEmployee>();

	public EmployeeList()
	{
		// TODO Auto-generated constructor stub
	}

	public void addEmployee(AbstractElementEmployee employee)
	{
		list.add(employee);
	}

	public void accept(IAbstractVisitorDepartment handler)
	{
		for (Object obj : list)
		{
			((AbstractElementEmployee) obj).accept(handler);
		}
	}

}
