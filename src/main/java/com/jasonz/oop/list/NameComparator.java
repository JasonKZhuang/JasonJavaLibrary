package com.jasonz.oop.list;

import java.util.Comparator;

public class NameComparator  implements Comparator<Student>
{

	@Override
	public int compare(Student obj1, Student obj2)
	{
		// TODO Auto-generated method stub
		return obj1.getName().compareTo(obj2.getName());
	}

}
