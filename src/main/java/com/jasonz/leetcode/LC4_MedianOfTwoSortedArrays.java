package com.jasonz.leetcode;

/**
 * @author Jason Zhuang
 * @created 2024.02.05 00:37
 * @project JasonJavaLibrary
 * @description: Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class LC4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] array1 = new int[]{0,0,0,0,0};
        int[] array2 = new int[]{-1,0,0,0,0,0,1};
        System.out.println(solution(array1,array2));
    }

    private static double solution(int[] nums1, int[] nums2) {
        int[] merged = mergeTwoSortedArrays(nums1,nums2);
        int n = merged.length;
        int mod = n % 2;
        if (mod==0){
            int l = merged[(n/2) - 1];
            int r = merged[(n/2)];
            return ((double) (l+r))/2;
        }else {
            return merged[n/2];
        }

    }

    /**
     * using two pointers algorithm
     * @param array1
     * @param array2
     * @return
     */
    private static int[] mergeTwoSortedArrays(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n1 = array1.length;
        int n2 = array2.length;
        int[] merged = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (array1[i] < array2[j]) {
                merged[k] = array1[i];
                i = i + 1;
            } else if (array1[i] == array2[j]) {
                merged[k] = array1[i];
                k = k+1;
                merged[k] = array2[j];
                i++;
                j++;
            } else {
                merged[k] = array2[j];
                j = j + 1;
            }
            k++;
        }

        while (i < n1) {
            merged[k] = array1[i];
            i++;
            k++;
        }

        while (j < n2) {
            merged[k] = array2[j];
            j++;
            k++;
        }

        return merged;
    }

}
