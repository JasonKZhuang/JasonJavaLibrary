package com.jasonz.codility;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.05.02 13:00
 * @project JasonJavaLibrary
 * @description: An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)],
 * which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 *
 * []
 * [1]
 * [2]
 * [2,3]
 * [1,2]
 * [1,3]
 * [1,2,3]
 * [2,3,4]
 * [1,4,3]
 * [2, 3, 1, 5]
 * the function should return 4, as it is the missing element.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
public class Lesson3PermMissingElem {
    public static void main(String[] args) {
        // n is length
        // data from 1 to n+1
        // 1,2,3,4,5
        int[] A = {5,4,3,1};

        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A==null || A.length == 0 ) {
            return 1;
        }
        int N = A.length;
        // min element
        int min = 1;
        // max element
        int max = N+1;
        // sorting
        Arrays.sort(A);
        // missing the min element
        if (A[0] != min) {
            return min;
        }
        // missing the max element
        if (A[N-1] != max) {
            return max;
        }
        // missing the middle element
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return A[i] + 1;
            }
        }

        return 1;
    }

}
