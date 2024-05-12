package com.jasonz.codility;

import com.jasonz.utilities.GenerateExampleData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.03.22 11:01
 * @project JasonJavaLibrary
 * @description: The problem is equivalent to decreasing the most significant digit by 1, then changing the remaining digits to 9.
 * TIPS:
 * For given digits, for example, 200, you have to come up with a different number as answer.
 * We can just change to 1xx. Then to make the sum biggest, just replace 'x' with '9'.
 */
public class SumMaxDecreaseSignificant {

    private static final int count = 10000 * 10000;

    public static void main(String[] args) {
        SumMaxDecreaseSignificant ins = new SumMaxDecreaseSignificant();
        String aNumber = GenerateExampleData.generateRandomDigitalString(count);
        ins.solutionWithStreamMax(aNumber);
        ins.solutionWithDealingArray(aNumber);
        // ins.solutionWithDealingObject(v);
    }

    // === ******************************************************************** === //
    private void solutionWithStreamMax(String arg) {
        long startTime = System.currentTimeMillis();

        int[] digitalArray = convertStringToDigitalArray(arg);
        int maxDigital = Arrays.stream(digitalArray).max().orElse(Integer.MIN_VALUE);
        int sum = (maxDigital - 1) + (digitalArray.length - 1) * 9;

        long endTime = System.currentTimeMillis();
        System.out.printf("Get result [%d] within [%d] ms. \n",sum, (endTime-startTime));
        System.out.println("==========================================");
    }

    // === ******************************************************************** === //
    private void solutionWithDealingArray(String arg) {
        long startTime = System.currentTimeMillis();
        //1. convert the given string to an array
        int[] digital = convertStringToDigitalArray(arg);
        //printIntegerArray(digital);
        //2. sort the array
        Arrays.sort(digital);
        //printIntegerArray(digital);
        //3. sum them
        int sum = 0;
        for (int i = (digital.length - 1); i >= 0; i--) {
            if (i == (digital.length - 1)) {
                sum = sum + (digital[i] - 1);
            } else {
                sum = sum + 9;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Get result [%d] within [%d] ms. \n",sum, (endTime-startTime));
        System.out.println("==========================================");

    }
    private int[] convertStringToDigitalArray(String argString) {
       int[] retValue = new int[argString.length()];
       for(int i=0;i<argString.length();i++){
           retValue[i] =(int) argString.charAt(i);
       }
       return retValue;
    }

    private int[] convertIntegerToDigitalArray(int num) {
        // Count the number of digits
        int counts = (int) Math.log10(num) + 1;
        int[] digital = new int[counts];
        for (int i = counts - 1; i >= 0; i--) {
            digital[i] = num % 10;
            num = num / 10;
        }
        return digital;
    }

    // === ******************************************************************** === //
    private void solutionWithDealingObject(int v) {
        //1. convert
        List<DigitalObject> originalList = convertIntegerToDigitalObjectList(v);
        printObjectsList(originalList);
        // 2. sort it
        List<DigitalObject> newObjList = sortListByValueDesc(originalList);
        printObjectsList(newObjList);
        // 3. sum them
        int result = calculateByDesc(newObjList);
        System.out.println(result);
        System.out.println("==========================================");
    }

    private List<DigitalObject> convertIntegerToDigitalObjectList(int num) {
        // Count the number of digits
        int counts = (int) Math.log10(num) + 1;
        List<DigitalObject> retValue = new ArrayList<>();
        for (int i = counts - 1; i >= 0; i--) {
            DigitalObject obj = new DigitalObject(num % 10, i);
            retValue.add(obj);
            num = num / 10;
        }
        return retValue;
    }

    private static void printIntegerArray(int[] values) {
        for (int o : values) {
            System.out.print(o + "\t");
        }
        System.out.println("\n==========================================");
    }

    private static List<DigitalObject> sortListByValueDesc(List<DigitalObject> objs) {
        return objs.stream().sorted(new Comparator<DigitalObject>() {
            @Override
            public int compare(DigitalObject o1, DigitalObject o2) {
                return o2.getV() - o1.getV();
            }
        }).toList();
    }

    private static List<DigitalObject> sortListByValueAsc(List<DigitalObject> objs) {
        return objs.stream().sorted(new Comparator<DigitalObject>() {
            @Override
            public int compare(DigitalObject o1, DigitalObject o2) {
                return o1.getV() - o2.getV();
            }
        }).toList();
    }

    private static int calculateByDesc(List<DigitalObject> objs) {
        int sum = 0;
        int max = objs.get(0).getV();
        if (max == 0) {
            return 0;
        }
        for (int i = 0; i < objs.size(); i++) {
            int tempV = objs.get(i).getV();
            if (i == 0) {
                sum = sum + (tempV - 1);
                continue;
            }
            sum = sum + 9;
        }
        return sum;
    }

    private static void printObjectsList(List<DigitalObject> objs) {
        for (DigitalObject o : objs) {
            System.out.print(o.getV() + ":" + o.getP() + "\t");
        }
        System.out.println("\n==========================================");
    }


    @Getter
    static class DigitalObject {
        private final int v;
        private final int p;

        public DigitalObject(int v, int p) {
            this.v = v;
            this.p = p;
        }

    }
}
