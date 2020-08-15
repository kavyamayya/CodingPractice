package com.scaler.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kavya k on 13-Aug-2020
 * Merge Two Sorted Arrays
 * Problem Description
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 * Problem Constraints
 * -1010 <= A[i],B[i] <= 10^10
 * Input Format
 * First Argument is a 1-D array representing A.
 * Second Argument is also a 1-D array representing B.
 * Output Format
 * Return a 1-D vector which you got after merging A and B.
 * Example Input
 * Input 1:
 * A = [4, 7, 9 ]
 * B = [2 ,11, 19 ]
 * Input 2:
 * A = [1]
 * B = [2]
 * Example Output
 * Output 1:
 * [2, 4, 7, 9, 11, 19]
 * Output 2:
 * [1, 2]
 * Example Explanation
 * Explanation 1:
 * Merging A and B produces the output as described above.
 * Explanation 2:
 *  Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArrays {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int N = A.size();
        int M = B.size();
        int first = 0;
        int second = 0;
        for(int i=0;first<N && second<M;i++){
            if(A.get(first)<B.get(second)){
                result.add(A.get(first));
                first++;
            }else{
                result.add(B.get(second));
                second++;
            }
        }
        for(int i=first;i<N;i++){
            result.add(A.get(i));
        }
        for(int i=second;i<M;i++){
            result.add(B.get(i));
        }
        return result;
    }
}
