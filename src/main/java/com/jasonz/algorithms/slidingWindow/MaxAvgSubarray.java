package com.jasonz.algorithms.slidingWindow;

/**
 * @author Jason Zhuang
 * @created 2024.01.28 23:23
 * @project JasonJavaLibrary
 * @description: You are given an integer array nums consisting of n elements, and an integer k.
 * <p>
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 * <p>
 * Input: nums = [5], k = 1
 * Output: 5.00000
 */
public class MaxAvgSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(solution(nums, k));
    }

    private static double solution(int[] array, int k) {
        int sum = cal(array, 0, k - 1);
        double maxAvg = (double) sum / k;
        for (int i = 1; i < array.length; i++) {
            if (i <= array.length - k) {
                sum = sum - array[i - 1] + array[i + k - 1];
                maxAvg = Math.max(maxAvg, (double) sum / k);
            }
        }
        return maxAvg;
    }

    private static int cal(int[] array, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}
