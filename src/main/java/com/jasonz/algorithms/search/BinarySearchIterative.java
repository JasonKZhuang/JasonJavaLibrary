package com.jasonz.algorithms.search;

import com.jasonz.dto.Student;

import java.util.ArrayList;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class BinarySearchIterative implements IBinarySearch {

    @Override
    public int search(int[] argArray, int targetValue) {

        // define left and right boundary index
        int l = 0, r = argArray.length - 1;

        while (l <= r) {
            // get the middle index
            int m = l + (r - l) / 2;
            // compare the target value to middle value
            int res = Integer.compare(targetValue, argArray[m]);
            // if target value is smaller, head to left
            if (res < 0) {
                r = m - 1;
            } else if (res == 0) { // if equal, then found it return m
                return m;
            } else { // if target value is greater, head to right
                l = m + 1;
            }
        }
        return -1;
    }

    /**
     * @param argList
     * @param argValue
     * @return index of Student Object with age=argValue if it is present in arr[], else return -1
     */
    @Override
    public int search(ArrayList<Student> argList, int argValue) {

        int left = 0;
        int right = argList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if argValue is present at mid
            if (argValue == argList.get(mid).getAge()) {
                return mid;
            }

            // If argValue greater, ignore left half, move to right half
            if (argValue > argList.get(mid).getAge()) {
                left = mid + 1;
            }
            // If x is smaller, ignore right half, move to left half
            else {
                right = mid - 1;
            }
        }

        // if we reach here, then element was not present
        return -1;
    }
}
