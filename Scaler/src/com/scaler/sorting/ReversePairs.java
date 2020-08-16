package com.scaler.sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kavya k on 13-Aug-2020
 * Reverse pairs
 * Problem Description
 * Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
 * Return the number of important reverse pairs in the given array A.
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return the number of important reverse pairs in the given array A.
 *
 * Example Input
 * Input 1:
 *  A = [1, 3, 2, 3, 1]
 * Input 2:
 *  A = [4, 1, 2]
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  1
 *
 * Example Explanation
 * Explanation 1:
 *  There are two pairs which are important reverse i.e (3, 1) and (3, 1).
 * Explanation 2:
 *  There is only one pair i.e (4, 1).
 */
public class ReversePairs {
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
            while(l<first.size() && (first.get(l)<=(2*second.get(s)))){
                l++;
            }
            count=(count+(first.size()-l));
            s++;
        }
    }

}
