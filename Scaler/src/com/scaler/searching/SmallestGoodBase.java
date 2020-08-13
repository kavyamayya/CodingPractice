package com.scaler.searching;

import java.math.BigInteger;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Smallest Good Base
 * Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A, you should return the smallest good base of A in string format.
 * Input Format
 * The only argument given is the string representing A.
 * Output Format
 * Return the smallest good base of A in string format.
 * Constraints
 * 3 <= A <= 10^18
 * For Example
 * Input 1:
 *     A = "13"
 * Output 1:
 *     "3"     (13 in base 3 is 111)
 * Input 2:
 *     A = "4681"
 * Output 2:
 *     "8"     (4681 in base 8 is 11111).
 */
public class SmallestGoodBase {
    public String solve(String A) {
        long N = Long.parseLong(A);
        int bits = 1 + (int)(Math.log(N)/Math.log(2));
        BigInteger ANum = new BigInteger(A);
        for(int i=bits;i>1;i--){
            long l=2;
            long r=ANum.subtract(BigInteger.ONE).longValue();
            while(l<=r){
                long mid = l+(r-l)/2;
                BigInteger sum=BigInteger.ZERO;
                for(int j=0;j<i;j++){
                    sum=sum.add(new BigInteger((long)Math.pow(mid,j)+""));
                }
                // BigInteger sumBig = new BigInteger(sum+"");
                if(sum.equals(ANum)){
                    return mid+"";
                }else if(sum.compareTo(ANum) > 0){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return ANum.subtract(BigInteger.ONE)+"";
    }
}
