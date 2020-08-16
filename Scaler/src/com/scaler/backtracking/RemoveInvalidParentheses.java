package com.scaler.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kavya k on 13-Aug-2020
 * Remove Invalid Parentheses
 * Problem Description
 * Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'.
 * Remove the minimum number of invalid parentheses in order to make the input string valid.
 * Return all possible results.
 * You can return the results in any order.
 * Problem Constraints
 * 1 <= length of the string <= 20
 * Input Format
 * The only argument given is string A.
 * Output Format
 * Return all possible strings after removing the minimum number of invalid parentheses.
 * Example Input
 * Input 1:
 *  A = "()())()"
 * Input 2:
 *  A = "(a)())()"
 * Example Output
 * Output 1:
 *  ["()()()", "(())()"]
 * Output 2:
 *  ["(a)()()", "(a())()"]
 * Example Explanation
 * Explanation 1:
 *  By removing 1 parentheses we can make the string valid.
 *         1. Remove the parentheses at index 4 then string becomes : "()()()"
 *         2. Remove the parentheses at index 2 then string becomes : "(())()"
 * Explanation 2:
 *  By removing 1 parentheses we can make the string valid.
 *         1. Remove the parentheses at index 5 then string becomes : "(a)()()"
 *         2. Remove the parentheses at index 2 then string becomes : "(a())()"
 */
public class RemoveInvalidParentheses {
    private Set<String> set = new HashSet<>();
    private int minRemoved = Integer.MAX_VALUE;

    public ArrayList<String> solve(String A) {
        reset();
        int n = A.length();
        int leftCount = 0;
        int rightCount = 0;
        int removalCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        solve(A, n, leftCount, rightCount, removalCount, stringBuilder, 0);
        return new ArrayList<>(set);
    }

    private void reset() {
        set.clear();
        minRemoved = Integer.MAX_VALUE;
    }

    private void solve(String A, int n, int leftCount, int rightCount, int removalCount, StringBuilder builder, int index) {
        if (index == n) {
            if (leftCount == rightCount) {
                if (removalCount <= minRemoved) {
                    String str = builder.toString();
                    if (removalCount < minRemoved) {
                        minRemoved = removalCount;
                        set.clear();
                    }
                    set.add(str);
                }


            }
            return;
        }
        char currChar = A.charAt(index);
        int len = builder.length();
        if (currChar != '(' && currChar != ')') {
            builder.append(currChar);
            solve(A, n, leftCount, rightCount, removalCount, builder, index + 1);
            builder.deleteCharAt(len);
        } else {
            //leave the current character and recurse
            solve(A, n, leftCount, rightCount, removalCount + 1, builder, index + 1);
            builder.append(currChar);
            if (currChar == '(') {
                //consider this character and recurse
                solve(A, n, leftCount + 1, rightCount, removalCount, builder, index + 1);
            } else if (rightCount < leftCount) {//this is for ')' character
                //consider this character only when rightCount < leftCount and recurse
                solve(A, n, leftCount, rightCount + 1, removalCount, builder, index + 1);
            }
            builder.deleteCharAt(len);
        }
    }
}
