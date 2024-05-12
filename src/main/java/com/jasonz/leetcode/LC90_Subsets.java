package com.jasonz.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jason Zhuang
 * @created 2024.02.22 19:08
 * @project JasonJavaLibrary
 * @description: 90. Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 */
public class LC90_Subsets {
    public static void main(String[] args) {
        LC90_Subsets ins = new LC90_Subsets();
        int[] array = new int[]{1, 2, 2, 3};
        System.out.println(ins.subsetsWithDup(array));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retSet = new ArrayList<>();
        retSet.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<Integer> elementList = new ArrayList<>();
            elementList.add(nums[i]);
            retSet.add(elementList);
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> elementList2 = new ArrayList<>();
                elementList2.add(nums[i]);
                elementList2.add(nums[j]);
                retSet.add(elementList);
            }
        }
        return null;


    }

    private void add(List<List<Integer>> retSet, int[] nums, List<Integer> original, int nextIdx) {
        retSet.add(original);

        List<Integer> newList = original.stream().collect(Collectors.toList());
        newList.add(nums[nextIdx]);
        add(retSet, nums, newList, nextIdx + 1);
    }

}