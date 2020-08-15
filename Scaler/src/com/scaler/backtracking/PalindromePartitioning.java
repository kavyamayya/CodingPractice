package com.scaler.backtracking;

import java.util.ArrayList;

/**
 * @author kavya k on 13-Aug-2020
 * Palindrome Partitioning
 * Problem Description
 * Given a string A, partition A such that every string of the partition is a palindrome.
 * Return all possible palindrome partitioning of A.
 * Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
 * (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
 * Problem Constraints
 * 1 <= len(A) <= 15
 * Input Format
 * First argument is a string A of lowercase characters.
 * Output Format
 * Return a list of all possible palindrome partitioning of s.
 * Example Input
 * Input 1:
 * A = "aab"
 * Input 2:
 * A = "a"
 * Example Output
 * Output 1:
 *  [
 *     ["a","a","b"]
 *     ["aa","b"],
 *   ]
 * Output 2:
 *  [
 *     ["a"]
 *   ]
 * Example Explanation
 * Explanation 1:
 * In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
 * Explanation 2:
 * In the given example, only partition possible is "a" .
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> partitions = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        int n = a.length();
        partition(a, n, partitions, temp, 0);
        return partitions;
    }

    private void partition(String a, int len, ArrayList<ArrayList<String>> partitions, ArrayList<String> temp, int index) {
        if (index == len) {
            partitions.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < len; i++) {
            String str = a.substring(index, i + 1);
            if (isPalindrome(str)) {
                temp.add(str);
                partition(a, len, partitions, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
