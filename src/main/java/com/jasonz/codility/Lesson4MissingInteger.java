package com.jasonz.codility;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.05.02 19:21
 * @project JasonJavaLibrary
 * @description: This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class Lesson4MissingInteger {
    public static void main(String[] args) {
        //int[] A = {1, 3, 6, 4, 1, 2};
        // int[] A = {1, 2, 3};
        int[] A = {-1, -3, 0, 1, 2, 4};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        if (A.length == 1) {
            if (A[0] == 1) {
                return A[0] + 1;
            } else {
                return 1;
            }
        }

        // create a new array with one more element than A
        int[] newA = Arrays.copyOf(A, A.length + 1);
        // sort it
        Arrays.sort(newA);
        // find the index of 0
        int idx = Arrays.binarySearch(newA, 0);

        int pointer = 0;
        int result = 0;
        for (int i = idx + 1; i < newA.length; i++) {

            // if the right side is still 0, then continue
            if (newA[i] == 0) {
                pointer = i;
                continue;
            }

            // check the first NonZero on the right side, if it is 1 or not
            if (i == pointer + 1) {
                if (newA[i] == 1) {
                    result = 1;
                    continue;
                } else {
                    return 1;
                }
            }else {
                // if current value == previous value or
                // current value == previous value + 1, then continue
                if ((newA[i] == newA[i - 1]) || newA[i] == newA[i - 1] + 1) {
                    result = newA[i];
                } else {
                    // else, take previous value, and break
                    result = newA[i - 1];
                    break;
                }
            }
        }
        return result + 1;
    }
}
