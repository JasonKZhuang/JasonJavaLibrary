package com.jasonz.algorithms.depthFirstSearch;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 10:36
 * @project JasonJavaLibrary
 * @description: 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
    static int count=0;
    public static void main(String[] args) {

    }
    private static void dfs(int[] array, int i, int sum, int target){
        if (i == array.length){
            if (sum == target){
                count++;
            }
        }else {
            int p = array[i];
            int n = -1 * array[i];
            dfs(array,i+1,sum + p, target);
            dfs(array,i+1,sum + n, target);
        }
    }
}
