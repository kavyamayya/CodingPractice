package com.scaler.searching;

/**
 * @author kavya k on 08-Aug-2020
 * Problem Description
 * Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT
 * smaller than its neighbors. For corner elements, we need to consider only one neighbor. We ensure that answer
 * will be unique.
 * NOTE: Users are expected to solve this in O(log(N)) time.
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return the peak element.
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * A = [5, 17, 100, 11]
 *
 * Example Output
 * Output 1:
 *  5
 * Output 2:
 *  100
 *
 * Example Explanation
 * Explanation 1:
 *  5 is the peak.
 * Explanation 2:
 *  100 is the peak.
 *
 */
public class FindAPeakElement {
    public int solve(int[] A) {
        int l=0;
        int N = A.length;
        int r=N-1;
        while(l<=r){
            int mid = l+((r-l)/2);
            if(mid!=N-1 && A[mid]<A[mid+1]){
                l=mid+1;
            }else if(mid !=0 && A[mid]<A[mid-1]){
                r = mid-1;
            }else{
                return A[mid];
            }
        }
        return -1;
    }
}
