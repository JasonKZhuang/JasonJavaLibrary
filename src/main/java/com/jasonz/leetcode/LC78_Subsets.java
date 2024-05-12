package com.jasonz.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.02.20 08:52
 * @project JasonJavaLibrary
 * @description: 78. Subsets
 *
 * Description is not clear
 */
public class LC78_Subsets {

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4, 1};
        System.out.println(subsets(array));
        System.out.println(subsets2(array));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retValue = new ArrayList<>();
        retValue.add(new ArrayList<>());
        retValue.add(List.of(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            int tmpSize = retValue.size();
            retValue.add(List.of(nums[i]));
            for (int j = 0; j < tmpSize; j++) {
                List<Integer> lstV = retValue.get(j);
                if (lstV.isEmpty()) {
                    continue;
                }
                List<Integer> newTemp = new ArrayList<>(lstV);
                newTemp.add(nums[i]);
                retValue.add(newTemp);
            }
        }
        return retValue;
    }

    private static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        LinkedList<Integer> linked = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            linked.add(i);
        }
        while (!linked.isEmpty()){
            int idx = linked.removeFirst();
            if (idx == 2){
                System.out.println("444");
            }
            // add itself
            ret.add(List.of(nums[idx]));
            // prepare a max list
            ArrayList<Integer> maxList = new ArrayList<>();
            maxList.add(nums[idx]);
            for(int j = idx + 1; j<nums.length;j++){
                // add to max list
                maxList.add(nums[j]);
                // a pair list
                ret.add(List.of(nums[idx],nums[j]));
            }
            if(maxList.size()>2) {
                ret.add(maxList);
            }
        }
        return ret;
    }
}
