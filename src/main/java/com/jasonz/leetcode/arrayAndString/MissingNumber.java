package com.jasonz.leetcode.arrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 15:35
 * @project JasonJavaLibrary
 * @description: 268. Missing Number
 * https://leetcode.com/problems/missing-number/description/
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] array = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(solutionSort(array));
    }

    private static int solutionSort(int[] array) {
        Arrays.sort(array);
        int n = array.length;
        for (int i = 0; i <= n; i++) {
            if (i >= n) {
                return i;
            } else if (i != array[i]) {
                return i;
            }
        }
        return -1;
    }

    public int solutionSet(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        // add all numbers into a set (unique)
        for (int num : nums) {
            mySet.add(num);
        }

        //Since there is a missing, so the assume numbers of array is nums.length + 1
        int  assumeCount = nums.length + 1;
        for (int i = 0; i <assumeCount; i++) {

            if (!mySet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int solution2(int[] nums) {
        int sum = 0;
        sum = (
                (nums.length * (nums.length + 1) / 2)
        );
        //int i  = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }

}
