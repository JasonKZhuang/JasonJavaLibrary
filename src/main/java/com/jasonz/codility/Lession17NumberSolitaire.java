package com.jasonz.codility;

/**
 * @author Jason Zhuang
 * @created 2024.06.16 09:03
 * @project JasonJavaLibrary
 * @description: A game for one player is played on a board consisting of N consecutive squares, numbered from 0 to N − 1. There is a number written on each square. A non-empty array A of N integers contains the numbers written on the squares. Moreover, some squares can be marked during the game.
 * <p>
 * At the beginning of the game, there is a pebble on square number 0 and this is the only square on the board which is marked. The goal of the game is to move the pebble to square number N − 1.
 * <p>
 * During each turn we throw a six-sided die, with numbers from 1 to 6 on its faces, and consider the number K, which shows on the upper face after the die comes to rest. Then we move the pebble standing on square number I to square number I + K, providing that square number I + K exists. If square number I + K does not exist, we throw the die again until we obtain a valid move. Finally, we mark square number I + K.
 * <p>
 * After the game finishes (when the pebble is standing on square number N − 1), we calculate the result. The result of the game is the sum of the numbers written on all marked squares.
 * <p>
 * For example, given the following array:
 * <p>
 * A[0] = 1
 * A[1] = -2
 * A[2] = 0
 * A[3] = 9
 * A[4] = -1
 * A[5] = -2
 * one possible game could be as follows:
 * <p>
 * the pebble is on square number 0, which is marked;
 * we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
 * we throw 5; the pebble does not move, since there is no square number 8 on the board;
 * we throw 2; the pebble moves to square number 5; we mark this square and the game ends.
 * The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8. This is the maximal possible result that can be achieved on this board.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the maximal result that can be achieved on the board represented by array A.
 * <p>
 * For example, given the array
 * <p>
 * A[0] = 1
 * A[1] = -2
 * A[2] = 0
 * A[3] = 9
 * A[4] = -1
 * A[5] = -2
 * the function should return 8, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 *
 */
public class Lession17NumberSolitaire {
    public static void main(String[] args) {
        // Put your test code here
        int[] A = {1,  -2   , 0, 9, -1, -2};
        int[] B = {1,  0    , 0, 0, 0, 0, 0};
        int[] C = {1, (-2+1), 0, 0, 0, 0, 0};
        int[] D = {1, -1    , 0, 0, 0, 0, 0};
        System.out.println(solution(A));
    }

    /**
     * when i = 0, dp[i] = A[i]
     * wehn i = k
     *
     * @param A
     * @return
     */
    public static int solution(int[] A) {
        // Implement your solution here
        int[] dp = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                dp[i] = A[i];
            } else {
                int maxNum = Integer.MIN_VALUE;
                for (int j = 1; j <= 6; j++) {
                    if (i - j >= 0) {
                        maxNum = Math.max(maxNum, dp[i - j] + A[i]);
                    }
                }
                dp[i] = maxNum;
            }

        }
        return dp[A.length - 1];
    }
}
