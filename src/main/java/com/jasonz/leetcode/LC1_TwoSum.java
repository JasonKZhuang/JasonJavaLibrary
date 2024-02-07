package com.jasonz.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Jason Zhuang
 * @created 2024.02.04 22:08
 * @project JasonJavaLibrary
 * @description: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class LC1_TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(solutionByFindMap(nums, target)));
        System.out.println(Arrays.toString(solutionByReduce(nums, target)));
    }

    private static int[] solutionByReduce(int[] nums, int target) {

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // every time plus from the i value, because the value before i has been tested
                if (nums[j] + nums[j - i] == target) {
                    return new int[]{j, j - i};
                }
            }
        }
        return null;
    }

    private static int[] solutionByFindMap(int[] nums, int target) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) !=null){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    private static int[] solutionByFullMap(int[] nums, int target) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length;i++){
            int v = target - map.get(nums[i]);
            if (map.get(v) != null && map.get(v) != i){
                return new int[]{i,map.get(nums[i])};
            }
        }
        return new int[]{};
    }

    private static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int v = nums[i] + nums[j];
                if (v == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }




}
