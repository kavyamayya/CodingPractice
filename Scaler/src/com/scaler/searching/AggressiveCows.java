package com.scaler.searching;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Aggressive cows
 * Problem Description
 * Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows.
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 * Output Format
 * Return the largest minimum distance possible among the cows.
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * A = [1, 2]
 * B = 2
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  1
 * Example Explanation
 * Explanation 1:
 * John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
 * So the minimum distance will be 2.
 * Explanation 2:
 * The minimum distance will be 1.
 */
public class AggressiveCows {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int min= Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            min = Math.min(min , A.get(i));
            max = Math.max(max , A.get(i));
        }
        int l=0;
        int r=max-min;
        int answer=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(A , B , mid)){
                answer = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return answer;
    }

    public boolean isPossible(ArrayList<Integer> A, int B, int mid){
        int count=1;
        int lastCow = A.get(0);
        for(int i=1;i<A.size();i++){
            if((A.get(i)-lastCow)>=mid){
                count++;
                lastCow = A.get(i);
            }
        }
        if(count>=B){
            return true;
        }
        return false;
    }
}
