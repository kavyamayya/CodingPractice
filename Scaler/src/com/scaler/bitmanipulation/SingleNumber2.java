package com.scaler.bitmanipulation;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given an array of integers, every element appears thrice except for one which occurs once.
 * Find that element which does not appear thrice.
 * NOTE: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * <p>
 * Problem Constraints
 * 2 <= A <= 5*10^6
 * 0 <= A <= INTMAX
 * <p>
 * Input Format
 * First and only argument of input contains an integer array A.
 * <p>
 * Output Format
 * Return a single integer.
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 * Input 2:
 * A = [0, 0, 0, 1]
 * <p>
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 1
 * <p>
 * Example Explanation
 * Explanation 1:
 * 4 occurs exactly once in Input 1.
 * 1 occurs exactly once in Input 2.
 */
public class SingleNumber2 {
    public int singleNumber(final int[] A) {
        int answer = 0;
        for (int i = 0; i <= 31; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << i)) >= 1) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                answer = answer | (1 << i);
            }
        }
        return answer;
    }
}
