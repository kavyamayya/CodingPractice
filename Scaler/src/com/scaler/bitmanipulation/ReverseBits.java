package com.scaler.bitmanipulation;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Reverse the bits of an 32 bit unsigned integer A.
 * <p>
 * Problem Constraints
 * 0 <= A <= 232
 * <p>
 * Input Format
 * First and only argument of input contains an integer A.
 * <p>
 * Output Format
 * Return a single unsigned integer denoting minimum xor value.
 * <p>
 * Example Input
 * Input 1:
 * 0
 * Input 2:
 * 3
 * <p>
 * Example Output
 * Output 1:
 * 0
 * Output 2:
 * 3221225472
 * <p>
 * Example Explanation
 * Explanation 1:
 * 00000000000000000000000000000000    =>      00000000000000000000000000000000
 * Explanation 2:
 * 00000000000000000000000000000011    =>      11000000000000000000000000000000
 */
public class ReverseBits {
    public long reverse(long a) {
        long reverse = 0;
        int count = 31;
        while (count >= 0) {
            reverse <<= 1;
            if ((int) (a & 1) == 1) {
                reverse ^= 1;
            }
            a >>= 1;
            count--;
        }
        return reverse;
    }
}
