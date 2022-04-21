package com.jasonz.oop.collection.list.arrayList;

import com.jasonz.oop.collection.list.SortingType;
import com.jasonz.oop.collection.list.Student;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class BinarySearchBuiltIn implements IBinarySearch {
    @Override
    public int binarySearch(ArrayList<Student> argList, int argValue) {
        // Searching a student with key value argValue.
        // To search that object we create an object of student with age argValue.
        int index = Collections.binarySearch(argList, new Student(null, argValue, 0), new ComparatorByAge(SortingType.ASC));
        return index;
    }
}
