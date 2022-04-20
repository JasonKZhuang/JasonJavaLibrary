package com.jasonz.oop.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListByField
{

	public static void main(String[] args)
	{
		List<Student> studentlst = new ArrayList<Student>();

		studentlst.add(new Student("Jason", 1, 80));
		studentlst.add(new Student("Bob", 2, 100));
		studentlst.add(new Student("Anny", 3, 95));

		System.out.println("** Before sorting **:");
		for (Student student : studentlst)
		{
			System.out.println(student);
		}
		Collections.sort(studentlst, new NameComparator());

		System.out.println("** After sorting **");
		for (Student student : studentlst)
		{
			System.out.println(student);
		}

	}

}
