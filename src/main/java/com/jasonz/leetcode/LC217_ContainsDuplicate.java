package com.jasonz.leetcode;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 15:05
 * @project JasonJavaLibrary
 * @description: 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class LC217_ContainsDuplicate {
    public static void main(String[] args) {
        int[] myArr = new int[]{1, 2, 3, 1};
        System.out.println(solutionMap(myArr));
        System.out.println(solutionSet(myArr));
        System.out.println(solutionSort(myArr));
    }

    /**
     * using map
     * @param array
     * @return
     */
    private static boolean solutionMap(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {
                return true;
            }
            map.put(array[i], true);
        }
        return false;
    }

    /**
     * using set
     * @param array
     * @return
     */
    private static boolean solutionSet(int[] array) {
        int n = array.length;
        Set<Integer> set = new HashSet<>(n);
        for (int a : array) {
            if (set.contains(a)) {
                return true;
            }
            set.add(a);
        }
        return false;
    }

    /**
     * using sorted feature
     * @param array
     * @return
     */
    private static boolean solutionSort(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] == array[i + 1])
                return true;
        }
        return false;
    }


}
