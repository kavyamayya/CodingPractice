package com.interviewbit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author kavya k on 10-Apr-2020
 */
public class TEST {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2));
       // solve(A);
        test();
    }
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int mod = 1000000007;
        int N = A.size();
        long answer=0L;
        long add =1;
        for(int i=0;i<N;i++){
            answer=(answer+add*A.get(i)%mod)%mod;
            long B = (N-1-i)%31;
            long sub = 0;
            if((N-1-i)/31 !=0){
                sub = (long)(Math.pow(2 , 31)%mod)*(long)(Math.pow(2 , B)%mod);
            }else{
                sub = (long)(Math.pow(2 , (N-1-i))%mod);
            }
            answer=answer-(sub*A.get(i)%mod);
            add=(add*2%mod);
        }
        return (int)answer;
    }

    public static void test() {
        int N = 1000;
        long B = (N-1)%31;
        long sub = 0;
        if((N-1)/31 !=0){
            sub = ((long)(Math.pow(2 , 31)%1000000007)*(long)(Math.pow(2 , B)%1000000007))%1000000007;
        }else{
            sub = (long)(Math.pow(2 , (N-1))%1000000007);
        }
    }
}
