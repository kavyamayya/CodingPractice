package com.scaler.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kavya k on 09-Jun-2020
 *
 * Problem Description
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 * Output Format
 * Return the minimum number of swaps.
 *
 * Example Input
 * Input 1:
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 * Input 2:
 *  A = [5, 17, 100, 11]
 *  B = 20
 *
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  1
 *
 * Example Explanation
 * Explanation 1:
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 *  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 *  Now, all elements less than or equal to 8 are together.
 * Explanation 2:
 *  A = [5, 17, 100, 11]
 *  After swapping 100 and 11, A => [5, 17, 11, 100].
 *  Now, all elements less than or equal to 20 are together.
 */
public class MinimumSwaps {

    public int solve(int[] A, int B) {
        int N = A.length;
        int pointer =0;
        int count=0;
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]<=B ){
                list.add(i);
                total++;
            }
        }
        int swapsReq = 0;
        for(int i = 0; i < total; i++){
            if(A[i] > B){
                swapsReq++;
            }
        }

        // System.out.println(swapsReq);
        // Window Sliding
        int minSwaps = swapsReq;
        for(int i = total; i < N; i++){
            // Checking new element in window
            if(A[i] > B){
                swapsReq++;
            }

            // Checking the leaving element of window
            if(A[i - total] > B){
                swapsReq--;
            }

            // System.out.println(swapsReq);
            if(swapsReq < minSwaps){
                minSwaps = swapsReq;
            }
        }
        return minSwaps;
    }
}
