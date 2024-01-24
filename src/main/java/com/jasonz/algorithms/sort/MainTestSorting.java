package com.jasonz.algorithms.sort;

import com.jasonz.dataStructures.arrary.ExampleSimpleArray;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 18:26
 * @project JasonJavaLibrary
 * @description:
 */
public class MainTestSorting {

    public static void main(String[] args) {
        int[] myArray = ExampleSimpleArray.initArray(100000);
        System.out.println("=== Before sorting       ===");
        ExampleSimpleArray.printArray(myArray);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // ===Bubble Sort============================================================= //
        // BubbleSort.bubbleSort(myArray);

        // ===Optimized Bubble Sort=================================================== //
        // BubbleSort.bubbleSortOptimized(myArray);

        // ===Selection Sort============================================================= //
        // SelectionSort.selectionSort(myArray);

        // ===Insertion Sort============================================================= //
         InsertionSort.sort(myArray);


        // Pivot selection schemes: first, last, medianOf3, random, hoare,biDirections, dualPivot
        // === Quick Sort ================= //
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.first.name());
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.last.name());
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.random.name());
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.medianOf3.name());
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.biDirections.name());
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.hoare.name());
        // QuickSort.sort(myArray, 0, myArray.length - 1, PivotPosition.dualPivot.name());

        // ===Merge Sort  =================================== //
        // using my first sort method
        // myArray = MergeSort.sort(myArray);
        // using my second sort method
        // MergeSort.sort(myArray, 0, myArray.length - 1);


        // ===================================================================================== //
        stopWatch.stop();
        long timeTaken = stopWatch.getTime();
        System.out.println("====[ " + timeTaken + " ] milliseconds ====");
         ExampleSimpleArray.printArray(myArray);
        System.out.println("=== End Sorting ===");

    }


}
