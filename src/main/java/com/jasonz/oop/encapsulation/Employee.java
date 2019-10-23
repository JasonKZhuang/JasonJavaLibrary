package com.jasonz.oop.encapsulation;

/**
 * wrapping the data (variables) and code acting on the data (methods) together as a single unit. 
 * In encapsulation, the variables of a class will be hidden from other classes, 
 * and can be accessed only through the methods of their current class.
 * To achieve encapsulation in Java −
 * Declare the variables of a class as private.
 * Provide public setter and getter methods to modify and view the variables values.
 * Reference: https://www.tutorialspoint.com/java/java_encapsulation.htm
 */


/**
 * @author Jason.Zhuang
 * Oct 23, 2019
 * Employee.java
 * Describe:
 */
public class Employee
{
	private String name;
	private int age;
	private float salary;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public float getSalary()
	{
		return salary;
	}
	public void setSalary(float salary)
	{
		this.salary = salary;
	}
	
}
