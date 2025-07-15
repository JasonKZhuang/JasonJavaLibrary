package com.jasonz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2025.07.15 07:43
 * @project JasonJavaLibrary
 * @description: Given a positive integer n, the task is to find whether this number reaches 1 after performing the following two operations:-
 * If n is even, then n = n/2.
 * If n is odd, then n = 3*n + 1.
 * Repeat the above steps, until it becomes 1.
 * For example, for n = 12, we get the sequence 12, 6, 3, 10, 5, 16, 8, 4, 2, 1.
 */
public class CollatzConjecture {

    public static void main(String[] args) {
        long n = 100000;
        for (long i = 0; i < n; i++) {
            List<Long> result = new ArrayList<>();
            reachesOne(i + 1, result);
            if (result.get(result.size() - 1) != 1) {
                System.out.println("\nReached 1: false");
            }
            if (!isToOne(i + 1)) {
                System.out.printf("Input %d is not a positive integer.%n", i + 1);
            }
        }
    }

    /**
     * This method checks if the number n reaches 1 by applying the Collatz conjecture rules.
     *
     * @param n
     * @param result
     */
    private static void reachesOne(long n, List<Long> result) {
        if (n <= 0) {
            System.out.printf("Input %d must be a positive integer.%n", n);
        }
        if (result == null) {
            result = new ArrayList<>();
        }
        if (result.isEmpty()) {
            result.add(n);
        }
        if (n == 1) {
            return;
        }
        if (n % 2 == 0) { // If n is even, then n = n/2.
            n = n / 2;

        } else { // If n is odd, then n = 3*n + 1.
            n = 3L * n + 1;
        }
        result.add(n);
        reachesOne(n, result);
    }

    private static boolean isToOne(long n) {
        return n > 0;
    }

}
