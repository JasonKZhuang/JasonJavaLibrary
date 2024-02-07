package com.jasonz.leetcode.arrayAndString;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 18:31
 * @project JasonJavaLibrary
 * @description: 254. Factor Combinations
 * https://leetcode.com/problems/factor-combinations/description/
 * <p>
 * Numbers can be regarded as the product of their factors.
 * <p>
 * For example, 8 = 2 x 2 x 2 = 2 x 4.
 * Given an integer n, return all possible combinations of its factors. You may return the answer in any order.
 * <p>
 * Note that the factors should be in the range [2, n - 1].
 * <p>
 * <p>
 * Example 1:
 * Input: n = 1
 * Output: []
 * <p>
 * Example 2:
 * Input: n = 12
 * Output: [[2,6],[3,4],[2,2,3]]
 * <p>
 * Example 3:
 * Input: n = 37
 * Output: []
 */
public class FactorCombinations {
    private static int[] result = new int[]{};

    public static void main(String[] args) {
        System.out.println( getFactors(40));

    }

    private static List<Integer> doMod(int target) {
        List<Integer> retList = new ArrayList<>();
        int mod = target % 2;
        if (mod == 0) {
            retList.add(2);
            retList.add(target / 2);
        }
        return retList;
    }

    private static List<List<Integer>> divide(int n) {
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 2; i < n / 2; i++) {
            int mod = n % i;
            int factor = n / i;
            if (mod == 0 && i < factor) {
                List<Integer> lst = List.of(i, factor);
                retList.add(lst);
            }
        }
        return retList;
    }


    private static List<List<Integer>> getFactors(int n) {
        // this is the answer
        final List<List<Integer>> ans = new LinkedList<>();

        final Stack<LinkedList<Integer>> stack = new Stack<>();

        stack.push(new LinkedList<>(new LinkedList<>(Arrays.asList(n))));

        while (!stack.isEmpty()) {

            final LinkedList<Integer> factors = stack.pop();
            final int lastFactor = factors.removeLast();

            for (int i = factors.isEmpty() ? 2 : factors.peekLast(); i <= lastFactor / i; ++i) {
                if (lastFactor % i == 0) {
                    // Add i and lastFactor / i.
                    LinkedList<Integer> newFactors = new LinkedList<>(factors);
                    newFactors.add(i);
                    newFactors.add(lastFactor / i);
                    stack.push(newFactors);
                    ans.add(new LinkedList<>(newFactors));
                }
            }
        }
        return ans;
    }
}

