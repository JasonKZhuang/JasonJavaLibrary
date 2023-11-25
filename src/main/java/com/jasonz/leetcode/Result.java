package com.jasonz.leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jason Zhuang
 * @date : 4/6/2022
 * @description :
 */
public class Result {

    public static void main(String[] args) throws IOException {

    }


    public static String findNumber(List<Integer> arr, int k) {
        int v = 0;
        for (int i = 0; i < arr.size(); i++) {
            v = arr.get(i);
            if (v == k) {
                return "YES";
            }
        }
        System.out.println(Integer.MAX_VALUE);
        return "NO";

    }

    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> retList = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 == 0) {
                ;
            } else {
                retList.add(i);
            }
        }
        return retList;


    }
}
