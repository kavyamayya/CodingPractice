package com.scaler.maths;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given a string A, find the rank of the string amongst its permutations sorted lexicographically. Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. Look at the example for more details.
 * NOTE:
 * The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
 * String A can consist of both lowercase and uppercase letters. Characters with lesser ascii value are considered smaller i.e. 'a' > 'Z'.
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 1000000
 * Input Format
 * First argument is a string A.
 * Output Format
 * Return an integer denoting the rank.
 * Example Input
 * Input 1:
 * A = "aba"
 * Input 2:
 * A = "bca"
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 4
 * Example Explanation
 * Explanation 1:
 * The order permutations with letters 'a', 'a', and 'b' :
 * aab
 * aba
 * baa
 * So, the rank is 2.
 * Explanation 2:
 * The order permutations with letters 'a', 'b', and 'c' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank is 4.
 */
public class SortedPermutationRankWithRepeats {
    public int findRank(String A) {
        Map<Character, Integer> map = new HashMap<>();
        int N = A.length();
        int m = 1000003;
        BigInteger[] f = new BigInteger[N + 1];
        f[0] = BigInteger.ONE;
        f[1] = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1].multiply(BigInteger.valueOf(i));
        }
        BigInteger rank = BigInteger.ZERO;
        for (int i = N - 1; i >= 0; i--) {
            char c = A.charAt(i);
            int count = 0;
            if (map.containsKey(c)) {
                int num = map.get(c);
                num++;
                map.put(c, num);
            } else {
                map.put(c, 1);
            }
            List<Integer> list = new ArrayList<Integer>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() < c) {
                    count += entry.getValue();
                }
                if (entry.getValue() > 1) {
                    list.add(entry.getValue());
                }
            }
            BigInteger addingValue = BigInteger.valueOf(count).multiply(f[N - 1 - i]);
            for (Integer value : list) {
                addingValue = addingValue.divide(f[value]);
            }
            rank = rank.add(addingValue);
        }
        rank = rank.divideAndRemainder(BigInteger.valueOf(m))[1];
        return rank.intValue() + 1;
    }
}
