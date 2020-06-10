package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given an integer array A of size N.
 * Find the minimum number of elements that need to be removed such that the GCD of the resulting array becomes 1.
 * If not possible then return -1.
 * Problem Constraints
 * 1 <= N <= 100000
 * 1 <= A[i] <= 1e9
 *
 * Input Format
 * Input contains a single integer array A
 *
 * Output Format
 * Return an integer
 *
 * Example Input
 * Input 1:
 *  A = [7, 2, 5]
 * Example Output
 * Output 1:
 *  0
 * Example Explanation
 * Explanation 1:
 *  GCD of the array A is 1.
 *  so, the number of elements to be removed is 0.
 */
public class DeleteElements {
    public int solve(int[] A) {
        int gcd = A[0];
        for(int i=1;i<A.length;i++){
            gcd = gcd(gcd , A[i]);
        }
        if(gcd == 1){
            return 0;
        }else{
            return -1;
        }
    }

    public int gcd(int A, int B) {
        int m = Math.max(A,B);
        int n = Math.min(A,B);
        if(n ==0){
            return m;
        }
        return gcd(n,m%n);
    }
}
