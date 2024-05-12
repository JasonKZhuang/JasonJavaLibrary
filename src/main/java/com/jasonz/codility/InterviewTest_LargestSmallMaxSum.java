package com.jasonz.codility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jason Zhuang
 * @created 2024.03.23 20:56
 * @project JasonJavaLibrary
 * @description: find the largest number smaller than S that has the maximum possible sum of digits.
 * For S = "899", the result will be "898", since we can just reduce the last digit by 1.
 * For S = "10", the first digit is 1, so we remove it and make the remaining digit 9, resulting in "9".
 * For S = "98", we can reduce the first digit to 8 and change the second digit to 9, resulting in "89".
 * <p>
 * if it is last, then reduce 1
 * if it is before last, reduce 1 and change right remaining to 9
 */
public class InterviewTest_LargestSmallMaxSum {
    public static void main(String[] args) {
        String maxNum = String.valueOf(Integer.MAX_VALUE);
        //==================================================================================================
        System.out.println("expect 0 : actual : " + solution1(null));//0
        System.out.println("expect 0 : actual : " + solution1("")); //0
        System.out.println("expect 0 : actual : " + solution1("0")); //0
        System.out.println("expect 0 : actual : " + solution1("1")); //0
        System.out.println("expect 1 : actual : " + solution1("2")); //1
        System.out.println("expect 8 : actual : " + solution1("9")); //8
        System.out.println("expect 9 : actual : " + solution1("10")); //9
        System.out.println("expect 9 : actual : " + solution1("11")); //9
        System.out.println("expect 9 : actual : " + solution1("12")); //9
        System.out.println("expect 18 : actual : " + solution1("19"));
        System.out.println("expect 19 : actual : " + solution1("20"));
        System.out.println("expect 19 : actual : " + solution1("21"));
        System.out.println("expect 28 : actual : " + solution1("29"));
        System.out.println("expect 89 : actual : " + solution1("90"));
        System.out.println("expect 89 : actual : " + solution1("91"));
        System.out.println("expect 89 : actual : " + solution1("98"));
        System.out.println("expect 98 : actual : " + solution1("99"));
        System.out.println("expect 99 : actual : " + solution1("100"));
        System.out.println("expect 99 : actual : " + solution1("108"));
        System.out.println("expect 99 : actual : " + solution1("109"));
        System.out.println("expect 99 : actual : " + solution1("180"));
        System.out.println("expect 189 : actual : " + solution1("190"));
        System.out.println("expect 198 : actual : " + solution1("199"));
        System.out.println("expect 889 : actual : " + solution1("890"));
        System.out.println("expect 889 : actual : " + solution1("898"));
        System.out.println("expect 898 : actual : " + solution1("899"));
        System.out.println("expect 1999999999 : actual : " + solution1(maxNum));
        System.out.println("=====================================================");
        //==================================================================================================
        System.out.println("expect 0 : actual : " + solution2(null));//0
        System.out.println("expect 0 : actual : " + solution2("")); //0
        System.out.println("expect 0 : actual : " + solution2("0")); //0
        System.out.println("expect 0 : actual : " + solution2("1")); //0
        System.out.println("expect 1 : actual : " + solution2("2")); //1
        System.out.println("expect 8 : actual : " + solution2("9")); //8
        System.out.println("expect 9 : actual : " + solution2("10")); //9
        System.out.println("expect 9 : actual : " + solution2("11")); //9
        System.out.println("expect 9 : actual : " + solution2("12")); //9
        System.out.println("expect 18 : actual : " + solution2("19"));
        System.out.println("expect 19 : actual : " + solution2("20"));
        System.out.println("expect 19 : actual : " + solution2("21"));
        System.out.println("expect 28 : actual : " + solution2("29"));
        System.out.println("expect 89 : actual : " + solution2("90"));
        System.out.println("expect 89 : actual : " + solution2("91"));
        System.out.println("expect 89 : actual : " + solution2("98"));
        System.out.println("expect 98 : actual : " + solution2("99"));
        System.out.println("expect 99 : actual : " + solution2("100"));
        System.out.println("expect 99 : actual : " + solution2("108"));
        System.out.println("expect 99 : actual : " + solution2("109"));
        System.out.println("expect 99 : actual : " + solution2("180"));
        System.out.println("expect 189 : actual : " + solution2("190"));
        System.out.println("expect 198 : actual : " + solution2("199"));
        System.out.println("expect 889 : actual : " + solution2("890"));
        System.out.println("expect 889 : actual : " + solution2("898"));
        System.out.println("expect 898 : actual : " + solution2("899"));
        System.out.println("expect 1999999999 : actual : " + solution2(maxNum));


        int[] testArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                                    18, 19, 28, 29, 38, 39, 48, 49,
                                    58, 59, 68, 69, 78, 79, 88, 89, 98, 99, 189, 198,
                                    8899, 8989, 8998, 8999,
                                    9899, 9989, 9998, 9999,
                                    18999, 19899, 19989, 19998, 19999,
                                    98999, 99899, 99989, 99998, 99999,
                                    189999, 198999, 199899, 199989, 199998, 199999,
                                    7899999, 7989999, 7998999, 7999899, 7999989, 7999998, 7999999,
                                    8899999, 8989999, 8998999, 8999899, 8999989, 8999998, 8999999,
                                    9899999, 9989999, 9998999, 9999899, 9999989, 9999998, 9999999
        };
        for (int i = 0; i < testArray.length; i++) {
            System.out.println("actual : " + solution2(testArray[i] + ""));
        }
    }

    /**
     * final solution
     * from right to left reduce 1 and change right to 9
     *
     * @param argStringNumber
     * @return
     */
    private static String solution2(String argStringNumber) {
        // Record the start time
        long startTime = System.nanoTime();

        // consider the lowest edge case
        if (argStringNumber == null || argStringNumber.isEmpty()) {
            return "0";
        }

        // convert the given String to int
        int givenNumber = Integer.parseInt(argStringNumber);
        // if zero return 0
        if (givenNumber == 0) {
            return "0";
        }

        if (givenNumber < 10) {
            return String.valueOf(givenNumber - 1);
        }

        // dealing with length larger than 1
        int len = argStringNumber.length();

        // convert a string to a list of string
        List<String> oldList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            oldList.add(String.valueOf(argStringNumber.charAt(i)));
        }
        //        List<String> oldList = IntStream.range(0, len)
        //                .mapToObj(i -> String.valueOf(argStringNumber.charAt(i)))
        //                .collect(Collectors.toList());

        int listSize = oldList.size();
        int maxSum = 0;
        String retValue = "";

        // from last to first, reduce 1 and change right to 9
        for (int i = listSize - 1; i >= 0; i--) {
            // every iterate, got a temp array copy
            List<String> newList = oldList.stream().map(e -> e).collect(Collectors.toList());
            // get the String value of the current index
            String pStrValue = newList.get(i);
            // convert the String to int
            int pIntValue = Integer.parseInt(pStrValue);
            // if the value is 0, skip
            if (pIntValue == 0) {
                continue;
            } else
            // if the value is [1-9], change the value with reduce 1
            {
                newList.set(i, String.valueOf(pIntValue - 1));
                // all others digits from this index to right change to max 9
                for (int j = i + 1; j < listSize; j++) {
                    newList.set(j, "9");
                }
            }

            // sum together for all digits in the new list
            int newSum = newList.stream().mapToInt(Integer::parseInt).sum();
            // if new sum larger than max sum, then update the max sum and update the return value
            if (newSum > maxSum) {
                maxSum = newSum;
                retValue = newList.stream().map(e -> e).collect(Collectors.joining());
            }
        }
        retValue = String.valueOf(Integer.parseInt(retValue));

        // Record the end time
        long endTime = System.nanoTime();
        // Calculate the execution time in milliseconds
        long executionTime = (endTime - startTime) / 1000000;
        // Print the execution time
        System.out.println("Execution time: " + executionTime + " milliseconds");


        return retValue;
    }

    private static String solution1(String S) {
        // Record the start time
        long startTime = System.nanoTime();

        // consider the lowest edge case
        if (S == null || S.isEmpty()) {
            return "0";
        }

        int givenNumber = Integer.parseInt(S);

        int[] digits = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            digits[i] = Character.getNumericValue(S.charAt(i));
        }

        int n = digits.length;
        int maxSumValue = 0;
        int newValue = 0;

        // from right to left
        for (int i = n - 1; i >= 0; i--) {
            // every iterate, got a temp array copy
            int[] digitsTemp = new int[digits.length];
            System.arraycopy(digits, 0, digitsTemp, 0, n);

            // if last digit is zero, skip move to left once
            if (digits[i] == 0) {
                continue;
            }
            // if the digit is [1-9], change the value with reduce 1
            digitsTemp[i] = digitsTemp[i] - 1;
            // all others digits from this index to right change to max 9
            for (int j = i + 1; j < n; j++) {
                digitsTemp[j] = 9;
            }

            // sum together for all digits
            int tempSum = 0;
            StringBuilder sb = new StringBuilder();
            for (int value : digitsTemp) {
                sb.append(value);
                tempSum = tempSum + value;
            }

            // if the new String < given number String && new SUM > maxSum
            if (Integer.parseInt(sb.toString()) < givenNumber && tempSum > maxSumValue) {
                newValue = Integer.parseInt(sb.toString());
                maxSumValue = tempSum;
            }
        }

        // Record the end time
        long endTime = System.nanoTime();
        // Calculate the execution time in milliseconds
        long executionTime = (endTime - startTime) / 1000000;
        // Print the execution time
        System.out.println("Execution time: " + executionTime + " milliseconds");

        return String.valueOf(newValue);
    }
}
