package com.jasonz.codility;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.05.02 13:44
 * @project JasonJavaLibrary
 * @description: A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
public class Lesson3TapeEquilibrium {
    public static void main(String[] args) {
        // int[] A = {0, 0};
//        int[] A = {3, 1, 2, 4, 3};
        int[] A = {1, 2, 3, 4, 5}; // sum = 15 //1- 14, 3-12, 6-9, 10-5
        System.out.println(solution(A));
    }

    /**
     * when pointer moving from 0 to N-1
     * the first part is accumulated
     * the last part is calculated by the total sum minus the first part
     * must think about extreme case on both ends
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }

        int s = Arrays.stream(A).sum();
        int firstSum = 0;
        int lastSum = s;
        int minDiff = Integer.MAX_VALUE;
        //int firstSum = A[0] + 0;
        //int lastSum =  s - firstSum;
        for (int i = 0; i < A.length - 1; i++) {
            firstSum = A[i] + firstSum;
            lastSum = s - firstSum;
            int diff = Math.abs(firstSum - lastSum);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
