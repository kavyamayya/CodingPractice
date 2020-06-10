package com.scaler.maths;

import java.util.Arrays;

/**
 * @author kavya k on 10-Jun-2020
 * Prime Sum
 * Problem Description
 * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d], If a < c OR a==c AND b < d.
 * NOTE: A solution will always exist. Read Goldbach's conjecture.
 * Problem Constraints
 * 4 <= A <= 2*10^7
 *
 * Input Format
 * First and only argument of input is an even number A.
 *
 * Output Format
 * Return a integer array of size 2 containing primes whose sum will be equal to given number.
 *
 * Example Input
 *  4
 * Example Output
 *  [2, 2]
 * Example Explanation
 *  There is only 1 solution for A = 4.
 */
public class PrimeSum {
    public int[] primesum(int A) {
        int[] primeArray = new int[A+1];
        Arrays.fill(primeArray , 0);
        primeArray[0] = 1;
        primeArray[1] = 1;
        for(int i=2;i*i<=A;i++){
            if(primeArray[i] == 0){
                for(int j=i*i;j<=A;j+=i){
                    primeArray[j] = 1;
                }
            }
        }
        int[] resultArray = new int[2];
        for(int K =2;K<=A;K++){
            if(primeArray[K] ==0 && primeArray[A-K] == 0){
                resultArray[0] = K;
                resultArray[1] = A-K;
                break;
            }
        }
        return resultArray;
    }
}
