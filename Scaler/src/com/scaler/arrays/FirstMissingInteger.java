package com.scaler.arrays;

/**
 *
 * Given an unsorted integer array A of size N. Find the first missing positive integer. Note: Your algorithm should
 * run in O(n) time and use constant space.
 *
 * Problem Constraints
 * 1 <= N <= 1000000 -10^9 <= A[i] <= 10^9
 *
 * Input Format
 * First argument is an integer array A.
 *
 * Output Format
 * Return an integer denoting the first missing positive integer.
 *
 * Example Input
 * Input 1:
 * [1, 2, 0]
 * Input 2:
 * [3, 4, -1, 1]
 * Input 3:
 * [-8, -7, -6]
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 2
 * Output 3:
 * 1
 *
 * Example Explanation
 * Explanation 1:
 * A = [1, 2, 0]
 * First positive integer missing from the array is 3.
 *
 * @author kavya k on 18-May-2020
 */
public class FirstMissingInteger {

    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;){
            if ((i+1) == A[i]) {
                i++;
            }else if(A[i] > 0 && A[i] <= A.length){
                if(A[A[i]-1] == A[i]){
                    i++;
                }else {
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
                }
            }else{
                i++;
            }
        }
        int count=1;
        for(int i=0;i<A.length;i++){
            if(A[i]==count){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
