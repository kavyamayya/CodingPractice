package com.scaler.backtracking;

/**
 * @author kavya k on 13-Aug-2020
 * <p>
 * Unique Paths III
 * Problem Description
 * Given a matrix of integers A of size N x M . There are 4 types of squares in it:
 * 1. 1 represents the starting square.  There is exactly one starting square.
 * 2. 2 represents the ending square.  There is exactly one ending square.
 * 3. 0 represents empty squares we can walk over.
 * 4. -1 represents obstacles that we cannot walk over.
 * Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Problem Constraints
 * 2 <= N * M <= 20
 * -1 <= A[i] <= 2
 * Input Format
 * The first argument given is the integer matrix A.
 * Output Format
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * Example Input
 * Input 1:
 * A = [   [1, 0, 0, 0]
 * [0, 0, 0, 0]
 * [0, 0, 2, -1]   ]
 * Input 2:
 * A = [   [0, 1]
 * [2, 0]    ]
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 0
 * Example Explanation
 * Explanation 1:
 * We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Explanation 1:
 * Answer is evident here.
 */
public class UniquePathsIII {
    public static int resultCount = 0;

    public static void main(String[] args) {
        UniquePathsIII uniquePaths = new UniquePathsIII();
        int[] one = new int[]{1, 0, 0};
        int[] two = new int[]{-1, 0, 0};
        int[] three = new int[]{-1, 0, 2};
        int[][] A = new int[3][3];
        A[0] = one;
        A[1] = two;
        A[2] = three;
        uniquePaths.solve(A);
    }

    public int solve(int[][] A) {
        int zeroCounts = 0;
        int M = A.length;
        int N = A[0].length;
        int SR = 0;
        int SC = 0;
        int ER = 0;
        int EC = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0) {
                    zeroCounts++;
                } else if (A[i][j] == 1) {
                    SR = i;
                    SC = j;
                } else if (A[i][j] == 2) {
                    ER = i;
                    EC = j;
                }
            }
        }
        recursion(SR, SC, ER, EC, zeroCounts, -1, A);
        return resultCount;
    }

    public void recursion(int row, int column, int ER, int EC, int zeroCounts, int count, int[][] A) {
        if ((row == ER) && (column == EC)) {
            if (zeroCounts == count) {
                resultCount++;
            }
            return;
        }
        A[row][column] = -1;
        if ((row + 1) < A.length) {
            if (A[row + 1][column] != -1) {
                recursion(row + 1, column, ER, EC, zeroCounts, count + 1, A);
            }
        }
        if ((column + 1) < A[0].length) {
            if (A[row][column + 1] != -1) {
                recursion(row, column + 1, ER, EC, zeroCounts, count + 1, A);
            }
        }
        if ((column - 1) > -1) {
            if (A[row][column - 1] != -1) {
                recursion(row, column - 1, ER, EC, zeroCounts, count + 1, A);
            }
        }
        if ((row - 1) > -1) {
            if (A[row - 1][column] != -1) {
                recursion(row - 1, column, ER, EC, zeroCounts, count + 1, A);
            }
        }
        A[row][column] = 0;

    }
}
