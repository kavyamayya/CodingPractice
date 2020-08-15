package com.scaler.sorting;

import java.util.ArrayList;

/**
 * @author kavya k on 13-Aug-2020
 * Alternate positive and negative elements
 * Problem Description
 * Given an array of integers A, arrange them in an alternate fashion such that every non-negative number is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance. The number of non-negative and negative numbers need not be equal.
 * If there are more non-negative numbers they appear at the end of the array. If there are more negative numbers, they too appear at the end of the array.
 * Note: Try solving with O(1) extra space.
 * Problem Constraints
 * 1 <= length of the array <= 7000
 * -10^9 <= A[i] <= 10^9
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * Output Format
 * Return the modified array.
 *
 * Example Input
 * Input 1:
 *  A = [-1, -2, -3, 4, 5]
 * Input 2:
 *  A = [5, -17, -100, -11]
 *
 * Example Output
 * Output 1:
 *  [-1, 4, -2, 5, -3]
 * Output 2:
 *  [-17, 5, -100, -11]
 * Example Explanation
 * Explanation 1:
 * A = [-1, -2, -3, 4, 5]
 * Move 4 in between -1 and -2, A => [-1, 4, -2, -3, 5]
 * Move 5 in between -2 and -3, A => [-1, 4, -2, 5, -3]
 */
public class AlternatePositiveAndNegativeElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int sign = -1;
        for(int i=0;i<A.size();i++){
            if(!((A.get(i)<0 && sign<0) || (A.get(i)>=0 && sign>=0))){
                int l=i;
                int r =i;
                while(r!=(A.size()-1) && !((A.get(r)<0 && sign<0) || (A.get(r)>=0 && sign>=0))){
                    r++;
                }
                if(r !=A.size()-1 ||((A.get(r)<0 && sign<0) || (A.get(r)>=0 && sign>=0)) ){
                    int temp = A.get(r);
                    while(l < r){
                        A.set(r , A.get(r-1));
                        r--;
                    }
                    A.set(l,temp);
                }
            }
            sign*=-1;
        }
        return A;
    }
}
