package com.jasonz.leetcode.arrayAndString;

public class RichestCustomerWealth {
    public static void main(String[] args) {

    }
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i=0;i<accounts.length;i++){
            int[] row = accounts[i];
            int sum = 0;

            for(int j=0;j<row.length;j++){
                sum = sum + row[j];
            }

            if (sum>max){
                max = sum;
            }
        }
        return max;
    }
}
