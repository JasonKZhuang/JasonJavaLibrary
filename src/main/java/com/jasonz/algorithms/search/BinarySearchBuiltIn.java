package com.jasonz.algorithms.search;

import com.jasonz.dataStructures.list.SortingType;
import com.jasonz.dto.Student;
import com.jasonz.dataStructures.list.arrayList.ComparatorByAge;
import com.jasonz.dataStructures.list.arrayList.ExampleArrayList;
import com.jasonz.dto.StudentManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class BinarySearchBuiltIn implements IBinarySearch {
    @Override
    public int search(int[] argArray, int targetValue) {
        return 0;
    }

    @Override
    public int search(ArrayList<Student> argList, int argAge) {
        // Searching a student with key value argValue.
        // To search that object we create an object of student with age argValue.
        int idx = 0;
        idx = Collections.binarySearch(argList,
                new Student(null, argAge, 0),
                new ComparatorByAge(SortingType.ASC));
        return idx;
    }

    /**
     * @author : Jason Zhuang
     * @date : 21/4/2022
     * @description :
     * do binary search with three ways
     *  Iterative
     *  Recursive
     *  Collections Built-in
     */
    public static class MainTestBinarySearch {

        public static void main(String[] args) {
            // this class instance
            MainTestBinarySearch instance = new MainTestBinarySearch();
            // Define a new Arraylist with student objects
            ArrayList<Student> students = new ArrayList<Student>();

            // Example ArrayList Instance
            ExampleArrayList exampleInstance = new ExampleArrayList();
            StudentManager.initStudentList(students,10);
            // sorting the student list before executing binary search
            Collections.sort(students, new ComparatorByAge(SortingType.ASC));

            // do binary search
            int searchValue = 40;
            IBinarySearch binarySearch1 = new BinarySearchIterative();
            IBinarySearch binarySearch2 = new BinarySearchRecursive();
            IBinarySearch binarySearch3 = new BinarySearchBuiltIn();
            // int idx = binarySearch1.binarySearch(students, searchValue);
            // int idx = binarySearch2.binarySearch(students, searchValue);
            int idx = binarySearch3.search(students, searchValue);

            // print value
            if (idx>=0) {
                System.out.println("The Element Age " + searchValue + " is found at " + "index " + idx);
                System.out.println(students.get(idx));
            }else{
                System.out.println("no value found");
            }
        }

    }
}
