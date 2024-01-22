package com.jasonz.algorithms.sort;

import java.util.Random;

/**
 * @author : Jason Zhuang
 * @date : 22/01/2024
 * @description :
 * 最佳情况：T(n) = O(nlog(n))   最差情况：T(n) = O(n^2) or O(nlog(n))   平均情况：T(n) = O(nlogn)
 */
public class QuickSort {

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
     * Worst Case: O(N^2) or  O(N * logN)
     * Auxiliary Space: O(1)
     */
    public static void quickSort(int[] argArray, int startIndex, int endIndex, String argPivotPosition) {
        if (argArray.length < 1
                || startIndex < 0
                || endIndex >= argArray.length
                || startIndex >= endIndex) {
            return;
        }
        // idx is index of pivot element which is at its sorted position
        int idx = 0;
        switch (argPivotPosition) {
            case "first" -> idx = partitionPivotFirst(argArray, startIndex, endIndex);
            case "last" -> idx = partitionPivotLast(argArray, startIndex, endIndex);

            //The median of three quicksort is a variation of the quicksort algorithm
            // that improves the performance by choosing a good pivot element.
            // Instead of always selecting the first or last element as the pivot,
            // this approach selects the median of three elements (the first, middle, and last elements of the array).
            case "medianOf3" -> idx = partitionPivotMedianOf3(argArray, startIndex, endIndex);

            // pick pivot index randomly from array[start, end],
            // so reduce the time complexity in the worst case (given already sorted array)
            case "random" -> idx = partitionPivotRandom(argArray, startIndex, endIndex);

            // idx is partitioning index, arr[p] is now  at right place
            case "hoare" -> idx = partitionPivotWithHoare(argArray, startIndex, endIndex);

            case "biDirections" -> idx = partitionBiDirection(argArray, startIndex, endIndex);

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
        } else {
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
     * @param lowIndex
     * @param highIndex
     * @return
     */
    private static int partitionPivotFirst(int[] argArray, int lowIndex, int highIndex) {

        // setting the starting index value is the pivot value
        int pivot = argArray[lowIndex];

        // k index was the previous swap position
        int k = highIndex;

        //from right to (left + 1)
        for (int i = highIndex; i > lowIndex; i--) {
            // compare every value with pivot value
            // if i value is greater then pivot
            if (argArray[i] > pivot) {
                // swap i value with the index value
                swap(argArray, i, k);
                k--;
            }
        }
        swap(argArray, lowIndex, k);
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

        // pick the pivot value (right most element)
        int pivotValue = argArray[end];

        // a position the smaller (than pivotValue) values
        int k = start;

        // from left to right
        for (int i = start; i < end; i++) {
            // if current value is less than pivotValue
            // swap the value with value at a small-value-position k
            // increase the small-value-position k
            if (argArray[i] < pivotValue) {
                swap(argArray, i, k);
                k++;
            }
            //if not less than, do nothing
        }

        // after all the small values to pivotValue have been sorted,
        // then swap the pivotValue position value with the current k
        // which means all right values of pivotValue is less than pivotValue
        swap(argArray, end, k);

        return k;
    }

    /**
     * Guaranteed O(n log n) for the sorted or reverse array data
     * Pivot is the middle element
     * Slight constant increase in time to select the pivot
     * We always have at least one item to each side of the pivot
     * Using the median-of-3 method will allow us to never have to search the entire list for the right partition,
     * but rather start somewhere in the middle.
     * Therefore, we can avoid the worst-case run-time of O(n^2),
     * and settle at the average run-time of O(n log n)
     *
     * @param argArray
     * @param start
     * @param end
     * @return
     */
    private static int partitionPivotMedianOf3(int[] argArray, int start, int end) {
        if (start >= end) {
            return end;
        }

        // Find the median of three elements
        int mid = start + (end - start) / 2;
        sortThreeValues(argArray, start, mid, end);
        if (argArray.length <= 3) {
            return end;
        }

        // move the middle value to be next-last-index, being as the pivot
        if (mid < end - 1) {
            swap(argArray, mid, end - 1);
        }

        // set pivot index is the next-last-index
        // so now we know the first value is smaller than pivot
        // and the last value is greater than pivot
        // int pivotIndex = end - 1;
        // perform partition Pivot Last
        end = end - 1;

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

    /**
     * It is to be noted that the worst case time complexity of the quick sort will always remain O(n^2)
     * but with randomization's we are decreasing the occurrences of that worst case could be O(nlog(n)).
     *
     * @param argArray
     * @param start
     * @param end
     * @return
     */
    private static int partitionPivotRandom(int[] argArray, int start, int end) {

        // This helps in calculating random numbers between low(inclusive) and high(inclusive)
        // The nextInt() distributed int value between zero (inclusive) and bound (exclusive)
        // nextInt(3) could possible 0,1,2
        // from this random number generator's sequence
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

        int i = start - 1;
        int j = end + 1;

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
     * this one if very good
     *
     * @param argArray
     * @param lowIndex
     * @param highIndex
     * @return
     */
    private static int partitionBiDirection(int[] argArray, int lowIndex, int highIndex) {

        int pivotIdx = lowIndex + new Random().nextInt(highIndex - lowIndex);
        swap(argArray, pivotIdx, highIndex);

        // pick pivot from the last one
        int pivot = argArray[highIndex];

        int lPointer = lowIndex;
        int rPointer = highIndex - 1;

        while (lPointer < rPointer) {

            // move left pointer to right and compare with pivot, if smaller than pivot then move pointer next
            while (argArray[lPointer] <= pivot && lPointer < rPointer) {
                lPointer++;
            }
            // move right pointer to left and compare with pivot, if greater than pivot then move pointer next
            while (argArray[rPointer] >= pivot && rPointer > lPointer) {
                rPointer--;
            }
            swap(argArray, lPointer, rPointer);
        }
        swap(argArray, lPointer, highIndex);

        return lPointer;
    }

    private static void swap(int[] argArray, int i, int j) {
        if (i != j) {
            int temp = argArray[i];
            argArray[i] = argArray[j];
            argArray[j] = temp;
        }
    }

    // Function to efficiently sort three values
    private static void sortThreeValues(int[] argArray, int l, int m, int r) {
        if (argArray[l] > argArray[m]) {
            int temp = argArray[l];
            argArray[l] = argArray[m];
            argArray[m] = temp;
        }

        if (argArray[m] > argArray[r]) {
            int temp = argArray[m];
            argArray[m] = argArray[r];
            argArray[r] = temp;
        }

        if (argArray[l] > argArray[m]) {
            int temp = argArray[l];
            argArray[l] = argArray[m];
            argArray[m] = temp;
        }
    }
}
