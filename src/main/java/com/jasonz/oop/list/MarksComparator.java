package com.jasonz.oop.list;

import java.util.Comparator;

public class MarksComparator implements Comparator<Student>
{
	@Override
	public int compare(Student obj1, Student obj2)
	{
		return ((Float) obj1.getMarks()).compareTo((Float) obj2.getMarks());
	}
}
