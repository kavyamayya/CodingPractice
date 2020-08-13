package com.scaler.recursion;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Permutations
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 * NOTE:
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 * Problem Constraints
 * 1 <= N <= 9
 * Input Format
 * Only argument is an integer array A of size N.
 * Output Format
 * Return a 2-D array denoting all possible permutation of the array.
 * Example Input
 * A = [1, 2, 3]
 * Example Output
 * [ [1, 2, 3]
 *   [1, 3, 2]
 *   [2, 1, 3]
 *   [2, 3, 1]
 *   [3, 1, 2]
 *   [3, 2, 1] ]
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 */
public class Permutations {
    int count=0;
    public int[][] permute(int[] A) {
        int size = 1;
        for(int i=1;i<=A.length;i++){
            size*=i;
        }
        int[][] result = new int[size][A.length];
        permtation(A , 0 , result);
        return result;
    }

    public void permtation(int[] A , int currentIndex , int[][] result){
        if(currentIndex == A.length-1){
            result[count] = A.clone();
            count++;
        }
        for(int i=currentIndex; i<A.length;i++){
            int temp = A[i];
            A[i] = A[currentIndex];
            A[currentIndex] = temp;
            permtation(A , currentIndex+1, result);
            temp = A[i];
            A[i] = A[currentIndex];
            A[currentIndex] = temp;
        }
    }
}
