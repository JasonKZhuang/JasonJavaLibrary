package com.jasonz.leetcode;

/**
 * @author Jason Zhuang
 * @created 2024.01.19 08:59
 * @project JasonJavaLibrary
 * @description: Given an m x n grid of characters board and a string word,
 * return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * References:
 * https://www.youtube.com/watch?v=m9TrOL1ETxI
 */
public class LC79_WordSearchFromMatrix {

    // check vertically and horizontally for next char
    // if found it, and not in the temp map, put the char into a map, and keep going
    // if any char cannot be found neighbour, then return false, keep loop until the before last char

    private char[][] board;
    private int ROWS;
    private int COLS;

    private boolean[][] visited;

    public static void main(String[] args) {
        LC79_WordSearchFromMatrix ins = new LC79_WordSearchFromMatrix();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        // System.out.println(ins.exist(board, word));
        // System.out.println(ins.dfsSolution(board, word));
        System.out.println(ins.clearSolution(board, word));
    }

    public boolean clearSolution(char[][] board, String word) {
        // length of rows & columns
        int rows = board.length, cols = board[0].length;

        // if "word" is empty, we will just return true.
        if (word.isEmpty()) {
            return true;
        }

        // if board size (rows*cols) < word length, => word has some character(s) not present in board.
        // So, just return False.
        if (rows * cols < word.length()) {
            return false;
        }

        visited = new boolean[rows][cols];

        // Traverse all chars of board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) &&
                        checkCharacter(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCharacter(char[][] board, int r, int c, String word, int charIdx) {
        // check the length
        if (charIdx == word.length()) {
            return true;
        }

        // check the boundaries
        if (
                (r < 0 || r >= board.length) ||
                        (c < 0 || c >= board[0].length) ||
                        (board[r][c] != word.charAt(charIdx)) ||
                        visited[r][c]
        ) {
            return false;
        }

        // found the character, marking it as visited
        visited[r][c] = true;
        // keep traverse 4 directions, if any direction true, then return true
        if (
                checkCharacter(board, r - 1, c, word, charIdx + 1) ||
                        checkCharacter(board, r + 1, c, word, charIdx + 1) ||
                        checkCharacter(board, r, c - 1, word, charIdx + 1) ||
                        checkCharacter(board, r, c + 1, word, charIdx + 1)
        ) {
            return true;
        }
        // if all above 4 direction not matched, recover the visited to false
        visited[r][c] = false;
        return false;
    }


    public boolean dfsSolution(char[][] board, String word) {
        // length of rows & columns
        int rows = board.length, cols = board[0].length;
        // if "word" is empty, we will just return true.
        if (word.isEmpty()) {
            return true;
        }
        // if board size (rows*cols) < word length, => word has some character(s) not present in board.
        // So, just return False.
        // This is optimized way as we are avoiding doing DFS search in such test cases.
        if (rows * cols < word.length()) {
            return false;
        }

        // Traverse all chars of board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {                                                // keep iterating until we don't find first character of "word"
                    boolean isFound = dfsBoard(board, new boolean[rows][cols], r, c, word, 0);    // call DFS or recursion
                    if (isFound) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected boolean dfsBoard(char[][] board, boolean[][] visitedBoard, int row, int col, String word, int wordInd) {
        // return false, if:  a)  row or col goes out of bound.  b) char in board != char in word
        if ((row < 0 || row >= board.length) ||
                (col < 0 || col >= board[0].length) ||
                board[row][col] != word.charAt(wordInd)) {
            return false;
        }
        // this element already visited, so don't do DFS on this
        if (visitedBoard[row][col]) {
            return false;
        }
        if (wordInd == word.length() - 1) {
            return true;
        }
        // mark it as visited now
        visitedBoard[row][col] = true;

        // DFS on Left
        if (dfsBoard(board, visitedBoard, row, col - 1, word, wordInd + 1)) {
            return true;
        }
        // DFS on Right
        if (dfsBoard(board, visitedBoard, row, col + 1, word, wordInd + 1)) {
            return true;
        }
        // DFS on Above
        if (dfsBoard(board, visitedBoard, row - 1, col, word, wordInd + 1)) {
            return true;
        }
        // DFS on Below
        if (dfsBoard(board, visitedBoard, row + 1, col, word, wordInd + 1)) {
            return true;
        }
        visitedBoard[row][col] = false;
        return false;
    }

    public boolean mySolution(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (this.backChecking(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backChecking(int row, int col, String word, int charIdx) {
        // check the length charIdx which has match the whole word
        if (charIdx >= word.length()) {
            return true;
        }

        // check boundaries
        if (row < 0 || row == board.length || col < 0 || col == board[0].length) {
            return false;
        }

        // check matching the character
        if (board[row][col] != word.charAt(charIdx)) {
            return false;
        } else {
            // marking visited, assign a value out alphabet
            board[row][col] = '#';
        }

        // consider word side, if matched, move to check next character
        boolean ret = false;
        // check 4 directions
        int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        if (row == 1 && col == 3) {
            System.out.println("=====");
        }

        for (int[] dr : direction) {
            int nr = row + dr[0];
            int nc = col + dr[1];
            ret = backChecking(nr, nc, word, charIdx + 1);
            if (ret) {
                break;
            }
        }
        // clean up
        this.board[row][col] = word.charAt(charIdx);
        return ret;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (this.backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS ||
                col < 0 || col == this.COLS ||
                this.board[row][col] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret)
                break;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index);
        return ret;
    }

}
