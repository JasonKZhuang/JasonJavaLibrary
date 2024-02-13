package com.jasonz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.02.08 13:00
 * @project JasonJavaLibrary
 * @description: 442. Find All Duplicates in an Array
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 * <p>
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * <p>
 * Example 1: *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * <p>
 * Example 2:
 * Input: nums = [1,1,2]
 * Output: [1]
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: []
 */
public class LC442_FindAllDuplicates {
    public static void main(String[] args) {
        int[] array  = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(solutionSortCompareAdjacentElements(array));
        System.out.println(solutionSet(array));
    }

    private static ArrayList<Integer> solutionSortCompareAdjacentElements(int[] array) {
        ArrayList<Integer> retArray = new ArrayList<>();
        Arrays.sort(array);
        int p = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == p) {
                retArray.add(array[i]);
            }
            p = array[i];
        }
        return retArray;
    }

    private static ArrayList<Integer> solutionSet(int[] array) {
        ArrayList<Integer> retArray = new ArrayList<>();
        Set<Integer> tempSet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (tempSet.contains(array[i])) {
                retArray.add(array[i]);
            }
            tempSet.add(array[i]);
        }
        return retArray;
    }
}
