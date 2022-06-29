package com.jasonz.leetcode.arrayAndString;


import java.util.HashMap;
import java.util.Map;

public class ArrayAndString {
    public static void main(String[] args) {
        ArrayAndString ins = new ArrayAndString();
        String s = "pwwkew";
        System.out.println(ins.lengthOfLongestSubstring(s));
    }

    //Given a string s, find the length of the longest substring without repeating characters.
    //https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2961/
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        for (int i = 0; i < (s.length() - 1); i++) {
            for (int j = (i + 1); j < s.length(); j++) {
                String myString = s.substring(i, j);

                boolean isUniqueString = false;
                Map<Character, Character> map = new HashMap<>();
                char[] mySubChars = myString.toCharArray();
                for (int k = 0; k < mySubChars.length; k++) {
                    if (map.get(mySubChars[k]) != null) {
                        isUniqueString = false;
                        break;
                    }
                    map.put(mySubChars[k], mySubChars[k]);
                    isUniqueString = true;
                }

                if (isUniqueString) {
                    if (myString.length() > maxLength) {
                        maxLength = myString.length();
                    }
                }
            }
        }
        return maxLength;
    }

    private boolean isUniqueString(String s) {
        Map<Character, Character> map = new HashMap<>();
        char[] myChars = s.toCharArray();
        for (int i = 0; i < myChars.length; i++) {
            if (map.get(myChars[i]) != null) {
                return false;
            }
            map.put(myChars[i], myChars[i]);
        }
        return true;
    }


    //https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/508/
    public int[] twoSum(int[] nums, int target) {
        int[] retArray = new int[2];
        //[1,2,3,4] 5
        for (int i = 0; i < (nums.length - 1); i++) {
            int first = nums[i];
            for (int j = (i + 1); j < nums.length; j++) {
                int second = nums[j];
                if (target == (first + second)) {
                    retArray[0] = i;
                    retArray[1] = j;
                    return retArray;
                }
            }
        }
        return retArray;
    }
}
