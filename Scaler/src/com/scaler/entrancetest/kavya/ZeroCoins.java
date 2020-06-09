package com.scaler.entrancetest.kavya;

/**
 * There are  bags numbered 1 to N.Each bag consisting of coins denoted by integer array A of size N.
 * You have to perform M operations given by an integer array B of size M.
 * For each operation 1<=i<=M
 * You are given integer B[i].Decrement 1 coin from all the bags numbered same as all the divisors of B[i].
 * After each operation count the total number of bags having 0 coins.
 * Note:If the number of coin is already 0 in the bag then you will not decrement the coin from the bag.
 *
 * Problem constraints:
 * 1<=N,M<=1000
 * 1<=A[i]<=10000
 * 1<=B[i]<=N
 *
 * Input: first argument is integer array A denoting number of coins in N bags.
 * second argument is integer array B denoting M operations.
 *
 * Output:Integer array of size M denoting the number of bags having 0 coins after each operations.
 *
 * Example input:A= [3,1,4,2], B=[2,4,3]
 * output:[1,1,2]
 *
 * Explanation:
 * At first operation divisors of 2 are (1,2).So the array A becomes [2,0,4,2] and number of bags having 0 coins is 1.
 * At second operation divisors of 4 are (1,2,4).So the array A becomes [1,0,4,1] and number of bags having 0 coins is 1.
 * At third operation divisors of 3 are (1,3).So the array A becomes [0,0,3,1] and number of bags having 0 coins is 2.
 *
 * @author kavya k on 01-Mar-2020
 */
public class ZeroCoins {
}
