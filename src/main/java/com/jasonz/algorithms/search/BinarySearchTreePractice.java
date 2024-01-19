package com.jasonz.algorithms.search;

/**
 * @author Jason Zhuang
 * @created 2024.01.18 14:01
 * @project JasonJavaLibrary
 * @description:
 */
public class BinarySearchTreePractice {


    public static void main(String[] args) {
        int l = 1, r = 6;
        int m = l + (r - l) / 2;
        System.out.println(m);
    }

    /**
     * @param argArray  this array must be sorted already
     * @param argTarget
     * @return
     */
    //    0,1,2,3,4
    public static int search(int[] argArray, int argTarget) {

        int idxLeft = 0;
        int idxRight = argArray.length - 1;

        while (idxLeft <= idxRight) {
            int idxMid = (idxLeft + idxRight) / 2;
            int valMid = argArray[idxMid];
            if (argTarget < valMid){
                idxRight = idxMid - 1;
            } else if (argTarget > valMid) {
                idxLeft = idxMid + 1;
            }else {
                return idxMid;
            }
        }
        return -1;
    }
}
