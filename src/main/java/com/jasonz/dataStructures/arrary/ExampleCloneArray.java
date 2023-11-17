package com.jasonz.dataStructures.arrary;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class ExampleCloneArray {
    public static void main(String[] args) {
        ExampleCloneArray instance = new ExampleCloneArray();
        //
        int[] intArray = {50, 60, 70};
        int[] cloneArray = instance.testCloneOneDimensionArray(intArray);
        instance.printArrayOne("Printing cloned array: ",cloneArray);
        instance.printArrayOne("Printing initial array: ",intArray);
        // Conclusion for one dimension array:
        // clone one dimension an array is to copy the initial array and put the array into a new memory space
        // the new array is totally different from initial array
        // ==================================================================//
        int intArrayTwo[][] = {{1,2,3},{4,5,6}};
        int[][] cloneArrayTwo = instance.testCloneTwoDimensionArray(intArrayTwo);
        instance.printArrayTwo("Printing cloned array: ", cloneArrayTwo);
        instance.printArrayTwo("Printing initial array: ", intArrayTwo);
        // But Conclusion for two dimensions array:
        // Cloning a multi-dimensional array, such as Object[ ][ ], means performing a “shallow copy”.
        // It creates only a single new array with each element of the array as a reference to an element of the original array.
        // In the cloning of multi-dimensional arrays, subarrays are shared, that is, they are not cloned.
    }

    private int[] testCloneOneDimensionArray(int[] arg) {
        int clonedArray[] = arg.clone();
        for (int i = 0; i < clonedArray.length; i++) {
            clonedArray[i] = clonedArray[i] * 10;
        }
        return clonedArray;
    }

    private int[][] testCloneTwoDimensionArray(int[][] arg) {
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

}
