package com.jasonz.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.02.08 13:32
 * @project JasonJavaLibrary
 * @description: 73. Set Matrix Zeroes
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class LC73_SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solutionNaive(array);
        System.out.println(Arrays.deepToString(array));
    }

    private static void solutionNaive(int[][] matrix) {

        Set<Integer> existingRow = new HashSet<>();
        Set<Integer> existingCol = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    existingRow.add(row);
                    existingCol.add(col);
                }
            }
        }
        for (Integer r : existingRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }

        for (Integer c : existingCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }

    }
}
