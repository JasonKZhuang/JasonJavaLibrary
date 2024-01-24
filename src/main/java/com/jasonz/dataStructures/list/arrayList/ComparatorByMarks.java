package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.objects.Student;

import java.util.Comparator;

public class ComparatorByMarks implements Comparator<Student> {
    @Override
    public int compare(Student obj1, Student obj2) {
        return ((Float) obj1.getMarks()).compareTo((Float) obj2.getMarks());
    }
}
