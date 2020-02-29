package com.interviewbit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kavya k on 05-Feb-2020
 */
public class SendTheMessage {

    public static void main(String[] args){
        System.out.println(new Date());
        Integer A =16;
        int[] B = new int[]{1,2,5,10,1,3,7,3,2,6,1,4,9,14,15};
        int[] C = new int[]{2,5,10,11,3,7,13,8,6,12,4,9,14,15,16};
        System.out.println(sendMessage(A ,B,C));
        System.out.println(new Date());
    }

    private static int sendMessage(Integer A,int[] B,int[] C){
        Map<Integer,Integer> map = new HashMap<>();
        int count=0,maxBranch=0,maxLength=0;
        for(int i=1;i<A;i++){
            if(!map.containsKey(B[i-1])){
               map.put(B[i-1],1);
               count=1;
            }else{
               count = map.get(B[i-1])+1;
               map.put(B[i-1],count);
            }
            if(count>maxBranch){
                maxBranch = count;
            }
        }
        System.out.println(maxBranch);
        return count;
    }
}
