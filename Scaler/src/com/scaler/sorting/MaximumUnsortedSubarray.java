package com.scaler.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kavya k on 13-Aug-2020
 * Maximum Unsorted Subarray
 * Problem Description
 * Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that
 * if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted,
 * output -1.
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 1000000
 * Input Format
 * First and only argument is an array of non-negative integers of size N.
 * Output Format
 * Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes
 * the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only
 * one element i.e. -1.
 * Example Input
 * Input 1:
 * A = [1, 3, 2, 4, 5]
 * Input 2:
 * A = [1, 2, 3, 4, 5]
 * Example Output
 * Output 1:
 * [1, 2]
 * Output 2:
 * [-1]
 * Example Explanation
 * Explanation 1:
 * If we sort the sub-array A1, A2, then the whole array A gets sorted.
 * Explanation 2:
 * A is already sorted.
 */
public class MaximumUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int l=0;
        int r=0;
        for(int i=1;i<A.size();i++){
            if(A.get(i)>=A.get(i-1)){
                continue;
            }else{
                l= i;
                break;
            }
        }
        r = l;
        for(int i=1;i<A.size();i++){
            if(A.get(i)<A.get(i-1)){
                r = i;
            }
        }
        if(l == 0 && r == 0){
            return new ArrayList<Integer>(Arrays.asList(-1));
        }
        int min = A.get(l);
        int max = A.get(r);
        for(int i=l;i<=r;i++){
            min = Math.min(min, A.get(i));
            max = Math.max(max,A.get(i));
        }
        int m=l-1;
        for(;m>=0;m--){
            if(min>=A.get(m)){
                break;
            }else{
                max =Math.max(max , A.get(m));
            }
        }
        l=m+1;
        int i=r+1;
        for(;i<A.size();i++){
            if(max<=A.get(i)){
                break;
            }
        }
        r = i-1;
        return new ArrayList<Integer>(Arrays.asList(l , r));
    }
}
