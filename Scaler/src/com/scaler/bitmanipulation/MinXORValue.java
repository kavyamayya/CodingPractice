package com.scaler.bitmanipulation;

import java.util.Arrays;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
 * Report the minimum XOR value.
 * <p>
 * Problem Constraints
 * 2 <= length of the array <= 100000
 * 0 <= A[i] <= 10^9
 * <p>
 * Input Format
 * First and only argument of input contains an integer array A.
 * <p>
 * Output Format
 * Return a single integer denoting minimum xor value.
 * <p>
 * Example Input
 * Input 1:
 * A = [0, 2, 5, 7]
 * Input 2:
 * A = [0, 4, 7, 9]
 * <p>
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 3
 * <p>
 * Example Explanation
 * Explanation 1:
 * 0 xor 2 = 2
 */
public class MinXORValue {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            minXor = Math.min(minXor, A[i] ^ A[i + 1]);
        }
        return minXor;
    }
}
