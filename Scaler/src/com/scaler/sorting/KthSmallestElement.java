package com.scaler.sorting;

import java.util.List;

/**
 * @author kavya k on 13-Aug-2020
 * Kth Smallest Element
 * Problem Description
 * Find the Bth smallest element in given array A .
 * NOTE: Users should try to solve it in <= B swaps.
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= B <= min(|A|, 500)
 * 1 <= A[i] <= 10^9
 * Input Format
 * First argument is vector A.
 * Second argument is integer B.
 * Output Format
 * Return the Bth smallest element in given array.
 * Example Input
 * Input 1:
 * A = [2, 1, 4, 3, 2]
 * B = 3
 * Input 2:
 * A = [1, 2]
 * B = 2
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  2
 * Example Explanation
 * Explanation 1:
 *  3rd element after sorting is 2.
 * Explanation 2:
 *  2nd element after sorting is 2.
 */
public class KthSmallestElement {
    public int kthsmallest(final List<Integer> A, int B) {
        int lessCount = 0;
        int moreCount = 0;
        int count=0;
        int pointer=-1;
        int min = Integer.MAX_VALUE;
        int max= 0;
        while(pointer<(A.size()-1)){
            pointer++;
            if( A.get(pointer)<min && A.get(pointer)>max){
                for(int i=0;i<A.size();i++){
                    if(A.get(i)< A.get(pointer)){
                        lessCount++;
                    }else if(A.get(i)> A.get(pointer)){
                        moreCount++;
                    }else{
                        count++;
                    }
                }
                if(lessCount<B && (lessCount+count)>=B){
                    break;
                }
                if(lessCount>=B){
                    min = Math.min(min, A.get(pointer));
                }
                if(moreCount>(A.size()-B)){
                    max = Math.max(max , A.get(pointer));
                }
                lessCount=0;
                moreCount=0;
                count=0;
            }
        }
        return A.get(pointer);
    }
}
