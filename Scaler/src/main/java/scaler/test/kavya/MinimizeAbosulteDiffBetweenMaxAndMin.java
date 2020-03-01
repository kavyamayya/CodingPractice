package scaler.test.kavya;

/**
 * Given an array of integers A of size N.Minimize the absolute difference between maximum and minimum element of the array.
 * you can perform two types of operations atmost B times in total to change the values in the array.Multiple operations
 * can be performed on the same element.
 * 1- Increment. A[i] --> A[i]+1
 * 2 -Decrement. A[i] --> A[i]-1
 * Return the minimum difference possible.
 *
 * Problem constraints:
 * 1<=N<=100000
 * 1<=A[i]<=10^6
 * 1<=B<=10^9
 *
 * Input: Integer array A
 * B which represents maximum operations that can be performed on array A
 * Output: Integer denoting the minimum difference
 *
 * Example input: A=[2,6,3,9,8] , B=3
 * Output: 5
 *
 * Example explanation:
 * we can apply the atmost 3 operations in the following sequence
 * initial array: [2,6,3,9,8]
 * 1) decrement 9 -> [2,6,3,8,8]
 * 2)Increment 2 ->[3,6,3,8,8]
 * 3)Increment 3 ->[3,6,4,8,8]
 * max=8 , min=3
 * so abs|max-min| = 5
 * @author kavya k on 01-Mar-2020
 */
public class MinimizeAbosulteDiffBetweenMaxAndMin {
}
