package com.scaler.maths;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Groot has an array A of size N. Boring right? Groot thought so too, so he decided to construct another array B of the same size and defined elements of B as:
 * B[i] = factorial of A[i] for every i such that 1<= i <= N.
 * factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
 * Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non empty set of prime factors.
 * Since the number can be very large, return it modulo 109 + 7.
 * NOTE: A set is a data structure having only distinct elements. Eg : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}
 * <p>
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^6
 * Your code will run against a maximum of 5 test cases.
 * <p>
 * Input Format
 * Only argument is an integer array A of size N.
 * <p>
 * Output Format
 * Return an integer deonting the total number of non-empty subsequences of array B such that every element in the subsequence has the same set of prime factors modulo 10^9+7.
 * <p>
 * Example Input
 * Input 1:
 * A = [2, 3, 2, 3]
 * Input 2:
 * A = [2, 3, 4]
 * <p>
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * 4
 * <p>
 * Example Explanation
 * Explanation 1:
 * Array B will be : [2, 6, 2, 6]
 * The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
 * Input 2:
 * Array B will be : [2, 6, 24]
 * The total possible subsequences are 4 : [2], [6], [24], [6, 24].
 */
public class FactorialArray {
    public int solve(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }
        int[] list = new int[max + 1];
        Arrays.fill(list, 0);
        int count1 = 0;
        for (int i = 2; i <= max; i++) {
            if (list[i] == 0) {
                count1++;
                list[i] = list[i - 1] + 1;
                for (int j = 2 * i; j <= max; j += i) {
                    list[j] = 1;
                }
            }
            list[i] = count1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(list[A[i]])) {
                map.put(list[A[i]], map.get(list[A[i]]) + 1);
            } else {
                map.put(list[A[i]], 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() != 0) {
                count += Math.pow(2, entry.getValue()) - 1;
            }
        }
        return count;
    }
}
