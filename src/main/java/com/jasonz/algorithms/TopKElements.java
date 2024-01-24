package com.jasonz.algorithms;

import com.jasonz.algorithms.sort.InsertionSort;
import com.jasonz.algorithms.sort.MergeSort;
import com.jasonz.algorithms.sort.PivotPosition;
import com.jasonz.algorithms.sort.QuickSort;
import com.jasonz.dataStructures.arrary.ExampleSimpleArray;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.01.23 20:44
 * @project JasonJavaLibrary
 * @description:
 * finding the k largest or smallest element in an array
 * finding the top K Frequent elements
 *
 */
public class TopKElements {

    public static void main(String[] args) {
        int[] myArray = ExampleSimpleArray.initArray(1000);
        // ExampleSimpleArray.printArray(myArray);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        int[] result = getTopKBySorting(myArray, 3);

        stopWatch.stop();
        long timeTaken = stopWatch.getTime();
        System.out.println("====[ " + timeTaken + " ] milliseconds ====");

        ExampleSimpleArray.printArray(result);
    }

    private static int[] getTopKBySorting(int[] array, int k){

        if (array.length < 50){
            InsertionSort.sort(array);
        }else if (array.length < 1000000){
            array =  MergeSort.sort(array);
        } else {
            QuickSort.sort(array, 0, array.length - 1, PivotPosition.dualPivot.name());
        }

        return Arrays.copyOfRange(array,array.length -k, array.length);
    }

    private static int[] getTopKByHeap(int[] array, int k){
        return null;
    }

}
