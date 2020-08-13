package com.scaler.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author kavya k on 28-Mar-2020
 *
 * Sudoku
 * Problem Description
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character
 * '.' You may assume that there will be only one unique solution.
 *
 * Problem Constraints
 * N = 9
 * Input Format
 * First argument is an array of array of characters representing the Sudoku puzzle.
 * Output Format
 * Modify the given input to the required answer.
 * Example Input
 * Input 1:
 * A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 * Example Output
 * Output 1:
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 * Example Explanation
 * Explanation 1:
 * Look at the diagrams given in the question.
 */
public class Sudoku {
    // pr[i][num] indicates num is present in ith row if true, false otherwise
    static boolean pr[][] = new boolean[9][10];
    // pc[j][num] indicates num is present in jth column if true, false otherwise
    static boolean pc[][]=new boolean[9][10];
    // pb[i][j][num] indicates num is present in ith row and jth column box if true, false otherwise
    // there are a total of 9 3*3 boxes. each box has 3 rows and 3 columns.
    static boolean pb[][][] = new boolean[3][3][10];
    // done = true indicates sudoku is possible or not
    static boolean done=false;
    public static void main(String[] args){
        ArrayList<Character> one = new ArrayList<Character>(Arrays.asList('5','3','.','.','7','.','.','.','.'));
        ArrayList<Character> two = new ArrayList<Character>(Arrays.asList('6','.','.','1','9','5','.','.','.'));
        ArrayList<Character> three = new ArrayList<Character>(Arrays.asList('.','9','8','.','.','.','.','6','.'));
        ArrayList<Character> four = new ArrayList<Character>(Arrays.asList('8','.','.','.','6','.','.','.','3'));
        ArrayList<Character> five = new ArrayList<Character>(Arrays.asList('4','.','.','8','.','3','.','.','1'));
        ArrayList<Character> six = new ArrayList<Character>(Arrays.asList('7','.','.','.','2','.','.','.','6'));
        ArrayList<Character> seven = new ArrayList<Character>(Arrays.asList('.','6','.','.','.','.','2','8','.'));
        ArrayList<Character> eight = new ArrayList<Character>(Arrays.asList('.','.','.','4','1','9','.','.','5'));
        ArrayList<Character> nine = new ArrayList<Character>(Arrays.asList('.','.','.','.','8','.','.','7','9'));
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>(Arrays.asList(one,two,three,four,five,six,seven,eight,nine));
        solveSudoku(a);
    }

        public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
            int M = a.size();
            int N = a.get(0).size();
            System.out.println("M :"+ M +" N "+ N);
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(a.get(i).get(j)!='.'){
                        int num = Integer.parseInt(a.get(i).get(j)+"");
                        pr[i][num] = true;
                        pc[j][num] = true;
                        pb[i/3][j/3][num] = true;
                    }
                }
            }
            sudoku(0, a);
        }

        public static void sudoku(int index ,ArrayList<ArrayList<Character>> a){
            int r = index/9;
            int c = index%9;
            while(r!=9 && c!=9 && a.get(r).get(c)!='.'){
                index++;
                r = index/9;
                c = index%9;
            }
            // we do insertion from index 0 to index 80. when index = 81 is reached, it means we are done.
            if(index == 81){
                done = true;
            }
            for(int i=1;i<=9 && !done;i++){
                if(!pr[r][i]  && !pc[c][i] && !pb[r/3][c/3][i]){
                    pr[r][i] = true;
                    pc[c][i] = true;
                    pb[r/3][c/3][i]= true;
                    a.get(r).set(c,(char)(i+'0'));
                    sudoku(index+1 , a);
                    if(!done) {
                        a.get(r).set(c, '.');
                        pr[r][i] = false;
                        pc[c][i] = false;
                        pb[r / 3][c / 3][i] = false;
                    }
                }
            }
        }
    }

