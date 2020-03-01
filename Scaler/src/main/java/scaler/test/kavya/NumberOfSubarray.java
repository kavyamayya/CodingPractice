package scaler.test.kavya;

/**
 * Given a sorted integer array A of size N and integer B.
 * Find the number of sub array of array A such that if [L,R] defines the range of sub array then A[L]+min(A[L],A[L+1],
 * A[L+2]+A[L+3] +....+A[R])+A[R] is greater than or equal to B.
 * Note:
 * 1) L should be less than or equal to R
 * 2)min(A[L]+min(A[L],A[L+1],A[L+2]+A[L+3] +....+A[R])+A[R]) should be min in the range [L,R]
 * 3) output will not be greater than 32 bit integer.
 *
 * Problem constraints:
 * 1<=N<=100000
 * 1<=A[i] , B<=10^8
 *
 * Input: first argument is integer array A, second is integer B
 * Output: number of sub array that satisfies above conditions
 *
 * Example input:
 * A=[2,3,5,8,10]
 * B = 12
 *
 * Example output:10
 * Example explanation:
 * consider 0 based indexing subarray that satisfies the condition are in the range [L,R]
 * [0,3],[0,4],[1,3],[1,4],[2,2],[2,3],[2,4],[3,3],[3,4],[4,4]
 * For these all sub array A[L]+min(A[L],A[L+1],A[L+2]+A[L+3] +....+A[R])+A[R] is greater than or equal to B.
 * @author kavya k on 01-Mar-2020
 */
public class NumberOfSubarray {
}
