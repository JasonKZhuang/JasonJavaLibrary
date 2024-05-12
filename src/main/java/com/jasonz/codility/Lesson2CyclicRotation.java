package com.jasonz.codility;

import com.jasonz.utilities.GenerateExampleData;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.03.22 18:39
 * @project JasonJavaLibrary
 * @description: An array Lesson6Distinct consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array Lesson6Distinct = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array Lesson6Distinct K times; that is, each element of Lesson6Distinct will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] Lesson6Distinct, int K); }
 * <p>
 * that, given an array Lesson6Distinct consisting of N integers and an integer K, returns the array Lesson6Distinct rotated K times.
 * <p>
 * For example, given
 * <p>
 * Lesson6Distinct = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 *
 * For another example, given
 * <p>
 * Lesson6Distinct = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * Lesson6Distinct = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array Lesson6Distinct is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class Lesson2CyclicRotation {
    private static final int num = 10;//10000 * 10000;

    public static void main(String[] args) {
        int k =0;
        int[] arr1 = GenerateExampleData.generateRandomIntArray(num);
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        int rotatedTimes = 3;
        rotationLeftOnePosition(arr1, rotatedTimes);
        Arrays.stream(arr1).forEach((i) -> System.out.print(i + "\t"));

        System.out.println("\n ====================================");
        arr2 = rotationLeft(arr2, rotatedTimes);
        Arrays.stream(arr2).forEach((i) -> System.out.print(i + "\t"));

        System.out.println("\n ====================================");
        int[] arr3 = {3, 8, 9, 7, 6};
        int[] result3 = solution(arr3, 10);
        Arrays.stream(result3).forEach((i) -> System.out.print(i + "\t"));

        System.out.println("====================================");
        // N and K are integers within the range [0..100];
        int[] arr4 = {1,2,3,4}; // expect [9, 7, 6, 3, 8]
        k=5;
        int[] result4 = solutionBest(arr4, k);
        // expect [9, 7, 6, 3, 8]
        Arrays.stream(result4).forEach((i) -> System.out.print(i + "\t"));





    }

    private static void rotationLeftOnePosition(int[] arr, int d) {
        for (int k = 0; k < d; k++) {
            int first = arr[0];
            int len = arr.length;
            for (int i = 1; i < len; i++) {
                arr[i - 1] = arr[i];
            }
            arr[len - 1] = first;
        }
    }

    private static int[] rotationLeft(int[] arr, int d) {
        int[] temp = new int[arr.length];
        int[] first = new int[d];
        int[] last = new int[arr.length - d];
        System.arraycopy(arr, 0, first, 0, d);
        System.arraycopy(arr, d, last, 0, arr.length - d);

        System.arraycopy(last, 0, temp, 0, last.length);
        System.arraycopy(first, 0, temp, arr.length - d, first.length);
        return temp;
    }

    public static int[] solution(int[] A, int K) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        if (A.length == 1) {
            return A;
        }
        if (K == 0) {
            return A;
        }
        // copy array
        if (K <= A.length) {
            int[] temp = new int[A.length];
            int[] first = new int[K];
            int[] last = new int[A.length - K];
            System.arraycopy(A, A.length - K, first, 0, K);
            System.arraycopy(A, 0, last, 0, A.length - K);

            System.arraycopy(first, 0, temp, 0, first.length);
            System.arraycopy(last, 0, temp, first.length, last.length);
            return temp;
        } else {
            int len = A.length;
            for (int p = 0; p < K; p++) {
                // store last to a temp variable,
                int lastValue = A[A.length - 1];
                // from right to left move one step
                for (int i = (len - 2); i >= 0; i--) {
                    A[i + 1] = A[i];
                }
                // assign the temp variable to the first element
                A[0] = lastValue;
            }
            return A;
        }
    }

    public static int[] solutionBest(int[] A, int K) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }

        int len = A.length;
        if (len == 1) {
            return A;
        }

        if (K == 0) {
            return A;
        }

        // get mod
        int t = K % len;

        // a new array same length as A
        int[] temp = new int[len];
        // src – the source array.
        // srcPos – starting position in the source array.
        // dest – the destination array.
        // destPos – starting position in the destination data. length – the number of array elements to be copied.
        // copy from t to the end of A to temp
        // int[] arr4 = {3, 8, 9, 7, 6}; // expect [9, 7, 6, 3, 8]

        int rightStart = len - t; // 5-3 = 2
        int rightLength =len - rightStart; // 5 - 2 = 3
        int leftStart = 0; // 0
        int leftLength = len - rightLength; // 5- 3 = 2
        System.arraycopy(A, rightStart, temp, 0, rightLength);
        // copy from 0 to t of A to temp
        System.arraycopy(A, leftStart, temp, t, leftLength);

        return temp;

    }


}
