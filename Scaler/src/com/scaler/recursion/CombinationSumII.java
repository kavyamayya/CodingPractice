package com.scaler.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kavya k on 08-Aug-2020
 * Combination Sum II
 * Problem Description
 * Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
 * Each number in A may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Warning:
 * DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 * Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.
 * Problem Constraints
 * 1 <= N <= 20
 * Input Format
 * First argument is an integer array A denoting the collection of candidate numbers.
 * Second argument is an integer which represents the target number.
 * Output Format
 * Return all unique combinations in A where the candidate numbers sums to B.
 * Example Input
 * Input 1:
 *  A = [10, 1, 2, 7, 6, 1, 5]
 *  B = 8
 * Input 2:
 *  A = [2, 1, 3]
 *  B = 3
 * Example Output
 * Output 1:
 *  [
 *   [1, 1, 6 ],
 *   [1, 2, 5 ],
 *   [1, 7 ],
 *   [2, 6 ]
 *  ]
 * Output 2:
 *  [
 *   [1, 2 ],
 *   [3 ]
 *  ]
 * Example Explanation
 * Explanation 1:
 *  1 + 1 + 6 = 8
 *  1 + 2 + 5 = 8
 *  1 + 7 = 8
 *  2 + 6 = 8
 *  All the above combinations sum to 8 and are arranged in ascending order.
 * Explanation 2:
 *  1 + 2 = 3
 *  3 = 3
 *  All the above combinations sum to 3 and are arranged in ascending order.
 */
public class CombinationSumII {
    // Set<Integer> set = new Set<Integer>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        combinationSumRecursion(a , b , result ,0 , 0 ,tempList);
        return result;
    }
    // when we keep adding elements to the combination in a recursive manner,
// it's correct to add next element with the same value as previous
// because it can result in a valid combination (This is taken care as (i != start) will be false and element will be added successfully).
// But once we complete recursion, we remove the last added element from the combination and then try with the next element.
// (Here (i != start) will be true and duplicate check will be done).
// Here if the next element has the same value, then the subsequent recursive calls results in the same combination
// which is a duplicate combination.
// Hence we filter out those cases.
    public void combinationSumRecursion(ArrayList<Integer> a, int b , ArrayList<ArrayList<Integer>> result , int index , int sum , ArrayList<Integer> list){
        if(sum == b){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(sum>b){
            return;
        }
        for(int i=index;i<a.size();i++){
            if(i!=index && a.get(i) == a.get(i-1)){
                continue;
            }
            sum+=a.get(i);
            list.add(a.get(i));
            combinationSumRecursion(a,b,result,i+1 , sum, list);
            sum-=a.get(i);
            list.remove(list.size()-1);
        }
    }
}
