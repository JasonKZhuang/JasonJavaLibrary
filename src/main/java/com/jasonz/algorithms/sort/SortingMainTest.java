package com.jasonz.algorithms.sort;

import com.jasonz.dataStructures.arrary.ExampleSimpleArray;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 18:26
 * @project JasonJavaLibrary
 * @description:
 */
public class SortingMainTest {

    public static void main(String[] args) {
        int[] myArray;

        //        for (int i = 0; i < 10; i++) {
        //            System.out.println(new Random().nextInt(3));
        //        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        // ===Bubble Sort============================================================= //
        //        myArray = ExampleSimpleArray.initArray(10);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        BubbleSort.bubbleSort(myArray);
        //        System.out.println("=== After bubble sorting ===");
        //        printArray(myArray);

        // ===Optimized Bubble Sort=================================================== //
        //        myArray = ExampleSimpleArray.initArray(50);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        BubbleSort.bubbleSortOptimized(myArray);
        //        System.out.println("=== After optimized bubble sorting ===");
        //        printArray(myArray);

        // ===Selection Sort============================================================= //
        //        myArray = ExampleSimpleArray.initArray(5);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        SelectionSort.selectionSort(myArray);
        //        System.out.println("=== After Selection sorting ===");
        //        printArray(myArray);

        // Pivot selection schemes: first, last, medianOf3, random, hoare
        // ===Basic Quick Sort with the first index as the pivot index================= //
        //        myArray = ExampleSimpleArray.initArray(5);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        QuickSort.quickSort(myArray,0, myArray.length - 1, PivotPosition.first.name());
        //        System.out.println("=== After Quick sorting ===");
        //        printArray(myArray);

        // ===Basic Quick Sort with the end index as the pivot index===================== //
        //        myArray = ExampleSimpleArray.initArray(5);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        QuickSort.quickSort(myArray,0, myArray.length - 1,  PivotPosition.last.name());
        //        System.out.println("=== After Quick sorting ===");
        //        printArray(myArray);

        // ===Optimized Quick Sort with the random index as the pivot index================ //
        //        myArray = ExampleSimpleArray.initArray(5);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        QuickSort.quickSort(myArray,0, myArray.length - 1,  PivotPosition.random.name());
        //        System.out.println("=== After Quick sorting ===");
        //        printArray(myArray);

        // ===Optimized Quick Sort with the medianOf3 =================================== //
        //        myArray = ExampleSimpleArray.initArray(20);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        QuickSort.quickSort(myArray, 0, myArray.length - 1, PivotPosition.medianOf3.name());
        //        System.out.println("=== After Quick sorting ===");
        //        printArray(myArray);

        // ===Optimized Quick Sort with the hoare =================================== //
        //        myArray = ExampleSimpleArray.initArray(5);
        //        System.out.println("=== Before sorting       ===");
        //        printArray(myArray);
        //        QuickSort.quickSort(myArray, 0, myArray.length - 1, PivotPosition.hoare.name());
        //        System.out.println("=== After Quick sorting ===");
        //        printArray(myArray);

        // ===Optimized Quick Sort with the bi direction =================================== //
         myArray = ExampleSimpleArray.initArray(10000 * 600 );
         System.out.println("=== Before sorting       ===");
         // printArray(myArray);
         QuickSort.quickSort(myArray, 0, myArray.length - 1, PivotPosition.biDirections.name());
         System.out.println("=== After Quick sorting ===");
         //printArray(myArray);

        // ===Merge Sort  =================================== //
        myArray = ExampleSimpleArray.initArray(10000 * 1000);
        System.out.println("=== Before sorting       ===");
        // printArray(myArray);

        // using my first sort method
        myArray = MergeSort.sort(myArray);
        // using my second sort method
        MergeSort.sort(myArray, 0, myArray.length - 1);

        System.out.println("=== After Merge sorting ===");
        // printArray(myArray);

        stopWatch.stop();
        long timeTaken = stopWatch.getTime();
        System.out.println("======[ " + timeTaken + " ] milliseconds");

    }

    private static void printArray(int[] argArray) {
        for (int i = 0; i < argArray.length; i++) {
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.printf("%10d | ", argArray[i]);
        }
        System.out.println();
    }
}
