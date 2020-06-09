package com.scaler.entrancetest.sudhir;

import java.util.Arrays;

/**
 * @author kavya k on 02-Feb-2020
 */
public class BalanceTheBrackets {
    public static void main(String[] args){
        String A = "((";
        System.out.println(Arrays.toString(numberOfBracketsToBeAdded(A)));
    }

    private static int[] numberOfBracketsToBeAdded(String A){
        char[] charArray = A.toCharArray();
        int numOpen = 0;
        int[] returnArray = new int[2];
        int count=0;
        for (char c : charArray) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                numOpen++;
                count = 0;
            }
        }
        int numClose = count;
        returnArray[0] = numOpen;
        returnArray[1] = numClose;
        System.out.println("numOpen :"+numOpen);
        System.out.println("numClose :"+numClose);
        return returnArray;
    }
}
