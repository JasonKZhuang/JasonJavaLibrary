package com.jasonz.codility;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.05.02 16:31
 * @project JasonJavaLibrary
 * @description: A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
public class Lesson4PermCheck {
    public static void main(String[] args) {
        int[] A = {4, 1, 3 };
        System.out.println(solution(A));
    }

    // (1 to N) n is the length of the array
    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] == (i + 1)) {
                continue;
            }
            return 0;
        }
        return 1;
    }
}
