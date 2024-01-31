package com.jasonz.dataStructures.arrary;

import com.jasonz.dto.Student;
import com.jasonz.dto.StudentManager;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ArrayOperationExamples {

    public static void main(String[] args) {
        declaresArray();
        copyArray();
        basicOperation();
        sortingIntegerArray();
        sortingIntegerArrayParallel();
        sortingStringArray();
        sortingStudentArray();
        searchingIntegerArray();
        passingArrayAsParameter();
        testCloneOneDimensionArray(ExampleSimpleArray.initArray(10));
        usingArrayStream();
    }

    /**
     * Creating, Initializing, and Accessing an Array
     */
    private static void declaresArray(){
        // declares an array of integers
        int[] anArray;

        // allocates memory for 10 integers
        anArray = new int[10];

        // initialize first element
        anArray[0] = 100;
        // initialize second element
        anArray[1] = 200;
        // and so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        System.out.println("Element at index 0: " + anArray[0]);
        System.out.println("Element at index 1: " + anArray[1]);
        System.out.println("Element at index 2: " + anArray[2]);
        System.out.println("Element at index 3: " + anArray[3]);
        System.out.println("Element at index 4: " + anArray[4]);
        System.out.println("Element at index 5: " + anArray[5]);
        System.out.println("Element at index 6: " + anArray[6]);
        System.out.println("Element at index 7: " + anArray[7]);
        System.out.println("Element at index 8: " + anArray[8]);
        System.out.println("Element at index 9: " + anArray[9]);

       List<String> myStringList = Arrays.asList("a","b","c");
    }

    /**
     * Copying Arrays and Array Manipulations
     */
    private static void copyArray(){
        // Copy array
        String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
                "Marocchino", "Ristretto"
        };

        String[] copyToByArrayCopy = new String[7];
        System.arraycopy(copyFrom, 2, copyToByArrayCopy, 0, 7);
        for (String coffee : copyToByArrayCopy) {
            System.out.print(coffee + " ");
        }

        String[] copyToByOfRange = Arrays.copyOfRange(copyFrom, 2, 9);
        for (String coffee : copyToByOfRange) {
            System.out.print(coffee + " ");
        }
    }

    private static void basicOperation() {
        //创建数组对象
        //数组声明
        int[] scores = new int[100];
        scores[0] = 100;

        //数组长度用变量表示
        int size = 100;
        int[] scores2 = new int[size];

        //数组对象引用, they point to the same array address
        scores2 = scores;

        System.out.println("scores[0]=" + scores[0]);
        System.out.println("scores2[0]=" + scores2[0]);
        // change the value of one array, the other array's value also changed,
        // because they point to the same memory address
        scores2[0] = 200;
        System.out.println("scores[0]=" + scores[0]);
        System.out.println("scores2[0]=" + scores2[0]);
        System.out.println("scores2.equals(scores) is " + scores2.equals(scores));

        //数组初始化
        int[] scores3 = new int[]{1, 2, 3, 4, 5};
        for (int k : scores3) {
            System.out.println(k);
        }

        //多维数组
        String[][] rooms = new String[3][];//三层楼,每层楼有不同的房间数
        //initial the first dimension
        rooms[0] = new String[5];
        rooms[1] = new String[4];
        rooms[2] = new String[3];

        //initial the second dimension
        rooms[0][0] = "Tom";
        rooms[0][4] = "Jemmy";
        rooms[1][0] = "Karen Marsh";
        rooms[1][3] = "Dim work";
        rooms[2][0] = "Chris";
        rooms[2][2] = "Linda";

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.println("rooms[" + i + "][" + j + "] is " + rooms[i][j]);
            }
        }
    }

    private static void sortingIntegerArray(){
        // Example with an array of integers
        int[] numbers = ExampleSimpleArray.initArray(100);
        System.out.println("Before sorting array: " + Arrays.toString(numbers));

        // sorting parts of an integer array
        Arrays.sort(numbers, 5, 10);

        // Use the Arrays.sort() method for primitive types
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }

    private static void sortingIntegerArrayParallel(){
        int count = 1000 * 1000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // Example with an array of integers
        int[] numbers = ExampleSimpleArray.initArray(count);
        // sorting parts of an integer array
        // The sorting algorithm is a Dual-Pivot Quicksort
        Arrays.parallelSort(numbers);

        stopWatch.stop();
        long timeTaken = stopWatch.getTime();
        System.out.println("====SortingIntegerArrayParallel to [" + count+"] records took [ " + timeTaken + " ] milliseconds ====");

    }

    private static void sortingStringArray(){
        // Example with an array of strings
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
        System.out.println("Before sorting array: " + Arrays.toString(names));

        // Use the Arrays.sort() method for objects
        Arrays.sort(names);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(names));
    }

    /**
     * In the case of sorting objects, the objects in the array must implement the Comparable interface
     * or you can provide a custom comparator using the overloaded sort method.
     */
    private static void sortingStudentArray(){
        Student[] students = new Student[10];
        StudentManager.initStudentArray(students,students.length);
        StudentManager.printStudent(students);

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Float.compare(o1.getMarks(), o2.getMarks());
            }
        });

        StudentManager.printStudent(students);
    }

    /**
     * The array must be sorted (as by the sort(int[]) method) prior to making this call.
     * If it is not sorted, the results are undefined.
     * If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
     */
    private static void searchingIntegerArray(){
        int[] numbers =  ExampleSimpleArray.initArray(100);
        int targetValue = 5;
        int foundIndex = 0;
        // using linear search
        for (int i = 0; i < numbers.length ; i++) {
            if (numbers[i] == targetValue) {
                foundIndex = i;
                break;
            }
        }

        // Use the Arrays.sort() method for primitive types
        Arrays.sort(numbers);
        // use binary search
        foundIndex = Arrays.binarySearch(numbers, targetValue);
        System.out.println("searchingIntegerArray: " + foundIndex);
    }

    private static void passingArrayAsParameter(){
        //
        int[] myArray = ExampleSimpleArray.initArray(10);
        int[] newArray = updateArrayPassingReference(myArray);
        // after update the value of array, the myArray and newArray are same one

        for (int v : myArray) {
            System.out.println(v);
        }
        for (int v : newArray) {
            System.out.println(v);
        }
        //the conclusion is:
        // passing array as parameter is only passing the reference (memory address)
        // pay attention to ArrayIndexOutOFBoundExceptions
    }

    private static int[] updateArrayPassingReference(int[] argArray) {
        int[] newArray = argArray;
        for (int i = 0; i < argArray.length; i++) {
            newArray[i] = argArray[i] * 2;
        }
        return newArray;
    }

    private static int[] testCloneOneDimensionArray(int[] arg) {
        int clonedArray[] = arg.clone();
        for (int i = 0; i < clonedArray.length; i++) {
            clonedArray[i] = clonedArray[i] * 10;
        }
        return clonedArray;
    }

    private static int[][] testCloneTwoDimensionArray(int[][] arg) {
        int clonedArray[][] = arg.clone();
        for (int i = 0; i < clonedArray.length; i++) {
            for (int j = 0; j < clonedArray[i].length; j++) {
                clonedArray[i][j] = clonedArray[i][j] * 10;
            }
        }
        return clonedArray;
    }

    private void printArrayOne(String msg, int[] arg){
        System.out.println(msg);
        for (int v : arg) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printArrayTwo(String msg, int[][] arg){
        System.out.println(msg);
        for (int[] h : arg) {
            for(int v : h){
                System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void usingArrayStream(){
        int[] numbers = ExampleSimpleArray.initArray(10);
        Arrays.stream(numbers).map(i->i+5).forEach(System.out::println);
    }
}