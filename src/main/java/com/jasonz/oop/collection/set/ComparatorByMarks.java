package com.jasonz.oop.collection.set;

import java.util.Comparator;

public class ComparatorByMarks implements Comparator<StudentForSet> {
    @Override
    public int compare(StudentForSet obj1, StudentForSet obj2) {
        return ((Float) obj1.getMarks()).compareTo((Float) obj2.getMarks());
    }
}
