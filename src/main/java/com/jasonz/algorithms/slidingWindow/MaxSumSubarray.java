package com.jasonz.algorithms.slidingWindow;

/**
 * @author Jason Zhuang
 * @created 2024.01.28 23:41
 * @project JasonJavaLibrary
 * @description:
 */
public class MaxSumSubarray {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        System.out.println(maxSumNaive(arr, k));
        System.out.println(maxSumSlideWindow(arr, k));
    }


    /**
     * Given an array of integers of size ‘n’,
     * Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
     * Using Sliding Window
     *
     * @param array 1,2,3,4,5,6
     * @param k     3
     */
    private static int maxSumSlideWindow(int[] array, int k) {
        int n = array.length;
        int s = 0;
        int e = s + k - 1;
        int max_sum = cal(array, s, e);
        int window_sum = max_sum;
        // walking from the second element, to (n - k) + 1
        for (int i = 1; i < (n - k + 1); i++) {
            // minus the left-out-of-window, and adding the right-in-window
            window_sum = window_sum - array[i - 1] + array[i + k - 1];
            // compare
            max_sum = Math.max(window_sum, max_sum);
        }
        return max_sum;
    }


    /**
     * Given an array of integers of size ‘n’,
     * Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
     *
     * @param array 1,2,3,4,5
     * @param k     Time complexity: O(k*n) as it contains two nested loops.
     *              Auxiliary Space: O(1)
     */
    private static int maxSumNaive(int[] array, int k) {
        int n = array.length;// 5
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < (n - k) + 1; i++) {
            int temp_sum = 0;
            for (int j = 0; j < k; j++) {
                temp_sum = temp_sum + array[i + j];
            }
            max_sum = Integer.max(max_sum, temp_sum);
        }
        return max_sum;
    }


    private static int cal(int[] array, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += array[i];
        }
        return sum;
    }

}
