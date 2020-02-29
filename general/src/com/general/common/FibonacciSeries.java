package com.general.common;

/**
 * @author kavya k on 20-Feb-2020
 */
public class FibonacciSeries {
    public static void main(String[] args){
        int N = 10;
        System.out.println(findNFibonacci(N));
    }

    private static int findNFibonacci(int N){
        if(N==1 || N==2){
            return 1;
        }
        int count =2;
        int next = 1;
        int value =1;
        while(count<N){
            int temp = value;
            value = value+next;
            next = temp;
            count++;
        }
         return value;
    }
}
