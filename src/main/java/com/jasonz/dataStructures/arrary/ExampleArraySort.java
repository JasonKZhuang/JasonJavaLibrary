package com.jasonz.dataStructures.arrary;

import java.util.Arrays;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class ExampleArraySort {
    public static void main(String[] args) {

    }

    public void basicSorting() {
        // Example with an array of integers
        int[] numbers = {5, 2, 8, 1, 6};

        // Use the Arrays.sort() method for primitive types
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }

    /**
     * In the case of sorting objects, the objects in the array must implement the Comparable interface
     * or you can provide a custom comparator using the overloaded sort method.
     */
    public void objectsSorting() {
        // Example with an array of strings
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        // Use the Arrays.sort() method for objects
        Arrays.sort(names);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(names));
    }
}
