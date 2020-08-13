package com.scaler.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kavya k on 08-Aug-2020
 *
 * All Unique Permutations
 * Problem Description
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
 * NOTE: No 2 entries in the permutation sequence should be the same.
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 * Problem Constraints
 * 1 <= |A| <= 9
 * Input Format
 * Only argument is an integer array A of size N.
 * Output Format
 * Return a 2-D array denoting all possible unique permutation of the array.
 * Example Input
 * Input 1:
 * A = [1, 1, 2]
 * Input 2:
 * A = [1, 2]
 * Example Output
 * Output 1:
 * [ [1,1,2]
 *   [1,2,1]
 *   [2,1,1] ]
 * Output 2:
 * [ [1, 2]
 *   [2, 1] ]
 * Example Explanation
 * Explanation 1:
 *  All the possible unique permutation of array [1, 1, 2].
 * Explanation 2:
 *  All the possible unique permutation of array [1, 2].
 */
public class AllUniquePermutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        uniquePermutaion(A , result , 0);
        return result;
    }
    public void uniquePermutaion(ArrayList<Integer> A ,ArrayList<ArrayList<Integer>> result , int index){
        if(index == A.size()){
            result.add(new ArrayList<Integer>(A));
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=index;i<A.size();i++){
            if(!set.contains(A.get(i))){
                int temp = A.get(i);
                A.set(i,A.get(index));
                A.set(index, temp);
                uniquePermutaion(A ,result,index+1);
                temp = A.get(i);
                A.set(i,A.get(index));
                A.set(index, temp);
                set.add(A.get(i));
            }
        }
    }
}
