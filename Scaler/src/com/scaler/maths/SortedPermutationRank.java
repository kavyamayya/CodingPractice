package com.scaler.maths;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 1000
 * <p>
 * Input Format
 * First argument is a string A.
 * <p>
 * Output Format
 * Return an integer denoting the rank of the given string.
 * <p>
 * Example Input
 * Input 1:
 * A = "acb"
 * Input 2:
 * A = "a"
 * <p>
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 1
 * <p>
 * Example Explanation
 * Explanation 1:
 * Given A = "acd".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 * Explanation 2:
 * Given A = "a".
 * Rank is clearly 1.
 */
public class SortedPermutationRank {
    public int findRank(String A) {
        final SortedSet<Character> set = new TreeSet<>();
        int m = 1000003;
        int N = A.length();
        int[] f = new int[N + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < N; i++) {
            f[i] = f[i - 1] * i;
            f[i] %= m;
        }
        int rank = 0;
        for (int i = N - 1; i >= 0; i--) {
            char character = A.charAt(i);
            rank += set.headSet(character).size() * f[N - 1 - i];
            rank %= m;
            set.add(character);
        }
        return rank + 1;
    }
}
