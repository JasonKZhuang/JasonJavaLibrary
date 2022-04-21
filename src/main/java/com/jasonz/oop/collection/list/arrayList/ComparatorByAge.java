package com.jasonz.oop.collection.list.arrayList;

import com.jasonz.oop.collection.list.SortingType;
import com.jasonz.oop.collection.list.Student;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Student>
{

	private SortingType sortingType;

	public ComparatorByAge(SortingType argType) {
		this.sortingType = argType;
	}

	// the return value 0 means equal ;
	// the return value negative means value is less than the argument
	// the return value positive means value is greater than the argument
	@Override
	public int compare(Student o1, Student o2) {
		if (sortingType == SortingType.ASC) {
			return Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
		} else {
			return Integer.valueOf(o2.getAge()).compareTo(Integer.valueOf(o1.getAge()));
		}
	}
}
