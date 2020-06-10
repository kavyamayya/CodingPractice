package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Count of divisors
 * Problem Description
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 * NOTE: Order of the resultant array should be same as the input array.
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^6
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * Output Format
 * Return the count of divisors of each element of the array in the form of an array.
 * <p>
 * Example Input
 * Input 1:
 * A = [2, 3, 4, 5]
 * Input 2:
 * A = [8, 9, 10]
 * <p>
 * Example Output
 * Output 1:
 * [2, 2, 3, 2]
 * Output 1:
 * [4, 3, 4]
 * <p>
 * Example Explanation
 * Explanation 1:
 * The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 * So the count will be [2, 2, 3, 2].
 * Explanation 2:
 * The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 * So the count will be [4, 3, 4].
 */
public class CountOfDivisors {
    public int[] solve(int[] A) {
        int N = A.length;
        int[] resultArray = new int[N];
        /*for(int i=0;i<A.length;i++){
            int count = 0;
            for(int j=1;j*j<=A[i];j++){
                if(A[i]%j == 0){
                    if(A[i]/j != j){
                        count+=2;
                    }else{
                        count+=1;
                    }
                }
            }
            resultArray[i] = count;
        }*/
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, A[i]);
        }
        // System.out.println(max);
        int[] array = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            array[i]++;
            for (int j = 2 * i; j <= max; j += i) {
                array[j]++;
                //System.out.println("j " + j + " " + array[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            resultArray[i] = array[A[i]];
        }
        return resultArray;
    }
}
