package com.jasonz.dataStructures.arrary;

import java.util.Arrays;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class ExampleBinarySearch {
    public static void main(String[] args) {
        ExampleBinarySearch instance = new ExampleBinarySearch();
        instance.testBinarySearch();
    }

    /**
     * With the help of this method, we can find or search a specified value inside an array which is given as the first argument.
     * As a result, this method returns the index of the element in the array.
     * The array must be sorted for this search.
     * If the element is not found, it returns a negative value.
     */
    private void testBinarySearch() {
        //create arrays
        int array1[] = {20, 34, 56, 78, 97};
        int myValue = 56;
        System.out.println(myValue + " found at index = " + Arrays.binarySearch(array1, myValue));
        System.out.println(20 + " found at index = " + Arrays.binarySearch(array1, 20));
    }
}
