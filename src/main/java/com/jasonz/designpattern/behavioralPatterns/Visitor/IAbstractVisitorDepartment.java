package com.jasonz.designpattern.behavioralPatterns.Visitor;

public interface IAbstractVisitorDepartment
{
	public abstract void visit(EmployeeFulltime employee);

	public abstract void visit(EmployeeParttime employee);
}
