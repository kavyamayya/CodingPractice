package com.interviewbit;

import java.util.Scanner;
/*
 * Given an array of elements of length N, ranging from 0 to N-1, your task is to write a program that rearranges
 * the elements of the array. All elements may not be present in the array, if element is not present then there
 * will be -1 present in the array. Rearrange the array such that A[i] = i and if i is not present, display -1
 * at that place.
 * examples:
 * Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 * Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 *
 * Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
 *               11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
 * Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 *          11, 12, 13, 14, 15, 16, 17, 18, 19]
 */

/**
 * @author kavya k on 08-Feb-2020
 */
public class RearrangeArray {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase= 1;
        for(int i=0;i<testcase;i++){
            int N =  10;
            int[] array = new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
            System.out.println(array.length);
            reArrange(N,array);
        }
    }
    //Recursive way starts
    private  static void reArrange(int N , int[] array){
        for(int i=0;i<N;i++){
            if(array[i]>0 && array[i]!=i){
                int temp = array[i];
                rearrange(array , temp);
            }
        }
        for(int k=0;k<N;k++){
            if(array[k]!=k){
                array[k] =-1;
            }
            System.out.print(array[k]+" ");
        }
        System.out.println();
    }

    private static void rearrange(int[] array , int index){
        int value = array[index];
        array[index] = index;
        if(value>0 && value!=array[value]){
            rearrange(array , value);
        }
    }
    //Recursive way ends

    //iterative way starts
    private  static void reArrangeIterative(int N , int[] array){
        for(int i=0;i<N;i++){
            if(array[i]>=0 && array[i]!=i){
                int temp = array[i];
                int value = array[temp];
                array[temp] = temp;
                while(value >= 0 && value != array[value]) {
                    temp = value;
                    value = array[temp];
                    array[temp] = temp;
                }
            }
        }
        for(int k=0;k<N;k++){
            if(array[k]!=k){
                array[k] =-1;
            }
            System.out.print(array[k]+" ");
        }
        System.out.println();
    }
    //iterative way ends
}