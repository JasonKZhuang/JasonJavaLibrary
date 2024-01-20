package com.jasonz.algorithms.search;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 15:16
 * @project JasonJavaLibrary
 * @description: this is a very good algorithm
 *
 * Exponential search involves two steps:
 * 1. Find range where element is present
 * 2. Do Binary Search in above found range.
 *
 * How to find the range where element may be present?
 * The idea is to start with subarray size 1, compare its last element with x, then try size 2, then 4 and so on until last element of a subarray is not greater.
 * Once we find an index i (after repeated doubling of i), we know that the element must be present between i/2 and i (Why i/2? because we could not find a greater value in previous iteration)
 * Given below are the implementations of above steps.
 */
public class ExponentialSearch {

    // Returns position of first occurrence of  x in array
    static int exponentialSearch(int[] arr, int n, int x) {
        // If x is present at first location itself
        if (arr[0] == x)
            return 0;

        // Find range for binary search by repeated doubling
        int i = 1;
        while (i < n && x >= arr[i]) {
            i = i * 2;
        }

        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i / 2, Math.min(i, n - 1), x);
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;
        int result = exponentialSearch(arr, arr.length, x);

        System.out.println((result < 0) ?
                "Element is not present in array" :
                "Element is present at index " + result);
    }
}
