package com.jasonz.algorithms.twoPointers;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.01.30 18:46
 * @project JasonJavaLibrary
 * @description: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1: *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */

public class TwoSumSortedInputArray {

    public static void main(String[] args) {

        int[] array = {-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(solution(array, target)));
    }

    //O(log(n))
    // Solution thinking ways,
    // Think about final target return  int [index1, index2]
    // Conditions:
    // 1. 1 <= index1 < index2 <= array.length
    // 2. array[i] + array[j] = target, possible using two pointers (left, right) for walking different elements
    // 3. given asc sorted array, possible utilize binary search
    // let us go to implementation
    // time complexity: best o(1), worst(n/2), O(log(n))
    private static int[] solution(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;
        int tempSum = array[left] + array[right];
        while (left < right && tempSum != target) {
            if (target < tempSum) {
                right = right - 1;
            } else if (target > tempSum) {
                left = left + 1;
            }
            tempSum = array[left] + array[right];
        }
        if (tempSum == target) {
            return new int[]{left + 1, right + 1};
        }
        return new int[]{};
    }
}
