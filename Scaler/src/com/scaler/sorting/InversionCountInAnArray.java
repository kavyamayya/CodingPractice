package com.scaler.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kavya k on 13-Aug-2020
 * Inversion count in an array
 * Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A.
 * Find the total number of inversions of A modulo (109 + 7).
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return the number of inversions of A modulo (109 + 7).
 * Example Input
 * Input 1:
 * A = [3, 2, 1]
 * Input 2:
 * A = [1, 2, 3]
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 0
 *
 * Example Explanation
 * Explanation 1:
 *  All pairs are inversions.
 * Explanation 2:
 *  No inversions.
 */
public class InversionCountInAnArray {
    int count=0;
    public int solve(ArrayList<Integer> A) {
        recursion(A);
        return count;
    }
    public void recursion(ArrayList<Integer> A ){
        if(A.size() == 1){
            return;
        }
        int n = A.size()/2;
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        for(int i=0;i<(n+A.size()%2);i++){
            first.add(A.get(i));
        }
        recursion(first);
        Collections.sort(first);
        for(int i=(n+A.size()%2);i<A.size();i++){
            second.add(A.get(i));
        }
        recursion(second);
        Collections.sort(second);
        int l=0;
        int s =0;
        while(s<second.size()){
            while(l<first.size() && (first.get(l)<=second.get(s))){
                l++;
            }
            count=(count+(first.size()-l))%1000000007;
            s++;
        }

    }
}
