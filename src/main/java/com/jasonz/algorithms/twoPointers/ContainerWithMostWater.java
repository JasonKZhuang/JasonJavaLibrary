package com.jasonz.algorithms.twoPointers;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.01.31 09:55
 * @project JasonJavaLibrary
 * @description: https://leetcode.com/problems/container-with-most-water/description/
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * x = index8 - index1 = 7, the number of slots
 * y = 7, which is the min height that water not overflow
 * <p>
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solutionClearer(array));
        System.out.println(solutionFaster(array));

    }

    // Analyze the question:
    // output: int value the maximum amount of water (the slots * the height of tank)
    // the slots = right - left
    // height compare right and left , get min(left, right)
    // left , right pointer
    // condition:
    //    (left < right)
    // cal and min
    // Time complexity O(n)
    private static int solutionClearer(int[] array) {
        // pointer left
        int left = 0;
        // pointer right
        int right = array.length - 1;
        // return value max volume
        int max = 0;

        while (left < right) {
            // get wide of tank
            int w = right - left;
            // get the min height of tank
            int h = Math.min(array[left], array[right]);
            // cal volume, and comparing for max volume
            max = Math.max(max, w * h);
            // this is the key part, how do we decide how to move left or right pointers
            // every time we want to increase the short edge of tank
            // so, when comparing the two heights (left, right),
            // we need to move the pointer where it is at the shorter edge
            if (array[left] < array[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }

        return max;
    }

    private static int solutionFaster(int[] array) {
        // pointer left
        int left = 0;
        // pointer right
        int right = array.length - 1;
        // return value max volume
        int max = 0;

        while (left < right) {
            // get wide of tank
            int w = right - left;
            // get the min height of tank
            int h = Math.min(array[left], array[right]);
            // cal volume, and comparing for max volume
            max = Math.max(max, w * h);
            // this is the key part, how do we decide how to move left or right pointers
            // every time we want to increase the short edge of tank
            // so, when comparing the left with h and comparing right with h
            // we need to move the pointer where it is at the shorter edge
            while (array[left] <= h && left<right){
                left = left + 1;
            }
            while (array[right] <= h && left<right){
                right = right - 1;
            }
        }

        return max;
    }
}
