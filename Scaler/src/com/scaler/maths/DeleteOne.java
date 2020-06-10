package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 * Find the maximum value of GCD.
 *
 * Problem Constraints
 * 2 <= N <= 105
 * 1 <= A[i] <= 109
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Output Format
 * Return an integer denoting the maximum value of GCD.
 *
 * Example Input
 * Input 1:
 *  A = [12, 15, 18]
 * Input 2:
 *  A = [5, 15, 30]
 *
 * Example Output
 * Output 1:
 *  6
 * Output 2:
 *  15
 *
 * Example Explanation
 * Explanation 1:
 *  If you delete 12, gcd will be 3.
 *  If you delete 15, gcd will be 6.
 *  If you delete 18, gcd will 3.
 *  Maximum vallue of gcd is 6.
 * Explanation 2:
 *  If you delete 5, gcd will be 15.
 *  If you delete 15, gcd will be 5.
 *  If you delete 30, gcd will be 5.
 */
public class DeleteOne {
    public int solve(int[] A) {
        int N = A.length;
        int[] prefix = new int[N];
        int[] suffix = new int[N];
        prefix[0] = A[0];
        for(int i=1;i<N;i++){
            prefix[i] = gcd(prefix[i-1],A[i]);
        }
        suffix[N-1] = A[N-1];
        for(int i=N-2;i>=0;i--){
            suffix[i] = gcd(suffix[i+1],A[i]);
        }
        int maxGcd = gcd(0,suffix[1]);
        for(int i=1;i<N;i++){
            int gcd;
            if(i == N-1){
                gcd = gcd(prefix[i-1],0);
            }else{
                gcd = gcd(prefix[i-1],suffix[i+1]);
            }
            if(maxGcd<gcd){
                maxGcd = gcd;
            }
        }
        return maxGcd;
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
