package com.jasonz.oop.arrayList;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student>
{
	@Override
	public int compare(Student obj1, Student obj2)
	{
		Integer intObj1 = Integer.valueOf(obj1.getAge());
		Integer intObj2 = Integer.valueOf(obj2.getAge());
		return (intObj1.compareTo(intObj2));
	}

}
