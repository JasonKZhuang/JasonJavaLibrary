package com.jasonz.codility;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.05.02 17:07
 * @project JasonJavaLibrary
 * @description: You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * <p>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
public class Lesson4MaxCounters {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        //        int N = 1;
        //        int[] A = {1};
        int[] result = solution(N, A);
        Arrays.stream(result).forEach((i) -> System.out.print(i + "\t"));
    }

    public static int[] solution(int N, int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] counters = new int[N];
        int len = A.length;
        int maxValue = 0;
        int minValueForEachLine = 0;
        for (int k = 0; k < len; k++) {
            int idx = A[k];
            if (idx >= 1 && idx <= N) {
                counters[idx - 1] = Math.max((counters[idx - 1] + 1), (minValueForEachLine + 1));
                maxValue = Math.max(maxValue, counters[idx - 1]);
            } else if (idx == N + 1) {
                // we need to ignore the process in the middle, to remember the minimum value for each line
                minValueForEachLine = maxValue;
            }
        }

        // update the final counters array filled the base minimum value for each line
        for(int i=0; i<counters.length; i++){
            counters[i] = Math.max(counters[i], minValueForEachLine);
        }

        return counters;
    }
}
