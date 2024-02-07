package com.jasonz.algorithms.sort;

import java.util.Arrays;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 */
public class MergeSort {


    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        if (array.length < 2 ) {
            return Arrays.copyOfRange(array, 0, array.length);
        }

        Arrays.sort(array);

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // return mergeUsingForLoop(sort(left), sort(right));
        return mergeUsingWhileLoop(sort(left), sort(right));


    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] mergeUsingForLoop(int[] left, int[] right) {

        // new merged array to return
        int[] result = new int[left.length + right.length];
        int i=0; //walking on the left array
        int j=0; //walking on the right array

        for (int index = 0; index < result.length; index++) {
            // if left index out of the left length, then put the right value into index
            if (i >= left.length) {
                result[index] = right[j];
                j++;
            }
            // right array has the same principle
            else if (j >= right.length) {
                result[index] = left[i];
                i++;
            }
            // compare left array[i] to right array[j], put the smaller into index
            else if ( right[j] < left[i] ) {
                result[index] = right[j];
                j++;
            } else {
                result[index] = left[i];
                i++;
            }
        }

        return result;
    }

    private static int[] mergeUsingWhileLoop(int[] left, int[] right) {

        // new merged array to return
        int[] result = new int[left.length + right.length];
        int i=0; //walking on the left array
        int j=0; //walking on the right array
        int k=0; //walking on the result array

        while(i<left.length && j<right.length){
            if (left[i] <= right[j]){
                result[k] = left[i];
                i++;
            }else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i<left.length){
            result[k] = left[i];
            i++;
            k++;
        }

        while (j<right.length){
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }


    // Main function that sorts arr[l..r] using merge()
    public static void sort(int[] arr, int l, int r) {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // keep dividing first and second to halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two sub arrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two sub arrays to be merged
        // 0,1,2
        int lLength = m - l + 1;
        int rLength = r - m;

        // Create temp arrays Copy data to left temp arrays
        //  Arrays.copyOfRange(arr, l, m + 1);
        int[] lTemp = new int[lLength];
        for (int i = 0; i < lLength; ++i)
            lTemp[i] = arr[l + i];

        // Create temp arrays Copy data to right temp arrays
        // Arrays.copyOfRange(arr, m + 1, r + 1);
        int[] rTemp = new int[rLength];
        for (int j = 0; j < rLength; ++j)
            rTemp[j] = arr[(m + 1) + j];

        // Merge the temp arrays
        // Initial indices of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < lLength && j < rLength) {

            // if the left smaller than or equal to right, then put left into the new array[k], and move i to next
            if (lTemp[i] <= rTemp[j]) {
                arr[k] = lTemp[i];
                i++;
            }
            // if right is smaller than left, then put right into the new array[k], and move j to next
            else {
                arr[k] = rTemp[j];
                j++;
            }
            // move k index after every comparison
            k++;
        }

        // if last sub array move was right, Copy remaining elements of L[] if any
        while (i < lLength) {
            arr[k] = lTemp[i];
            i++;
            k++;
        }

        // if last sub array move was left, Copy remaining elements of R[] if any
        while (j < rLength) {
            arr[k] = rTemp[j];
            j++;
            k++;
        }
    }


}
