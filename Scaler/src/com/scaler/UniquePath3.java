package com.scaler;

/**
 * @author kavya k on 28-Mar-2020
 */
public class UniquePath3 {
    public static int resultCount=0;
    public static void main(String[] args){
        int[] one = new int[]{1,0,0};
        int[] two = new int[]{-1,0,0};
        int[] three = new int[]{-1,0,2};
        int[][] A = new int[3][3];
        A[0] = one;
        A[1]=two;
        A[2]=three;
        solve(A);
    }
    public static int solve(int[][] A) {
        int zeroCounts =0;
        int M = A.length;
        int N = A[0].length;
        int SR=0;
        int SC=0;
        int ER = 0;
        int EC = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(A[i][j] == 0){
                    zeroCounts++;
                }else if(A[i][j] == 1){
                    SR = i;
                    SC = j;
                }else if(A[i][j] == 2){
                    ER = i;
                    EC = j;
                }
            }
        }
        System.out.println("ER :"+ ER+" EC :"+ EC);
        recursion(SR, SC, ER, EC,zeroCounts , -1 , A);
        return resultCount;
    }

    public static void recursion(int row , int column , int ER , int EC , int zeroCounts,int count,int[][] A){
        System.out.println("row :"+ row+" column :"+ column);
        if((row == ER)&&(column == EC)){
            System.out.println("zeroes :"+ zeroCounts + " count :"+ count);
            if(zeroCounts == count){
                System.out.println("arrived");
                resultCount++;
            }
            return;
        }
        A[row][column] = -1;
        if((row+1)<A.length){
            if(A[row+1][column]!=-1){
                recursion(row+1, column , ER , EC ,zeroCounts,count+1,A);
            }
        }
        if((column+1)<A[0].length){
            if(A[row][column+1]!=-1){
                recursion(row, column+1 , ER , EC ,zeroCounts,count+1,A);
            }
        }
        if((column-1)>-1){
            if(A[row][column-1]!=-1){
                recursion(row, column-1 , ER , EC ,zeroCounts,count+1,A);
            }
        }
        if((row-1)>-1){
            if(A[row-1][column]!=-1){
                recursion(row-1, column, ER , EC ,zeroCounts,count+1,A);
            }
        }
        A[row][column] = 0;

    }
}
