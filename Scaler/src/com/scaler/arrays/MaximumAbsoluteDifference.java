package com.scaler.arrays;

/**
 * You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j)
 * is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 * Example:
 * A=[1, 3, -1]
 * <p>
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 * <p>
 * So, we return 5.
 *
 * @author kavya k on 29-Feb-2020
 */
public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 1, 5};
        System.out.println(maxArray(A));
    }

    public static int maxArray(int[] A) {
        //simplify the equation. |i-j| becomes i-j as it is mod and index can always be interchanged.
        //|A[i]-A[j]| can be considered to have 2 cases A[i]>A[j] or A[i]<A[j]
        //so finding maximum values of A[i]-A[j]+i-j and A[j]-A[i]+i-j
        //max of ((A[i]+i)-(A[j]+j) and (A[j]-j)-(A[i]-i))
        //(A[i]+i) should be maximum and (A[j]+j) should be minimum
        //(A[j]-j) should be maximum and (A[i]-i) should be minimum
        int firstMax = Integer.MIN_VALUE;  //(A[i]+i)
        int firstMin = Integer.MAX_VALUE;  //(A[j]+j)
        int secondMax = Integer.MIN_VALUE; //(A[j]-j)
        int secondMin = Integer.MAX_VALUE; //(A[i]-i)
        for (int i = 0; i < A.length; i++) {
            int first = A[i] + i;
            int second = A[i] - i;
            if (first > firstMax) {
                firstMax = first;
            }
            if (first < firstMin) {
                firstMin = first;
            }
            if (second > secondMax) {
                secondMax = second;
            }
            if (second < secondMin) {
                secondMin = second;
            }
        }
        int max1 = firstMax - firstMin;
        int max2 = secondMax - secondMin;
        return Math.max(max1, max2);
    }
}
