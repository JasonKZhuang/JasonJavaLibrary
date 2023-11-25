package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.list.Student;

import java.util.ArrayList;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class BinarySearchIterative implements IBinarySearch {

    /**
     * @param argList
     * @param argValue
     * @return index of Student Object with age=argValue if it is present in arr[], else return -1
     */
    @Override
    public int binarySearch(ArrayList<Student> argList, int argValue) {

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
            // If x is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // if we reach here, then element was not present
        return -1;
    }
}
