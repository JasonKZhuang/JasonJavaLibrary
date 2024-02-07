package com.jasonz.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Jason Zhuang
 * @created 2024.02.07 12:04
 * @project JasonJavaLibrary
 * @description: 238. Product of Array Except Self
 * <p>
 * Given an integer array nums,
 * return an array answer such that answer[i] is equal to the product(times) of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1: *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Explain: 24 = 2*3*4, 12= 1*3*4, 8= 1*2*4, 6=1*2*3
 * <p>
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class LC238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] array = new int[]{0,4, 0};
        System.out.println(Arrays.toString(solutionNaive(array)));
        System.out.println(Arrays.toString(solutionSlidingWindow(array)));
    }

    private static int[] solutionNaive(int[] nums) {
        int[] retArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    v = v * nums[j];
                }
            }
            retArray[i] = v;
        }
        return retArray;
    }

    /**
     * my solution
     * @param nums
     * @return
     */
    private static int[] solutionSlidingWindow(int[] nums) {
        int[] retArray = new int[nums.length];
        HashMap<Integer, Integer> zeroMap = new HashMap<>();

        int product = 1;
        // times all elements except zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product = product * nums[i];
            } else {
                zeroMap.put(i, 0);
            }
        }

        // if all elements are zero, then product = 0;
        if (zeroMap.size() == nums.length) {
            product = 0;
        }

        int n = zeroMap.size();

        for (int i = 0; i < nums.length; i++) {
            // there is no zero
            if (n == 0) {
                retArray[i] = product/nums[i];
                continue;
            }
            // there is one zero and not i-Self, which mean others are all not zero
            if (n==1 && zeroMap.get(i) != null) {
                retArray[i] = product;
                continue;
            }
            // there are more than one zero, should assign 0
            retArray[i] = 0;
        }
        return retArray;
    }

    /**
     * @param nums
     * @return
     * Reference:
     * Leetcode solution
     */
    private static int[] solutionTwoPointers(int[] nums){
        int n = nums.length;

        // Initialize two arrays to store products to the left and right of each index
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        // Initialize answer array with the value of 1
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = 1;
        }

        // Calculate products to the left of each index
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Calculate products to the right of each index
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        // Multiply the left and right products to get the final result
        for (int i = 0; i < n; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }

        return answer;
    }
}
