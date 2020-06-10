package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * A lucky number is a number which has exactly 2 distinct prime divisors.
 * You are given a number A and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
 * <p>
 * Problem Constraints
 * 1 <= A <= 5000
 * <p>
 * Input Format
 * The first and only argument is an integer A.
 * <p>
 * Output Format
 * Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
 * <p>
 * Example Input
 * Input 1:
 * A = 8
 * Input 2:
 * 12
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 3
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Between [1, 8] there is only 1 lucky number i.e 6.
 * 6 has 2 distinct prime factors i.e 2 and 3.
 * Explanation 2:
 * Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumbers {
    public int solve(int A) {
        int[] array = new int[A + 1];
        for (int i = 2; i <= A; i++) {
            if (array[i] == 0) {
                for (int j = 2 * i; j <= A; j += i) {
                    array[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (array[i] == 2) {
                count++;
            }
        }
        return count;
    }
}
