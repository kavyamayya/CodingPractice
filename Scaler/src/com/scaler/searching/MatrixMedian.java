package com.scaler.searching;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Matrix Median
 * Problem Description
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * Find and return the overall median of the matrix A.
 * NOTE: No extra memory is allowed.
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 * Problem Constraints
 * 1 <= N, M <= 10^5
 * 1 <= N*M <= 10^6
 * 1 <= A[i] <= 10^9
 * N*M is odd
 *
 * Input Format
 * The first and only argument given is the integer matrix A.
 * Output Format
 * Return the overall median of the matrix A.
 * Example Input
 * Input 1:
 * A = [   [1, 3, 5],
 *         [2, 6, 9],
 *         [3, 6, 9]   ]
 * Input 2:
 * A = [   [5, 17, 100]    ]
 * Example Output
 * Output 1:
 *  5
 * Output 2:
 *  17
 * Example Explanation
 * Explanation 1:
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 * Median is 17.
 */
public class MatrixMedian {
    public int findMedian(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int i=0;i<M;i++){
            l=Math.min(l ,A[i][0]);
            r=Math.max(r,A[i][N-1]);
        }
        int answer=-1;
        int req = M*N/2;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(countMatching(A,mid) <= req){
                answer = mid;
                l=mid+1;
            }else if(countMatching(A,mid) > (M*N/2)){
                r=mid-1;
            }
        }
        return answer;
    }
    public int countMatching(int[][] A , int mid){
        int M = A.length;
        int N = A[0].length;
        int count =0;
        for(int i=0;i<M*N;i++){
            int r = i/N;
            int c = i%N;
            if(A[r][c]<mid){
                count++;
            }
        }
        return count;
    }

   /* public int findMedian(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i=0;i<M;i++){
            l=Math.min(l ,A[i][0]);
            r=Math.max(r,A[i][N-1]);
        }
        int answer=-1;
        int req = M*N/2;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(findCount(A,mid) <= req){
                answer = mid;
                l=mid+1;
            }else if(findCount(A,mid) > (M*N/2)){
                r=mid-1;
            }
        }
        return answer;
    }

    public int findCount(int[][] A , int mid){
        int M = A.length;
        int N = A[0].length;
        int count =0;
        for(int i=0;i<M;i++){
            int l=0;
            int r=N-1;
            int answer =N;
            while(l<=r){
                int mid1=l+(r-l)/2;
                if(A[i][mid1]<mid){
                    l=mid1+1;
                }else{
                    answer = mid1;
                    r=mid1-1;
                }
            }
            count +=answer;
        }
        return count;
    }*/
}
