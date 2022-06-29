package com.jasonz.leetcode.arrayAndString;

public class NumberGoodPairs {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        NumberGoodPairs ins = new NumberGoodPairs();
        System.out.println(ins.numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        int goodPairs= 0;
        for (int i=0; i<(nums.length-1);i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]) goodPairs++;
            }
        }
        return goodPairs;
    }
}
