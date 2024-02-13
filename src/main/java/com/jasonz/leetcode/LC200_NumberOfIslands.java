package com.jasonz.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jason Zhuang
 * @created 2024.02.11 14:43
 * @project JasonJavaLibrary
 * @description: 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 * <p>
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * * Example 3:
 * {"1","1","1"},
 * {"0","1","0"},
 * {"1","1","1"}
 * Output: 1
 */
public class LC200_NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}

        };

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}

        };

        grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}

        };


        System.out.println(solutionBFS(grid));
        //        System.out.println(solutionDFS(grid));
    }

    public static int solutionBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    num_islands = num_islands + 1;
                    bfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    /**
     * BreadthFirstSearch algorithm
     * @param array
     * @param r
     * @param c
     */
    private static void bfs(char[][] array, int r, int c) {
        int rows = array.length;
        int cols = array[0].length;

        int[][] directions = new int[][]{
                // {0, 0}, // center
                {-1, 0}, // top
                {0, 1}, // right
                {1, 0}, // bottom
                {0, -1} // left
        };

        Queue<int[]> neighbors = new LinkedList<>();

        // When using a capacity-restricted queue, this method is generally preferable to add,
        // which can fail to insert an element only by throwing an exception.
        neighbors.offer(new int[]{r, c});

        while (!neighbors.isEmpty()) {

            // poll a element from first or header
            int[] point = neighbors.poll();

            // loop 4 directions
            for (int[] d : directions) {
                int newRow = point[0] + d[0];
                int newCol = point[1] + d[1];

                if ((newRow >= 0 && newRow < rows) &&
                        (newCol >= 0 && newCol < cols) &&
                        array[newRow][newCol] == '1') {
                    // mark its all neighbours value = 2
                    array[newRow][newCol] = '2';
                    // add its neighbours into queue
                    neighbors.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    /**
     * start: find one neighbour
     * -> find its neighbour
     * -> find its neighbout
     * -> ...
     * <- return
     * <- return
     * <- return if cannot find any more neighbours
     * done!
     *
     * @param grid
     * @return Reference:
     * <a href="https://leetcode.com/problems/number-of-islands/editorial/">Approach #1 DFS </a>
     */
    public static int solutionDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;
        // traverse each element
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // find a new island
                if (grid[r][c] == '1') {
                    islandCount = islandCount + 1;
                    // depth explore all connected islands
                    dfs(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    // Depth First Search Algorithm
    // recursive
    private static void dfs(char[][] array, int r, int c) {
        int rows = array.length;
        int cols = array[0].length;

        int[][] directions = new int[][]{
                {0, 0}, // center
                {-1, 0}, // top
                {0, 1}, // right
                {1, 0}, // bottom
                {0, -1} // left
        };

        for (int[] d : directions) {
            int newRow = r + d[0];
            int newCol = c + d[1];

            if ((newRow >= 0 && newRow < rows) &&
                    (newCol >= 0 && newCol < cols) &&
                    array[newRow][newCol] == '1') {
                array[r][c] = '0';

                if (newRow == r && newCol == c) {
                    continue;
                }

                dfs(array, newRow, newCol);
            }
        }
    }

}
