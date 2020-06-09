package com.scaler.entrancetest.kavya;

/*
 * @author kavya k on 15-Feb-2020
 */

import java.util.Arrays;
/**
 * Given an integer array A of size N. You can delete at most B elements from the array such that GCD of the
 * remaining array is maximum.Find the maximum GCD of the remaining array.
 *
 * Problem constraints
 * 1<=N<=10000
 * 1<=A[i]<=50000
 * 0<=B<N
 *
 * example input
 * A=[2,6,3,9,8]
 * B=3
 *
 * example output 3
 */
public class GCDOfArray {

    public static void main(String[] args){
        int[] A = new int[]{2,6,3,9,8};
        int B = 3;
        System.out.println(findMaxGCD(A,B));
    }
    //sort the array so that maximum possible gcd will be at the end of the array.traverse from the last as we need
    //maximum possible gcd.
    //take the element from the last as gcd and check if the other elements can match this gcd.if no check the count of other elements
    //if the count is greater than B that is not gcd.go for the next highest element and check.
    //for checking gcd only greater elements are considered.so j loops starts from i+1;
    private static int findMaxGCD(int[] A , int B){
        Arrays.sort(A);
        for(int i=A.length-1;i>=0;i--){
            int count = 1;
            int gcd = A[i];
            for(int j=i+1;j<A.length;j++){
                if(findGCD(A[i] , A[j]) == gcd){
                    count++;
                }
            }
            if((A.length-count)<=B){
                return gcd;
            }
        }
        return 1;
    }

    private static int findGCD(int a ,int b){
        int m = Math.max(a,b);
        int n = Math.min(a,b);
        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
