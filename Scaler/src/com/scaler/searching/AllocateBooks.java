package com.scaler.searching;

import java.util.ArrayList;

/**
 * @author kavya k on 08-Aug-2020
 *
 * Problem Description
 * Given an array of integers A of size N and an integer B.
 * College library has N books,the ith book has A[i] number of pages.
 * You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 *
 * NOTE: Return -1 if a valid assignment is not possible.
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i], B <= 105
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 * Return that minimum possible number
 * Example Input
 * A = [12, 34, 67, 90]
 * B = 2
 * Example Output
 * 113
 * Example Explanation
 * There are 2 number of students. Books can be distributed in following fashion :
 *         1) [12] and [34, 67, 90]
 *         Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 *         2) [12, 34] and [67, 90]
 *         Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 *         3) [12, 34, 67] and [90]
 *         Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 *         Of the 3 cases, Option 3 has the minimum pages = 113.
 */
public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size()<B){
            return -1;
        }
        int total=0;
        for(int i=0;i<A.size();i++){
            total+=A.get(i);
        }
        int l=0;
        int r=total;
        int answer=total;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(B,A,mid)){
                r=mid-1;
                answer=mid;
            }else{
                l=mid+1;
            }
        }
        return answer;
    }

    public boolean isPossible(int A, ArrayList<Integer> B, long mid){
        long sum=0;
        int count=1;
        for(int i=0;i<B.size();i++){
            if(B.get(i)>mid){
                return false;
            }
            if((sum+B.get(i))<=mid){
                sum+=B.get(i);
            }else{
                sum=B.get(i);
                count++;
            }
        }
        if(count>A){
            return false;
        }
        return true;
    }
}
