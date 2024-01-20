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
 *
 *  Time Complexity Analysis
 *  The Best Case occurs when the target element is the middle element of the array.
 *  The number of comparisons, in this case, is 1. So, the time complexity is O(1).
 *
 *  The Average Case: On average, the target element will be somewhere in the array.
 *  So, the time complexity will be O(logN).
 *
 *  The Worst Case occurs when the target element is not in the list or it is away from the middle element.
 *  So, the time complexity will be O(logN).
 */
public class BinarySearchMainTest {

    public static void main(String[] args) {
        // this class instance
        // Define a new Arraylist with student objects
        ArrayList<Student> students = new ArrayList<Student>();

        // Example ArrayList Instance, initialize students values
        ExampleArrayList.initStudentList(students);

        // sorting the student list before executing binary search
        students.sort(new ComparatorByAge(SortingType.ASC));

        // do binary search
        int searchAge = 40;
        IBinarySearch binarySearch1 = new BinarySearchIterative();
        IBinarySearch binarySearch2 = new BinarySearchRecursive();
        IBinarySearch binarySearch3 = new BinarySearchBuiltIn();

        int idx1 = binarySearch1.binarySearch(students, searchAge);
        int idx2 = binarySearch2.binarySearch(students, searchAge);
        int idx3 = binarySearch3.binarySearch(students, searchAge);

        // print value
        if (idx1>=0) {
            System.out.println("The Element Age " + searchAge + " is found at " + "index " + idx1);
            System.out.println(students.get(idx1));
        }else{
            System.out.println("no value found");
        }
    }

}
