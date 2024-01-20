package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.list.Student;

import java.util.ArrayList;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class BinarySearchRecursive implements IBinarySearch {

    @Override
    public int binarySearch(ArrayList<Student> argList, int argValue) {
        int l = 0;
        int r = argList.size();
        return recursiveSearch(argList, l, r, argValue);
    }

    private int recursiveSearch(ArrayList<Student> arr, int l, int r, int x) {
        // Returns index of x if it is present in arr[l..r], else return -1
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (x == arr.get(mid).getAge())
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (x < arr.get(mid).getAge()) {
                return recursiveSearch(arr, l, mid - 1, x);
            }else {
                // Else the element can only be present in right subarray
                return recursiveSearch(arr, mid + 1, r, x);
            }
        }
        // We reach here when element is not present in array
        return -1;
    }
}
