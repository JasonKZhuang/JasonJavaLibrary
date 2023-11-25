package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.list.Student;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student obj1, Student obj2) {
		// the return value 0 means equal ;
		// the return value negative means value is less than the argument
		// the return value positive means value is greater than the argument
        return obj1.getName().compareTo(obj2.getName()); //return ACS
    }

}
