package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 *
 * Number of Digit One
 * Problem Description
 * Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
 *
 * Problem Constraints
 * 0 <= A <= 10^9
 *
 * Input Format
 * The only argument given is the integer A.
 *
 * Output Format
 * Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.
 *
 * Example Input
 * Input 1:
 *  A = 10
 * Input 2:
 *  A = 11
 *
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  4
 *
 * Example Explanation
 * Explanation 1:
 * Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
 * Explanation 2:
 * Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.
 */
public class NumberOfDigitOne {

    public int solve(int A) {
        int ans = 0;
        for(int i = 1; i <= A; i *= 10){
            //i represents position like 1, 10 , 100
            // temp stores the value that needs to be considered before current position.
            // for 1s position we need to know how many 10s positions are there to know how many times this 1 is repeated
            int temp = i * 10;
            //below first part represents the number of 10s before 1.or number of 100s before 10.
            // second part checks the value in the current position
            ans += ((A/temp) * i) + Math.min(Math.max(A%temp-i+1, 0), i);
        }
        return ans;
    }
}
