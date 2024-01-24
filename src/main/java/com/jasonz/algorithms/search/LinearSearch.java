package com.jasonz.algorithms.search;

/**
 * @author Jason Zhuang
 * @created 2024.01.24 16:14
 * @project JasonJavaLibrary
 * @description:
 * Best Case:
 *  In the best case, the key might be present at the first index. So the best case complexity is O(1)
 * Worst Case:
 *  In the worst case, the key might be present at the last index,
 *  So the worst-case complexity is O(N) where N is the size of the list.
 * Average Case:
 *  O(N)
 */
public class LinearSearch {

    public static int search(int[] argArray, int target){
        for (int i = 0; i < argArray.length; i++) {
            if (argArray[i] == target)
                return i;
        }
        return -1;
    }
}
