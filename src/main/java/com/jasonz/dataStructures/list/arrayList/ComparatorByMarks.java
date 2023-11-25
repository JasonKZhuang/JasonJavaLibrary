package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.list.Student;

import java.util.Comparator;

public class ComparatorByMarks implements Comparator<com.jasonz.dataStructures.list.Student> {
    @Override
    public int compare(com.jasonz.dataStructures.list.Student obj1, Student obj2) {
        return ((Float) obj1.getMarks()).compareTo((Float) obj2.getMarks());
    }
}
