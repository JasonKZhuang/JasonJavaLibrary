package com.jasonz.leetcode.arrayAndString;

import java.util.Arrays;

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * Example 1:
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int n = 3;
        ShuffleArray ins = new ShuffleArray();
        int[] result = ins.shuffle(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[nums.length];
        for (int i = 0, j = n; i < n; i++, j++) {
            ret[(i * 2)] = nums[i];
            ret[(i * 2 + 1)] = nums[j];
        }
        return ret;
    }

    public int[] shuffle2(int[] nums, int n) {
        int[] ans = new int[n * 2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            ans[count++] = nums[i];
            ans[count++] = nums[i + n];
        }
        return ans;
    }
}
