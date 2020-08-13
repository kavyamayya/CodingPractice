package com.scaler.searching;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Special Integer
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no
 * subarray in A of size K with sum of elements greater than B.
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * Output Format
 * Return the maximum value of K (sub array length).
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 * A = [5, 17, 100, 11]
 * B = 130
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  3
 * Example Explanation
 * Explanation 1:
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 * Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {
    public int solve(int[] A, int B) {
        int N = A.length;
        int l=0;
        int r=N;
        while(l<=r){
            int mid = l+ (r-l)/2 ;
            if(isValidSum(mid,A,B)){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l-1;
    }

    private boolean isValidSum(int mid,int[] array , int B){
        long sum = 0;
        for(int i=0;i<mid;i++){
            sum+=array[i];
        }
        if(sum<=B){
            for (int i=mid;i<array.length;i++) {
                sum =sum + array[i]-array[i-mid];
                if(sum>B){
                    return false ;
                }
            }
            return true;
        }
        return false;
    }
}
