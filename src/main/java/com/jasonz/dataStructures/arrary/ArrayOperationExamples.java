package com.jasonz.dataStructures.arrary;

import com.jasonz.dto.Student;
import com.jasonz.dto.StudentManager;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class ArrayOperationExamples {

    public static void main(String[] args) {
//        declaresArray();
//        initializeArray();
//        copyArray();
//        basicOperation();
//        sortingIntegerArray();
//        sortingIntegerArrayParallel();
//        sortingStringArray();
//        sortingStudentArray();
//        searchingIntegerArray();
//        passingArrayAsParameter();
//        testCloneOneDimensionArray(ExampleSimpleArray.initArray(10));
//        usingArrayStream();
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
    }

    // Sure, here are several ways to initialize an array in Java:
    private static void initializeArray(){
        // 1. **Initializing with specified values:**
        int[] numbers1 = {1, 2, 3, 4, 5};

        // 2. **Initializing with a specified size:**
        int[] numbers2 = new int[5];

        // 3. **Initializing with a specified size and filling with a default value:**
        int size3 = 5;
        int defaultValue = 0;
        int[] numbers3 = new int[size3];
        Arrays.fill(numbers3, defaultValue);// fill all values with default value
        Arrays.stream(numbers3).forEach((i) -> System.out.print(i + "\t"));

        // 4. **Initializing with a range of values using a loop:**
        int size4 = 5;
        int[] numbers4 = new int[size4];
        for (int i = 0; i < size4; i++) {
            numbers4[i] = i + 1; // Fill the array with values from 1 to size
        }
        Arrays.stream(numbers4).forEach((i) -> System.out.print(i + "\t"));

        //5. **Initializing a multi-dimensional array:**
        int rows = 3;
        int cols = 3;
        int[][] matrix5 = new int[rows][cols]; // Initialize a 3x3 matrix with all elements initialized to 0

        // 6. **Initializing an array with an anonymous array:**
        int[] numbers6 = new int[]{1, 2, 3, 4, 5}; // Initialize with specified values using an anonymous array

        //7. **Initializing an array with values from another array:**
        int[] sourceArray = {1, 2, 3, 4, 5};
        
    }


    /**
     * Copying Arrays and Array Manipulations
     */
    private static void copyArray(){
        
        int[] sourceArray = {1, 2, 3, 4, 5};
        // copy an original array with a length
        int[] newArray7 = Arrays.copyOf(sourceArray, sourceArray.length);
        // the tail without value from original array will be filled with 0
        int[] newArray71 = Arrays.copyOf(sourceArray, sourceArray.length + 1);
        // copy an original array from start index to end index
        int[] newArray8 = Arrays.copyOfRange(sourceArray,1,sourceArray.length);
        // the tail without value from original array will be filled with 0
        int[] newArray81 = Arrays.copyOfRange(sourceArray,1,sourceArray.length+ 1);
        //
        int[] newArray9 = new int[sourceArray.length];
        System.arraycopy(sourceArray, 0, newArray9, 0, sourceArray.length);
        System.arraycopy(sourceArray, 1, newArray9, 2, sourceArray.length -2);
        System.out.println("\n === newArray9 === ");
        Arrays.stream(newArray9).forEach((i) -> System.out.print(i + "\t"));
        
        // Copy array
        String[] originalArray = {
                "Cappuccino", "Espresso", "Lite","LongBlack", "White",
                "Cappuccino", "Espresso", "Lite","LongBlack", "White",
        };

        String[] copyToByArrayCopy = new String[7];
        System.arraycopy(originalArray, 2, copyToByArrayCopy, 0, 7);
        originalArray[0]= "ZZZZZ";
        System.out.println("\n === old from array === ");
        Arrays.stream(originalArray).forEach((i) -> System.out.print(i + "\t"));
        System.out.println("\n === first new array === ");
        Arrays.stream(copyToByArrayCopy).forEach((i) -> System.out.print(i + "\t"));

        String[] copyToByOfRange = Arrays.copyOfRange(originalArray, 2, 9);
        originalArray[0]= "AAAAAAAAA";
        System.out.println("\n === old from array === ");
        Arrays.stream(originalArray).forEach((i) -> System.out.print(i + "\t"));
        System.out.println("\n === second new array === ");
        Arrays.stream(copyToByOfRange).forEach((i) -> System.out.print(i + "\t"));
        System.out.println();
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

        // sort student object by marks
        // implement Comparator interface and override the compare method
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
        for (int i = 0; i < argArray.length; i++) {
            argArray[i] = argArray[i] * 2;
        }
        // return the same pointer reference
        return argArray;
    }

    private static int[] testCloneOneDimensionArray(int[] arg) {
        int[] clonedArray = arg.clone();
        for (int i = 0; i < clonedArray.length; i++) {
            clonedArray[i] = clonedArray[i] * 10;
        }
        // return a different new array
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
        int[] numbers = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum: " + sum);  // Output: Sum: 15

        double average = Arrays.stream(numbers).average().orElse(0.0);
        System.out.println("Average: " + average);  // Output: Average: 3.0

        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println("Max: " + max);  // Output: Max: 5

        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Min: " + min);  // Output: Min: 1

        int[] evenNumbers = Arrays.stream(numbers).filter(n -> n % 2 == 0).toArray();
        System.out.println("Even numbers: " + Arrays.toString(evenNumbers));  // Output: Even numbers: [2, 4]

        int[] squaredNumbers = Arrays.stream(numbers).map(n -> n * n).toArray();
        System.out.println("Squared numbers: " + Arrays.toString(squaredNumbers));  // Output: Squared numbers: [1, 4, 9, 16, 25]

        // 1 * 1 * 2 * 3 * 4 * 5 = 120
        int product = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);  // Output: Product: 120

        long count = Arrays.stream(numbers).count();
        System.out.println("Count: " + count);  // Output: Count: 5

        boolean anyMatch = Arrays.stream(numbers).anyMatch(n -> n > 4);
        System.out.println("Any match: " + anyMatch);  // Output: Any match: true

        boolean allMatch = Arrays.stream(numbers).allMatch(n -> n > 0);
        System.out.println("All match: " + allMatch);  // Output: All match: true

        boolean noneMatch = Arrays.stream(numbers).noneMatch(n -> n < 0);
        System.out.println("None match: " + noneMatch);  // Output: None match: true

        int first = Arrays.stream(numbers).findFirst().getAsInt();
        System.out.println("First: " + first);  // Output: First: 1

        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();
        System.out.println("Sorted numbers: " + Arrays.toString(sortedNumbers));  // Output: Sorted numbers: [1, 2, 3, 4, 5]

        int[] numbers2 = {6, 7, 8, 9, 10};
        int[] concatenated = IntStream.concat(Arrays.stream(numbers), Arrays.stream(numbers2)).toArray();
        System.out.println("Concatenated: " + Arrays.toString(concatenated));  // Output: Concatenated: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        int[] part = Arrays.stream(numbers, 1, 4).toArray();
        System.out.println("Part: " + Arrays.toString(part));  // Output: Part: [2, 3, 4]

    }
}