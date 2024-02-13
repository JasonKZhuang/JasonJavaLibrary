package com.jasonz.leetcode;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2024.02.08 14:40
 * @project JasonJavaLibrary
 * @description: 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class LC54_SpiralMatrix {

    private static final Map<String, String> mapDirection = new HashMap<>();

    private static final Set<Integer> accessedSet = new HashSet<>();

    public static void main(String[] args) {
        mapDirection.put("r", "d");
        mapDirection.put("d", "l");
        mapDirection.put("l", "u");
        mapDirection.put("u", "r");

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution(matrix));
    }

    /**
     * didn't successful
     *
     * @param array
     * @return
     */

    public static ArrayList<Integer> solution(int[][] array) {

        int rows = array.length;
        int cols = array[0].length;
        int loops = rows * cols;

        Set<Integer> accessed = new HashSet<>();
        ArrayList<Integer> ret = new ArrayList<>();
        int l = 0;
        int row = 0;
        int col = 0;

        String currentDirection = "r";

        while (l <= loops) {
            ret.add(array[row][col]);
            switch (currentDirection) {
                case "r":
                    if ((col == cols - 1) || accessed.contains(array[row][col])) {
                        currentDirection = mapDirection.get(currentDirection);
                        row = row + 1;
                    }
                    accessed.add(array[row][col]);
                    if (col < cols - 1) {
                        col = col + 1;
                    }
                    break;
                case "d":
                    if ((row == rows - 1) || accessed.contains(array[row][col])) {
                        currentDirection = mapDirection.get(currentDirection);
                    }
                    accessed.add(array[row][col]);
                    if (row < rows - 1) {
                        row = row + 1;
                    }
                    break;
                case "l":
                    if ((col == 0) || accessed.contains(array[row][col])) {
                        currentDirection = mapDirection.get(currentDirection);
                    }
                    accessed.add(array[row][col]);
                    if (col > 0) {
                        col = col - 1;
                    }
                    break;
                case "u":
                    if ((row == 0) || accessed.contains(array[row][col])) {
                        currentDirection = mapDirection.get(currentDirection);
                    }
                    accessed.add(array[row][col]);
                    if (row > 0) {
                        row = row - 1;
                    }
                    break;
            }

            l = l + 1;
        }
        return ret;

    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Four directions that we will move: right, down, left, up.
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Initial direction: moving right.
        int currentDirection = 0;

        // The number of times we change the direction.
        int changeDirection = 0;

        // Current place that we are at is (row, col).
        // row is the row index; col is the column index.
        int row = 0;
        int col = 0;

        // Store the first element and mark it as visited.
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;
        while (changeDirection < 2) {
            while (row + directions[currentDirection][0] >= 0 &&
                    row + directions[currentDirection][0] < rows &&
                    col + directions[currentDirection][1] >= 0 &&
                    col + directions[currentDirection][1] < columns &&
                    matrix[row + directions[currentDirection][0]]
                            [col + directions[currentDirection][1]] != VISITED) {
                // Reset this to 0 since we did not break and change the direction.
                changeDirection = 0;
                // Calculate the next place that we will move to.
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                result.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }
            // Change our direction.
            currentDirection = (currentDirection + 1) % 4;
            // Increment change_direction because we changed our direction.
            changeDirection++;
        }
        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int row = matrix.length;
        List<Integer> ans = new ArrayList<>();
        if (row < 1) {
            return ans;
        }
        int col = matrix[0].length;
        int startR = 0;
        int startCol = 0;
        int i = 0;

        while (startR < row && startCol < col) {
            for (i = startCol; i < col; ++i) {
                ans.add(matrix[startR][i]);
            }
            startR++;
            for (i = startR; i < row; ++i) {
                ans.add(matrix[i][col - 1]);
            }
            col--;
            if (startR < row) {
                for (i = col - 1; i >= startCol; --i) {
                    ans.add(matrix[row - 1][i]);
                }
                row--;
            }
            if (startCol < col) {
                for (i = row - 1; i >= startR; --i) {
                    ans.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return ans;
    }

}
