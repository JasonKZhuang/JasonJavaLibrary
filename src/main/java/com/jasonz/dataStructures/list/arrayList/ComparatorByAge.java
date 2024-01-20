package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.list.SortingType;
import com.jasonz.dataStructures.list.Student;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Student>
{
	private final SortingType sortingType;

	public ComparatorByAge(SortingType argType) {
		this.sortingType = argType;
	}

	// the return value 0 means equal ;
	// the return value negative means value is less than the argument
	// the return value positive means value is greater than the argument
	@Override
	public int compare(Student o1, Student o2) {
		if (sortingType == SortingType.ASC) {
			return Integer.compare(o1.getAge(), o2.getAge());
		} else {
			return Integer.compare(o2.getAge(), o1.getAge());
		}
	}
}
