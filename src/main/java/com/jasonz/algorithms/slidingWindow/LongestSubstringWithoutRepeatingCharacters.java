package com.jasonz.algorithms.slidingWindow;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author Jason Zhuang
 * @created 2024.01.30 00:17
 * @project JasonJavaLibrary
 * @description: Given a string s, find the length of the longest substring  without repeating characters.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(solutionNaiveQueue(s));
        System.out.println(solutionSlidingWindow(s));
    }


    public static int solutionSlidingWindow(String s) {
        // this is return value of longest
        int maxLen = 0;
        // window left index
        int l = 0;
        // window right index
        int r = 0;
        // the Character array of the given string
        char[] array = s.toCharArray();
        // the length of the char array
        int n = array.length;
        // to temperately store the unique chars collection
        Map<Character, Boolean> myMap = new HashMap<>();
        // when both left pointer and right pointer of the window smaller than the length
        // walking the right pointer from left to right
        while (l < n && r < n) {
            // if the right pointer element not existing in map,
            // then add it to map and calculate maxLenth
            // then move right pointer one step
            if (myMap.get(array[r]) == null) {
                myMap.put(array[r], true);
                maxLen = Math.max(maxLen, myMap.size());
                r = r + 1;
            }
            // if the right pointer element already exists in map,
            // the window need to slide to right on step
            // we need to do two things:
            // one is remove the left pointer element
            // another is move left pointer to right one step
            // in this situation, the right pointer is pointing the element which duplicating to previous map
            else {
                myMap.remove(array[l]);
                l = l + 1;
            }
        }

        maxLen = Math.max(maxLen, myMap.size());
        return maxLen;
    }

    public static int solutionNaiveQueue(String s) {
        int maxLen = 0;
        int right = 0;
        Queue<Character> queue = new ArrayDeque<>();
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (queue.contains(c)){
                maxLen = Math.max(maxLen, queue.size());
                queue.poll();
            }
            queue.add(c);
        }
        maxLen = Math.max(maxLen, queue.size());
        return maxLen;
    }
}
