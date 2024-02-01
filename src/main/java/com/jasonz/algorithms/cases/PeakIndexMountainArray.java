package com.jasonz.algorithms.cases;

/**
 * @author Jason Zhuang
 * @created 2024.02.01 17:45
 * @project JasonJavaLibrary
 * @description: 852. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * <p>
 * An array arr is a mountain if the following properties hold:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <p>
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * <p>
 * You must solve it in O(log(arr.length)) time complexity.
 * <p>
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 * <p>
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 * <p>
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 */
public class PeakIndexMountainArray {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,0};
        System.out.println(solution(array));
    }

    private static int solution(int[] array) {
        int s = 0;
        int e = array.length -1;
        int m = 0;
        // if there are equal and more than 3 element
        while ((e - s) >= 2) {

            // get the middle index
            m = s + (e - s) / 2;
            // this is the expected m is in the middle of left and right
            // value of mTH element is greater than both left and right
            if (array[m - 1] < array[m] && array[m] > array[m + 1]) {
                return m;
            }
            // the mTH element is on the left ASC array
            else if (array[m - 1] < array[m] && array[m] < array[m + 1]) {
                s = m;
            }
            // the mTH element is on the right DESC array
            else if (array[m - 1] > array[m] && array[m] > array[m + 1]) {
                e = m;
            }
        }
        return m;
    }
}
