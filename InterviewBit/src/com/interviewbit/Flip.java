package com.interviewbit;

/**
 * @author kavya k on 07-Mar-2020
 */
public class Flip {

    public static void main(String[] args){
        String A = "0111000100010";
        flipFunction(A);
    }

    private static int[] flipFunction(String A){
        int start=0,end=0,max=0,sum=0,endMin=0,startMin=0;
        for(int i=0;i<A.length();i++){
            end=i;
            if(A.charAt(i)=='0'){
                sum+=1;
            }else{
                sum-=1;
            }
            if(sum<0){
                sum=0;
                start=i+1;
            }
            if(max<sum){
                max=sum;
                endMin=end;
                startMin=start;
            }
        }
        if(max!=0){
            return new int[]{startMin+1,endMin+1};
        }
        return new int[]{};
    }
}
