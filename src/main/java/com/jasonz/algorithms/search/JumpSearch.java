package com.jasonz.algorithms.search;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 13:51
 * @project JasonJavaLibrary
 * @description: Algorithm steps
 * Jump Search is an algorithm for finding a specific value in a sorted array by jumping through certain steps in the array.
 * The steps are determined by the sqrt of the length of the array.
 * Here is a step-by-step algorithm for the jump search:
 * Determine the step size m by taking the sqrt of the length of the array n.
 * Start at the first element of the array and jump m steps until the value at that position is greater than the target value.
 * Once a value greater than the target is found, perform a linear search starting from the previous step until the target is found or it is clear that the target is not in the array.
 * If the target is found, return its index. If not, return -1 to indicate that the target was not found in the array.
 */
// Java program to implement Jump Search.
public class JumpSearch {
    public static int myJumpSearch(int[] arr, int x) {
        int arrLength = arr.length;

        // Finding block size to be jumped
        int blockSize = (int) Math.floor(Math.sqrt(arrLength));

        // Finding the block where element is present (if it is present)
        int start = 0;
        int end = Math.min(start + blockSize, arrLength);

        // starting from the (blockSize - 1) index, if the target value greater than this starting index value,
        // then move step by size of block size until the max length of array
        for (int minStep = (blockSize - 1); x > arr[minStep]; minStep = Math.min(minStep + blockSize, arrLength)) {
            start = minStep; // temp store starting index
            end = Math.min(minStep + blockSize, arrLength); // temp store ending index
            // if ending equals arr length, which means no value matched
            if (end >= arrLength) {
                return -1;
            }
        }

        // Doing a linear search for x in block beginning with prev.
        while (arr[start] < x) {
            // If we reached next block or end of array, element is not present.
            if (start == end) {
                return -1;
            }
            start++;
        }

        // If element is found
        if (arr[start] == x)
            return start;

        return -1;
    }

    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where element is present (if it is present)
        int prev = 0;
        for (int minStep = Math.min(step, n) - 1; arr[minStep] < x; minStep = Math.min(step, n) - 1) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block beginning with prev.
        while (arr[prev] < x) {
            prev++;

            // If we reached next block or end of array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
    }

    // Driver program to test function
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int x = 1;

        // Find the index of 'x' using Jump Search
        int index1 = jumpSearch(arr, x);
        int index2 = myJumpSearch(arr, x);

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x + " is at index " + index1);
        System.out.println("\nNumber " + x + " is at index " + index2);
    }
}
