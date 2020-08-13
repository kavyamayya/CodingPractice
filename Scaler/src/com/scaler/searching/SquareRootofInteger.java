package com.scaler.searching;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Square Root of Integer
 * Problem Description
 * Given an integer A.
 * Compute and return the square root of A.
 * If A is not a perfect square, return floor(sqrt(A)).
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
 * NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.
 * Problem Constraints
 * 0 <= A <= 10^10
 * Input Format
 * The first and only argument given is the integer A.
 * Output Format
 * Return floor(sqrt(A))
 * Example Input
 * Input 1:
 *  11
 * Input 2:
 *  9
 * Example Output
 * Output 1:
 *  3
 * Output 2:
 *  3
 * Example Explanation
 * Explanation:
 *  When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 *  When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootofInteger {
    public int sqrt(int A) {
        if(A == 0){
            return A;
        }
        long l=1;
        long r=100000;
        long answer = 1;
        while(l<=r){
            long mid = l+(r-l)/2;
            // System.out.println(mid + " r :"+r +" l :"+ l);
            if((mid*mid)>A){
                //System.out.println("first");
                r=mid-1;
            }else{
                // System.out.println("second");
                answer = mid;
                l=mid+1;
            }
        }
        return (int)answer;
    }
}
