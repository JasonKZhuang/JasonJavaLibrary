package com.jasonz.leetcode.arrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 15:55
 * @project JasonJavaLibrary
 * @description: 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * Given an array of integers nums containing n + 1 integers
 * where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums
 * and uses only constant extra space.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 3, 4, 2};
        System.out.println(solutionSorting(array));
        System.out.println(solutionArray(array));
        System.out.println(solutionSet(array));
    }

    private static int solutionSorting(int[] array) {
        if (array.length < 2) {
            return 0;
        }

        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                return array[i];
            }
        }

        return 0;
    }

    private static int solutionArray(int[] nums) {
        boolean[] visited = new boolean[nums.length + 1];
        for (int i : nums) {
            if (!visited[i])
                visited[i] = true;
            else
                return i;
        }
        return -1;
    }

    private static int solutionTwoPointer(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        return 0;

    }

    private static int solutionSet(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }

}
