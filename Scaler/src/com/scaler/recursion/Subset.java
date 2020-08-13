package com.scaler.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author kavya k on 08-Aug-2020
 * Subset
 * Problem Description
 * Given a set of distinct integers, A, return all possible subsets.
 * NOTE:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 * Input Format
 * First and only argument of input contains a single integer array A.
 * Output Format
 * Return a vector of vectors denoting the answer.
 * Example Input
 * Input 1:
 * A = [1]
 * Input 2:
 * A = [1, 2, 3]
 * Example Output
 * Output 1:
 * [
 *     []
 *     [1]
 * ]
 * Output 2:
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 * Example Explanation
 * Explanation 1:
 *  You can see that these are all possible subsets.
 * Explanation 2:
 * You can see that these are all possible subsets.
 */
public class Subset {

    public static void main(String[] args){
        Subset subset = new Subset();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        subset.subsets(list);

    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        findSubset(A , result , 0,new ArrayList<Integer>());
        return result;
    }

    public static void findSubset(ArrayList<Integer> A , ArrayList<ArrayList<Integer>> result ,
                                  int currentIndex, ArrayList<Integer> tempArray){
        result.add(new ArrayList<Integer>(tempArray));
        for(int i=currentIndex;i<A.size();i++){
            tempArray.add(A.get(i));
            findSubset(A , result , i+1,tempArray);
            tempArray.remove(A.get(i));
        }
    }
}
