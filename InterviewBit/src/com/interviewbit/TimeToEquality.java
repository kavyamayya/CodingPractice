package com.interviewbit;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author kavya k on 03-Feb-2020
 */
public class TimeToEquality {

    public static void main(String[] args){
        Integer[] A = new Integer[]{1,2,3,5,2};
        System.out.println(findTime(A));
    }

    private static int findTime(Integer[] A){
        int max = Collections.max(Arrays.asList(A));
        int time=0;
        for (Integer integer : A) {
            time += (max - integer);
        }
        return time;
    }
}
