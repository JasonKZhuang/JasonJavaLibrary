package com.jasonz.algorithms.cases;

import com.jasonz.dataStructures.arrary.ExampleSimpleArray;

/**
 * @author Jason Zhuang
 * @created 2024.01.23 21:18
 * @project JasonJavaLibrary
 * @description: find the largest substring without repeating characters
 * maximum sum of distinct subarrays with length k
 * find the longest substring with k unique characters in a given string
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        System.out.println(maxSumNaive(arr, k));
        System.out.println(maxSumSlideWindow(arr, k));
        System.out.println(minLengthSumDynamicSlideWindow(arr, 22));
    }

    /**
     * return a minimum length of sub array where sum the sub array equals given value
     *
     * @param array { 1, 4, 2, 10, 2, 3, 1, 0, 20 }
     * @param argSum
     * @return minimum length
     */
    private static int minLengthSumDynamicSlideWindow(int[] array, int argSum) {
        // tracking the minimum value
        int min_length = array.length;

        // the current range and sum of the sliding window
        int s = 0;
        int e = 0;
        int current_sum = 0;

        // extend the sliding window until our criteria is met
        while (e < array.length) {
            current_sum = current_sum + array[e];
            e++;

            // then contract the sliding window until it is no longer meet our condition
            while (s < e && current_sum >= argSum) {
                current_sum = current_sum - array[s];
                s++;

                // update the min_length if this is shorter than the current min
                min_length = Integer.min(min_length, e - s + 1);
            }
        }

        return min_length;

    }


    /**
     * Given an array of integers of size ‘n’,
     * Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
     * Using Sliding Window
     *
     * @param array 1,2,3,4,5,6
     * @param k     3
     */
    private static int maxSumSlideWindow(int[] array, int k) {
        int n = array.length;
        int s = 0;
        int e = s + k - 1;
        int max_sum = cal(array, s, e);
        int window_sum = max_sum;
        // walking from the second element, to (n - k) + 1
        for (int i = 1; i < (n - k + 1); i++) {
            // minus the left-out-of-window, and adding the right-in-window
            window_sum = window_sum - array[i - 1] + array[i + k - 1];
            // compare
            max_sum = Math.max(window_sum, max_sum);
        }
        return max_sum;
    }

    private static int cal(int[] array, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Given an array of integers of size ‘n’,
     * Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
     *
     * @param array 1,2,3,4,5
     * @param k     Time complexity: O(k*n) as it contains two nested loops.
     *              Auxiliary Space: O(1)
     */
    private static int maxSumNaive(int[] array, int k) {
        int n = array.length;// 5
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < (n - k) + 1; i++) {
            int temp_sum = 0;
            for (int j = 0; j < k; j++) {
                temp_sum = temp_sum + array[i + j];
            }
            max_sum = Integer.max(max_sum, temp_sum);
        }
        return max_sum;
    }
}
