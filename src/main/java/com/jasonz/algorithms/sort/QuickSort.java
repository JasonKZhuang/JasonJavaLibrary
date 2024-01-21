package com.jasonz.algorithms.sort;

import java.util.Random;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        //        Arrays.sort();

        // pick a random index between start and end as the pivot index
        // pivotIndex = (int) (start + Math.random() * (end - start + 1));
        // pick the lowest index
        // pivotIndex = start;
        // pick the highest index
        // pivotIndex = end;
        // pick the middle index
        // pivotIndex = (int) (end - start)/2;
    }

    /**
     * 快速排序方法
     *
     * @param argArray
     * @param startIndex
     * @param endIndex
     * @return Complexity Analysis:
     * Time Complexity:
     * Average Case: O(N * logN), where N is the length of the array.
     * Best Case: O(N * logN)
     * Worst Case: O(N2)
     * Auxiliary Space: O(1)
     */
    public static void quickSort(int[] argArray, int startIndex, int endIndex, String argPivotPosition) {
        if (argArray.length < 1
                || startIndex < 0
                || endIndex >= argArray.length
                || startIndex > endIndex) {
            return;
        }
        // idx is index of pivot element which is at its sorted position
        int idx = 0;
        switch (argPivotPosition) {
            case "first" -> idx = partitionPivotFirst(argArray, startIndex, endIndex);
            case "last" -> idx = partitionPivotLast(argArray, startIndex, endIndex);
            case "middle" -> idx = partitionPivotMiddle(argArray, startIndex, endIndex);
            case "random" -> idx = partitionPivotRandom(argArray, startIndex, endIndex);
            // idx is partitioning index, arr[p] is now  at right place
            case "hoare" -> idx = partitionPivotWithHoare(argArray, startIndex, endIndex);
            default -> throw new IllegalArgumentException("Invalid pivot position: " + argPivotPosition
                    + ". It should be one of first,last,middle,random");
        }

        // if it is hoare partition scheme
        if (argPivotPosition.equals(PivotPosition.hoare.name())) {
            if (startIndex < endIndex) {
                // Separately sort elements before partition and after partition
                quickSort(argArray, startIndex, idx, PivotPosition.hoare.name());
                quickSort(argArray, idx + 1, endIndex, PivotPosition.hoare.name());
            }
        }else {
            // Separately sort elements before partition and after partition
            if (idx > startIndex)
                quickSort(argArray, startIndex, idx - 1, argPivotPosition);

            if (idx < endIndex)
                quickSort(argArray, idx + 1, endIndex, argPivotPosition);
        }
    }

    /**
     * 快速排序算法——partition, // First element as pivot
     *
     * @param argArray
     * @param start
     * @param end
     * @return
     */
    private static int partitionPivotFirst(int[] argArray, int start, int end) {

        // setting the starting index value is the pivot value
        int pivot = argArray[start];

        // k index was the previous swap position
        int k = end;

        //from right to (left + 1)
        for (int i = end; i > start; i--) {
            // compare every value with pivot value
            // if i value is greater then pivot
            if (argArray[i] > pivot) {
                // swap i value with the index value
                swap(argArray, i, k);
                k--;
            }
        }
        swap(argArray, start, k);
        return k;
    }

    /**
     * 快速排序算法——partition, // Last element as pivot
     *
     * @param argArray
     * @param start
     * @param end
     * @return
     */
    private static int partitionPivotLast(int[] argArray, int start, int end) {
        // pivot value (right most element)
        int pivot = argArray[end];

        // a position the smaller (than pivot) values
        int k = start;

        // from left to right
        for (int i = start; i < end; i++) {
            // if current value is less than pivot
            // swap the value with value at a small-value-position k
            // increase the small-value-position k
            if (argArray[i] < pivot) {
                swap(argArray, i, k);
                k++;
            }
            //if not less than, do nothing
        }

        // after all the small values to pivot have been sorted,
        // then swap the pivot position value with the current k
        // which means all right values of pivot is less than pivot
        swap(argArray, end, k);

        return k;
    }

    private static int partitionPivotMiddle(int[] argArray, int start, int end) {
        return 0;
    }

    private static int partitionPivotRandom(int[] argArray, int start, int end) {

        // This helps in calculating random numbers between low(inclusive) and high(inclusive)
        int pivotIdx = start + new Random().nextInt(end - start);
        // actually swap the pivotIndex with the end index
        swap(argArray, pivotIdx, end);
        // call the partition Pivot Last
        return partitionPivotLast(argArray, start, end);

    }


    /**
     * @param argArray
     * @param start
     * @param end
     * @return Hoare’s Partition Scheme works by initializing two indexes that start at two ends,
     * the two indexes move toward each other until an inversion is found.
     * (A smaller value on the left side and greater value on the right side)
     * When an inversion is found, two values are swapped and the process is repeated.
     */
    private static int partitionPivotWithHoare(int[] argArray, int start, int end) {

        int pivot = argArray[start];

        int i = start - 1, j = end + 1;

        while (true) {
            // Find leftmost element greater than or equal to pivot
            do {
                i++;
            } while (argArray[i] < pivot);

            // Find rightmost element smaller than or equal to pivot
            do {
                j--;
            } while (argArray[j] > pivot);

            // If two pointers met.
            if (i >= j) {
                return j;
            }

            swap(argArray, i, j);
        }
    }


    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
