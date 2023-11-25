package com.jasonz.algorithms.sort;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arrInput = new int[]{1, 1, 2, 2, 2, 3, 4, 5, 6, 6, 6, 4, 3, 1};
        int[] arrOutput = QuickSort(arrInput, 0, arrInput.length - 1);
        for (int i = 0; i < arrOutput.length; i++) {
            System.out.print(arrOutput[i] + ",");
        }
    }

    /**
     * 快速排序方法
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int[] QuickSort(int[] array, int startIndex, int endIndex) {
        if (array.length < 1
                || startIndex < 0
                || endIndex >= array.length
                || startIndex > endIndex) {
            return null;
        }
        int smallIndex = partition(array, startIndex, endIndex);
        if (smallIndex > startIndex)
            QuickSort(array, startIndex, smallIndex - 1);
        if (smallIndex < endIndex)
            QuickSort(array, smallIndex + 1, endIndex);
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
