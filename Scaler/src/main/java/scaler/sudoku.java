package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author kavya k on 28-Mar-2020
 */
public class sudoku {
    static boolean pr[][] = new boolean[9][10];
    static boolean pc[][]=new boolean[9][10];
    static boolean pb[][][] = new boolean[3][3][10];
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
            if(index == 81){
                done = true;
            }
            for(int i=1;i<10 && !done;i++){
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

