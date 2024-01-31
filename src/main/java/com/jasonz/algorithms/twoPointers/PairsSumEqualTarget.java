package com.jasonz.algorithms.twoPointers;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.01.25 13:45
 * @project JasonJavaLibrary
 * @description:
 * Java Program Illustrating Naive Approach to
 * Find if There is a Pair in A[0..N-1] with Given Sum
 */
public class PairsSumEqualTarget {

    public static void main(String[] args) {
        int sumTarget = 17;

        int[] myArray = new int[]{2, 3, 5, 8, 9, 10, 11};

        Arrays.sort(myArray);
        int[] pair1 = isPairSumNaive(myArray, sumTarget);

        int[] pair2 = isPairSumOptimized(myArray, sumTarget);

        System.out.println(Arrays.toString(pair1));
        System.out.println(Arrays.toString(pair2));

    }


    //
    //
    //

    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     * Find a contiguous subarray whose length is equal to k
     * that has the maximum average value and return this value.
     * Any answer with a calculation error less than 10-5 will be accepted.
     * @param array
     * @param k
     * @return
     */
    private static double findMaxAverage(int[] array, int k){
        int sum = 0;
        for(int i = 0; i < k; i ++)
            sum += array[i];
        int maxSum = sum;
        for(int i = k; i < array.length; i ++) {
            sum += array[i] - array[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }

    /**
     * the array must be sorted ASC
     * Time Complexity:  O(n log n) (As sort function is used)
     * Auxiliary Space: O(1), since no extra space has been taken.
     * @param array
     * @param target
     * @return
     */
    private static int[] isPairSumOptimized(int[] array, int target) {
        int i = 0;
        int j= array.length - 1;
        while (i<j){
            int tmpSum = array[i] + array[j];
            if (tmpSum == target){
                return new int[]{i,j};
            }else if (tmpSum < target){
                i++;
            }else {
                j--;
            }
        }
        return new int[]{};
    }

    /**
     * the array must be sorted ASC
     * Time Complexity:  O(n2).
     * Auxiliary Space: O(1)
     * @param array
     * @param target
     * @return
     * This one is Inefficient
     */
    private static int[] isPairSumNaive(int[] array, int target) {

        int N = array.length;

        // Nested for loops for iterations
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // As equal i and j means same element
                if (i == j)
                    // continue keyword skips the execution
                    // for following condition
                    continue;

                // Condition check if pair exists
                if (array[i] + array[j] == target)
                    return new int[]{i, j};

                // By now the array is sorted
                if (array[i] + array[j] > target)
                    // Break keyword to hault the execution
                    break;
            }
        }

        // No pair found with given sum.
        return new int[]{};
    }
}
