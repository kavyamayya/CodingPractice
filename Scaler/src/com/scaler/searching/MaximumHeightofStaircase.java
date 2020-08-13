package com.scaler.searching;

/**
 * @author kavya k on 08-Aug-2020
 *
 *Maximum height of staircase
 * Problem Description
 * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max height using these blocks.
 * The first stair would require only one block, the second stair would require two blocks and so on.
 * Find and return the maximum height of the staircase.
 *
 * Problem Constraints
 * 0 <= A <= 10^9
 * Input Format
 * The only argument given is integer A.
 * Output Format
 * Return the maximum height of the staircase using these blocks.
 * Example Input
 * Input 1:
 *  A = 10
 * Input 2:
 *  20
 * Example Output
 * Output 1:
 *  4
 * Output 2:
 *  5
 */
public class MaximumHeightofStaircase {
    public int solve(int A) {
        long l=0;
        long N =A;
        long r=N;
        int answer = -1;
        while(l<=r){
            long mid = l+((r-l)/2);
            if(!isPossible(A,mid)){
                r = mid-1;
            }else{
                answer = (int)mid;
                l=mid+1;
            }
        }
        return answer;
    }

    public boolean isPossible(int bricks , long num){
        long requiredBricks = (num*(num+1))/2;
        if(bricks>=requiredBricks){
            return true;
        }
        return false;
    }
}
