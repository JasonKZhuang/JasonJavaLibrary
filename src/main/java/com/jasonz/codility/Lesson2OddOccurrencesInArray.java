package com.jasonz.codility;

import com.jasonz.utilities.GenerateExampleData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason Zhuang
 * @created 2024.03.22 12:46
 * @project JasonJavaLibrary
 * @description: A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */
public class Lesson2OddOccurrencesInArray {
    private static final int num = 100 * 10000;

    public static void main(String[] args) {
        int[] evenArray = GenerateExampleData.generateRandomIntArrayEvenPaired(num);
        int[] oddArray = new int[num + 1];
        System.arraycopy(evenArray, 0, oddArray, 0, evenArray.length);
        oddArray[num] = 9;
        System.out.println(solutionBySorting(oddArray));
        System.out.println(solutionByHashMap(oddArray));
    }

    /**
     * less efficient
     * Spend time: 301 for 1000 * 10000
     *
     * @param arr
     * @return
     */
    private static int solutionBySorting(int[] arr) {
        long startTime = System.currentTimeMillis();
        int retValue = 0;
        if (arr.length == 1) {
            return arr[0];
        }

        // sort first
        Arrays.sort(arr);
        // current element is not equal to the after-next element, then it is the unpaired element
        for (int i = 0; i < arr.length - 1; ) {
            if (arr[i] == arr[i + 1]) {
                i = i + 2;
            } else {
                retValue = arr[i];
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("solutionBySorting Spend time: %d \n", (endTime - startTime));
        return retValue;
    }

    /**
     * efficient
     *
     * @param arr
     * @return Spend time: 222 for 1000 * 10000
     */
    private static int solutionByHashMap(int[] arr) {
        long startTime = System.currentTimeMillis();
        int retValue = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            if (map.get(e) == null) {
                map.put(e, 1);
            } else {
                int tempCount = map.get(e);
                map.put(e, tempCount + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 != 0) {
                retValue = e.getKey();
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("solutionByHashMap Spend time: %d \n", (endTime - startTime));
        return retValue;
    }


    private static int[] convertIntegerToDigitalArray(long num) {
        // Count the number of digits
        int counts = (int) Math.log10(num) + 1;
        int[] digital = new int[counts];
        for (int i = counts - 1; i >= 0; i--) {
            digital[i] = (int) (num % 10);
            num = num / 10;
        }
        return digital;
    }
}
