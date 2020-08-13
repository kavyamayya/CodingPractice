package com.scaler.backtracking;

import java.util.ArrayList;

/**
 * @author kavya k on 13-Aug-2020
 *
 * NQueens
 * Problem Description
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack
 * each other.
 *
 * Given an integer A, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 * Input Format
 * First argument is an integer n denoting the size of chessboard
 *
 * Output Format
 * Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
 *
 * Example Input
 * Input 1:
 * A = 4
 * Input 2:
 * A = 1
 * Example Output
 * Output 1:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Output 1:
 * [
 *  [Q]
 * ]
 *
 * Example Explanation
 * Explanation 1:
 * There exist only two distinct solutions to the 4-queens puzzle:
 * Explanation 1:
 * There exist only one distinct solutions to the 1-queens puzzle:
 */
public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int[] vc = new int[a];
        int[] vd1 = new int[2*a];
        int[] vd2 = new int[2*a];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                if(i == j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            vc[i] = 1;
            vd1[i-0+a] = 1;
            vd2[0+i] = 1;
            ArrayList<String> array = new ArrayList<String>();
            array.add(sb.toString());
            //System.out.println(array);
            recursive(a,result,array,1,vc,vd1,vd2);
            sb = new StringBuilder("");
            vc[i] = 0;
            vd1[i-0+a] =0;
            vd2[0+i] = 0;
        }

        return result;
    }

    public void recursive(int a,ArrayList<ArrayList<String>> result ,ArrayList<String> array, int row,int[] vc , int[] vd1 , int[] vd2){
        if(row == a){
            // System.out.println("matched :"+ array);
            ArrayList<String> resultFinal = new ArrayList<String>();
            resultFinal.addAll(array);
            result.add(resultFinal);
            return;
        }
        for(int i=row;i<a;i++){
            for(int j=0;j<a;j++){
                //  System.out.println("j :"+ j);
                if(vc[j]!=1 && vd1[j-i+a]!=1 && vd2[i+j]!=1 && array.size()==i){
                    StringBuilder sb = new StringBuilder("");
                    for(int k=0;k<a;k++){
                        if(k == j){
                            sb.append("Q");
                        }else{
                            sb.append(".");
                        }
                    }
                    vc[j] = 1;
                    vd1[j-i+a] = 1;
                    vd2[i+j] = 1;
                    array.add(sb.toString());
                    //  System.out.println(array+ " row "+ i);
                    recursive(a,result,array ,i+1 , vc ,vd1,vd2);
                    array.remove(array.size()-1);
                    vc[j]=0;
                    vd1[j-i+a] = 0;
                    vd2[i+j] = 0;
                }
            }
        }
    }
}
