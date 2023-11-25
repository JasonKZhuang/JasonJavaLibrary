package com.jasonz.algorithms.search;

import com.jasonz.dataStructures.list.SortingType;
import com.jasonz.dataStructures.list.Student;
import com.jasonz.dataStructures.list.arrayList.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * do binary search with three ways
 *  Iterative
 *  Recursive
 *  Collections Built-in
 */
public class MainTestBinarySearch {

    public static void main(String[] args) {
        // this class instance
        MainTestBinarySearch instance = new MainTestBinarySearch();
        // Define a new Arraylist with student objects
        ArrayList<Student> students = new ArrayList<Student>();

        // Example ArrayList Instance
        ExampleArrayList exampleInstance = new ExampleArrayList();
        exampleInstance.initStudentList(students);

        // sorting the student list before executing binary search
        Collections.sort(students, new ComparatorByAge(SortingType.ASC));

        // do binary search
        int searchValue = 40;
        IBinarySearch binarySearch1 = new BinarySearchIterative();
        IBinarySearch binarySearch2 = new BinarySearchRecursive();
        IBinarySearch binarySearch3 = new BinarySearchBuiltIn();

        int idx1 = binarySearch1.binarySearch(students, searchValue);
        int idx2 = binarySearch2.binarySearch(students, searchValue);
        int idx3 = binarySearch3.binarySearch(students, searchValue);

        // print value
        if (idx1>=0) {
            System.out.println("The Element Age " + searchValue + " is found at " + "index " + idx1);
            System.out.println(students.get(idx1));
        }else{
            System.out.println("no value found");
        }
    }

}
