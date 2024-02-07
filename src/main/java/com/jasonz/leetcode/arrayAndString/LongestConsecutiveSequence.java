package com.jasonz.leetcode.arrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 17:48
 * @project JasonJavaLibrary
 * @description: 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] array = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(solution1(array));
    }

    /**
     * Beats 95.09% of users with Java
     * @param nums
     * @return
     */
    private static int solution1(int[] nums) {
        int max = 0;
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        Arrays.sort(nums);
        int start = 0;
        int i = 1;
        for ( i = 1; i < n; i++) {
            if (nums[i-1] != nums[i]) {
                if (nums[i] - nums[i - 1] == 1) {
                    max = Math.max(max, i - start + 1);
                } else {
                    start = i;
                }
            }else {
                start = start + 1;
            }
        }
        max = Math.max(max, i - start);
        return max;
    }

    private static int solution2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
