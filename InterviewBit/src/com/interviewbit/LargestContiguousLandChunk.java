package com.interviewbit;

import java.util.Date;

/**
 * @author kavya k on 03-Feb-2020
 */
public class LargestContiguousLandChunk {

    public static void main(String[] args){
        System.out.println(new Date());
        String A = "ababaabaa";
        Integer B =2;
        System.out.println(findLargestLand(A ,B));
        System.out.println(new Date());
    }

    private static int findLargestLand(String A ,Integer B){
        int count=0,max=0;
        int temp=B;
        int r=0,l=0;
        int N = A.length();
       /* while (r<A.length()) {
            temp=B;
            count=0;
            while(true) {
                if (A.charAt(r) == 'a') {
                    count++;
                } else {
                    if (temp != 0) {
                        if (temp == B) {
                            l = r + 1;
                        }
                        temp--;
                        count++;
                    } else {
                        r = l;
                        break;
                    }
                }
                r++;
                if(r == A.length()){
                    break;
                }
            }
            if(max<count) {
                max=count;
            }
        }*/

        while (r<N) {
           // temp=B;
          //  count=0;
            if (A.charAt(r) == 'a') {
                count++;
                r++;
            } else {
                if (temp != 0) {
                    if (temp == B) {
                        l = r + 1;
                    }
                    temp--;
                    count++;
                    r++;
                } else {
                    r = l;
                    count=0;
                    temp=B;
                }
            }
            if(max<count) {
                max=count;
            }
        }
        return max;
    }
}
