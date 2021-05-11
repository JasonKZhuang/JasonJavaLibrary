package com.jasonz.oop.inheritance.usingSuper;

public class UsingSuper
{

	public static void main(String[] args)
	{
		Emp e1 = new Emp(1, "ankit", 45000f);
		e1.display();

	}

}

class Person
{
	int id;
	String name;

	Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
}

class Emp extends Person
{
	float salary;

	Emp(int id, String name, float salary)
	{
		super(id, name);// reusing parent constructor
		this.salary = salary;
	}

	void display()
	{
		System.out.println(id + " " + name + " " + salary);
	}
}
