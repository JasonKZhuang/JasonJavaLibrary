package com.jasonz.leetcode.arrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUniqueCharacters {
    public static void main(String[] args) {

    }

    public int uniqueLetterString(String s) {
        int retValue = 0;
        String sub = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                sub = s.substring(i, j);
                retValue = retValue + countUniqueChars(sub);
            }
        }
        return retValue;
    }

    public int countUniqueChars(String s) {
        int count = 0;
        Map<Character, Integer> charCounts = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (charCounts.get(c) == null) {
                charCounts.put(c, 1);
                count = count + 1;
            } else {
                charCounts.put(c, charCounts.get(c) + 1);
                if (charCounts.get(c) == 2) {
                    count = count - 1;
                }
            }
        }
        return count;
    }

    public int uniqueLetterStringOptimal(String s) {
        // Check the occrences of the characters -> from the last till the current occurrence, that character is uniqueue
        Map<Character, List<Integer>> occurrenceMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!occurrenceMap.containsKey(c)) {
                occurrenceMap.put(c, new ArrayList<>());
            }
            occurrenceMap.get(c).add(i);
        }

        int sum = 0;
        for (List<Integer> occrenceList : occurrenceMap.values()) {
            for (int i = 0; i < occrenceList.size(); i++) {
                int left = 0;
                int right = 0;
                int total = 0;
                // For how many characters to the left is the value unique
                if (i == 0) // first occurrence
                    left = occrenceList.get(i) + 1;
                else
                    left = occrenceList.get(i) - occrenceList.get(i - 1);

                // For how many characters to the left is the value unique
                if (i < occrenceList.size() - 1) // first occurrence
                    right = occrenceList.get(i + 1) - occrenceList.get(i);
                else
                    right = s.length() - occrenceList.get(i);
                total = left * right;
                sum += total;
            }
        }
        return sum;
    }
}
