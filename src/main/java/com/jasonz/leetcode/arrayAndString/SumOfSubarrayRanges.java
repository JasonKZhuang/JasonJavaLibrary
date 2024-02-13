package com.jasonz.leetcode.arrayAndString;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Stack;
import java.util.stream.IntStream;

public class SumOfSubarrayRanges {

    public static void main(String[] args) {
        SumOfSubarrayRanges ins = new SumOfSubarrayRanges();

    }
    // [1,2,3]
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int s = 0; s < nums.length; s++) {
            for (int e = s; e < nums.length; e++) {
                Integer[] subarray = IntStream.range(s, e + 1).mapToObj(idx -> nums[idx]).toArray(Integer[]::new);
                // System.out.println(Arrays.toString(subarray));
                Arrays.sort(subarray);
                int min = subarray[0];
                int max = subarray[subarray.length -1];
                sum = sum + ( max - min);
            }
        }
        return sum;
    }

    public long subArrayRanges2(int[] nums) {
        long result = 0l;
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            while (!maxStack.isEmpty() && (i == n || nums[i] > nums[maxStack.peek()])) {
                int j = maxStack.pop();
                long count = (i - j) * (j - (maxStack.isEmpty() ? -1 : maxStack.peek()));
                result += count * nums[j];
            }
            maxStack.push(i);

            while (!minStack.isEmpty() && (i == n || nums[i] < nums[minStack.peek()])) {
                int j = minStack.pop();
                long count = (i - j) * (j - (minStack.isEmpty() ? -1 : minStack.peek()));
                result -= count * nums[j];
            }
            minStack.push(i);
        }

        return result;
    }

    public long subArrayRanges3(int[] nums) {
        int n = nums.length;
        long res = 0;
        for(int i = 0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i;j<n;j++){
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                res += (long)(max - min);
            }
        }

        return res;
    }

    public long subArrayRanges4(int[] nums) {
        long [] out = new long[1];
        for(int i=0;i<nums.length;i++) {
            dfs(out, nums, i, nums[i], nums[i], 1);
        }
        return out[0];
    }

    private void dfs(long [] out, int[] nums, int i, int min, int max, int len){
        if(len > 1){ //computing only when max we have more one value in the sub array
            out[0]  += max -min;
        }
        if(i > nums.length-2) // return if already in the last position
            return;

        dfs(out, nums,i+1, Math.min(nums[i+1], min), Math.max(nums[i+1], max), len+1); // We dont need a sub array. Just max and min element is enough
    }

    public long subArrayRanges5(int[] nums) {
        //corner cases: can nums be null or empty? No
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int smallest = nums[i];
            int largest = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                smallest = Math.min(smallest, nums[j]);
                largest = Math.max(largest, nums[j]);

                result += largest - smallest;
            }
        }
        return result;
    }
}
