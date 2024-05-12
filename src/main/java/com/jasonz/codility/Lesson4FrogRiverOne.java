package com.jasonz.codility;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2024.05.02 15:36
 * @project JasonJavaLibrary
 * @description:
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 *
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 *
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 *
 * For example, you are given integer X = 5 and array A such that:
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int[] A); }
 *
 * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
 *
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 *
 * For example, given X = 5 and array A such that:
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * the function should return 6, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 */
public class Lesson4FrogRiverOne {

    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 2};
        int X = 2;
        System.out.println(solution(X, A));

    }

    /**
     * https://www.youtube.com/watch?v=yn299EEBTVI
     * @param X
     * @param A
     * @return
     */
    public static int solution(int X, int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< A.length; i++){
            map.put(A[i], 1);
            if(map.size() == X){
                return i;
            }
        }
        return -1;
    }

    /**
     * funking wrong, because don't understand the English question
     * @param X
     * @param A
     * @return
     */
    public static int solution2(int X, int[] A) {
        if (X == 0 || A == null || A.length == 0) {
            return -1;
        }
        List<LeafNode> leafNodeList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            leafNodeList.add(new LeafNode(i, A[i]));
        }
        leafNodeList.sort((o1, o2) -> o1.getVal() - o2.getVal());
        int idx = Collections.binarySearch(leafNodeList,
                new LeafNode(0, X), new Comparator<LeafNode>() {
                    @Override
                    public int compare(LeafNode o1, LeafNode o2) {
                        return o1.getVal() - o2.getVal();
                    }
                }
        );
        LeafNode retObj = leafNodeList.get(idx);
        return retObj.getIdx();

    }

    private static class LeafNode {
        int idx;
        int val;

        LeafNode(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int getIdx() {
            return idx;
        }

        public int getVal() {
            return val;
        }
    }
}


