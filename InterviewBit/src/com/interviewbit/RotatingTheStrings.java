package com.interviewbit;

import java.util.Arrays;

/**
 * @author kavya k on 03-Feb-2020
 */
public class RotatingTheStrings {
    public static void main(String[] args){
        String A = "AA";
        int[] B = new int[]{1,2,3};
        int[] result = findSameIndices(A,B);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] findSameIndices(String A , int[] B){
        int stringLength = A.length();
        int[] returnArray = new int[B.length];
        for(int i=0;i<B.length;i++){
            int count=0;
            for(int k=0;k<stringLength;k++){
                if(A.charAt(k) == (A.charAt((k+B[i])%stringLength))){
                    count++;
                }
            }
            returnArray[i] = count;
        }
        return returnArray;
    }
}
