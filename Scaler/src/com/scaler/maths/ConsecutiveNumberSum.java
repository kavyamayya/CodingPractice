package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given an integer A.
 * Return number of ways we can write A as a sum of consecutive positive integers.
 * Problem Constraints
 * 1 <= A <= 10^9
 *
 * Input Format
 * The first argument given is the integer A.
 *
 * Output Format
 * Return number of ways we can write A as a sum of consecutive positive integers.
 *
 * Example Input
 * A = 9
 * Example Output
 * 3
 *
 * Example Explanation
 * A = 9
 * A = 2 + 3 + 4
 * A = 5 + 4
 */
public class ConsecutiveNumberSum {
    public int solve(int A) {
        int ans = 1;
        for(int n = 2; n * (n + 1) / 2 <= A; n++){
            if((A - n * (n + 1) / 2) % n == 0){
                ans++;
            }
        }
        return ans;
    }
}
