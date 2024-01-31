package com.jasonz.algorithms.search;

import com.jasonz.algorithms.sort.InsertionSort;
import com.jasonz.dataStructures.arrary.ExampleSimpleArray;
import com.jasonz.dataStructures.list.SortingType;
import com.jasonz.dto.Student;
import com.jasonz.dataStructures.list.arrayList.ComparatorByAge;
import com.jasonz.dto.StudentManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.01.24 16:12
 * @project JasonJavaLibrary
 * @description:
 *  * do binary search with three ways
 *  * Iterative
 *  * Recursive
 *  * Collections Built-in
 *  * <p>
 *  * Time Complexity Analysis
 *  * The Best Case occurs when the target element is the middle element of the array.
 *  * The number of comparisons, in this case, is 1. So, the time complexity is O(1).
 *  * <p>
 *  * The Average Case: On average, the target element will be somewhere in the array.
 *  * So, the time complexity will be O(logN).
 *  * <p>
 *  * The Worst Case occurs when the target element is not in the list or it is away from the middle element.
 *  * So, the time complexity will be O(logN).
 */
public class MainTestSearch {

    public static void main(String[] args) {
        int[] myArray = ExampleSimpleArray.initArray(10);
        int target = 999;

        // linear search algorithms
        // System.out.println(LinearSearch.search(myArray,target));
        // System.out.println(SentinelLinerSearch.search(myArray,target));

        // binary search algorithms
        binarySearchInteger();

        // showing how to use Arrays feature functions,
        // including Arrays.sort() and Arrays.binarySearch()
        //usingArraysFeatureFunctions();

    }

    private static void binarySearchInteger(){
        int[] tempArray = ExampleSimpleArray.initArray(100);
        int target = 79;
        InsertionSort.sort(tempArray);

        IBinarySearch binarySearch1 = new BinarySearchIterative();
        IBinarySearch binarySearch2 = new BinarySearchRecursive();
        IBinarySearch binarySearch3 = new BinarySearchBuiltIn();

        int idx1 = binarySearch1.search(tempArray,target);
        System.out.println(idx1);

    }

    private static void binarySearchStudent(){
        // Define a new Arraylist with student objects
        ArrayList<Student> students = new ArrayList<Student>();

        // Example ArrayList Instance, initialize students values
        StudentManager.initStudentList(students, 100);

        // sorting the student list before executing binary search
        students.sort(new ComparatorByAge(SortingType.ASC));

        // do binary search
        int searchAge = 40;
        IBinarySearch binarySearch1 = new BinarySearchIterative();
        IBinarySearch binarySearch2 = new BinarySearchRecursive();
        IBinarySearch binarySearch3 = new BinarySearchBuiltIn();

        // press command + T, or command + option + B, shortcuts
        int idx1 = binarySearch1.search(students, searchAge);
        int idx2 = binarySearch2.search(students, searchAge);
        int idx3 = binarySearch3.search(students, searchAge);

        // print value idx1
        if (idx1 >= 0) {
            System.out.println("The Element Age " + searchAge + " is found at " + "index " + idx1);
            System.out.println(students.get(idx1));
        } else {
            System.out.println("no value found");
        }
        // print value idx2
        if (idx2 >= 0) {
            System.out.println("The Element Age " + searchAge + " is found at " + "index " + idx2);
            System.out.println(students.get(idx2));
        } else {
            System.out.println("no value found");
        }
        // print value idx3
        if (idx3 >= 0) {
            System.out.println("The Element Age " + searchAge + " is found at " + "index " + idx3);
            System.out.println(students.get(idx3));
        } else {
            System.out.println("no value found");
        }
    }

    private static void usingArraysFeatureFunctions() {
        // Declaring and initializing byte arrays to search over them
        byte[] byteArr = {10, 20, 15, 22, 35};
        char[] charArr = {'g', 'p', 'q', 'c', 'i'};
        int[] intArr = {10, 20, 15, 22, 35};
        double[] doubleArr = {10.2, 15.1, 2.2, 3.5};
        float[] floatArr = {10.2f, 15.1f, 2.2f, 3.5f};
        short[] shortArr = {10, 20, 15, 22, 35};

        // Using sort() method of Arrays class and passing arrays to be sorted as in arguments


        int fromIndex = 1;
        int toIndex = 3;
        List<Student> studentList = new ArrayList<>();
        StudentManager.initStudentList(studentList,100);

        Arrays.sort(studentList.toArray(new Student[]{}), fromIndex, toIndex,
                Comparator.comparingInt(Student::getAge)
        );
        Arrays.sort(studentList.toArray(new Student[]{}), fromIndex, toIndex,
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        Arrays.sort(studentList.toArray(new Student[]{}), fromIndex, toIndex,
                new ComparatorByAge(SortingType.DESC)
        );

        Arrays.sort(byteArr);
        Arrays.sort(charArr);
        Arrays.sort(intArr);
        Arrays.sort(doubleArr);
        Arrays.sort(floatArr);
        Arrays.sort(shortArr);

        // Primitive datatypes
        byte byteKey = 35;
        char charKey = 'g';
        int intKey = 22;
        double doubleKey = 1.5;
        float floatKey = 35;
        short shortKey = 5;

        // Now in sorted array we will fetch and return elements
        // indicating accessing indexes to show array is really sorted
        // With the help of Arrays.binarySearch() method, we can find or search a specified value inside an array which is given as the first argument.
        // As a result, this method returns the index of the element in the array.
        // The array must be sorted for this search.
        // If the element is not found, it returns a negative value.

        // Print commands where we are implementing
        System.out.println(byteKey + " found at index = " + Arrays.binarySearch(byteArr, byteKey));
        System.out.println(charKey + " found at index = " + Arrays.binarySearch(charArr, charKey));
        System.out.println(intKey + " found at index = " + Arrays.binarySearch(intArr, intKey));
        System.out.println(doubleKey + " found at index = " + Arrays.binarySearch(doubleArr, doubleKey));
        System.out.println(floatKey + " found at index = " + Arrays.binarySearch(floatArr, floatKey));
        System.out.println(shortKey + " found at index = " + Arrays.binarySearch(shortArr, shortKey));
    }

}
