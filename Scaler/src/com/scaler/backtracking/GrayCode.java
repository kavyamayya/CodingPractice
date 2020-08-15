package com.scaler.backtracking;

import java.util.ArrayList;

/**
 * @author kavya k on 13-Aug-2020
 * Gray Code
 * Problem Description
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * Problem Constraints
 * 1 <= A <= 16
 * Input Format
 * First argument is an integer A.
 * Output Format
 * Return an array of integers representing the gray code sequence.
 * Example Input
 * Input 1:
 * A = 2
 * Input 1:
 * A = 1
 * Example Output
 * output 1:
 * [0, 1, 3, 2]
 * output 2:
 * [0, 1]
 * Example Explanation
 * Explanation 1:
 * for A = 2 the gray code sequence is:
 *     00 - 0
 *     01 - 1
 *     11 - 3
 *     10 - 2
 * So, return [0,1,3,2].
 * Explanation 1:
 * for A = 1 the gray code sequence is:
 *     00 - 0
 *     01 - 1
 * So, return [0, 1].
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        if(a == 1){
            return list;
        }
        recursive(a,2,list);
        return list;
    }
    public void recursive(int N , int a, ArrayList<Integer> list){
        if(a > N){
            return;
        }
        for(int i=list.size()-1;i>=0;i--){
            list.add(list.get(i)+(1<<a-1));
        }
        recursive(N , a+1,list);
    }
}
