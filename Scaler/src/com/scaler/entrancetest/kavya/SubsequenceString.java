package com.scaler.entrancetest.kavya;

/**
 * You are given a string A and integer array B,each of size N.Each element in  array denote the cost of corresponding
 * character of A.
 * You have to choose a sub sequence of string A equal to string C such that the cost is minimized.The cost of subsequence
 * would be sum of characters of individual characters chosen from A.
 * You have to find that minimum cost.If you can not have a subsequence equal to C return -1.
 * <p>
 * Problem constraints:
 * 1<=N,|C| <=1500
 * 1<=B[i]<=1000000
 * All string consist of lower case alphabets
 * <p>
 * Input format:
 * 1)First argument of input contains string A
 * 2) second argument of input contains integer array B
 * 3) string C
 * Output:Integer denoting minimum cost
 * Example input: A="abbaba" , B=[3,5,2,4,1,1] ,c="ab"
 * Output=4
 * Example 2: A="abc" B=[1,2,3] c="bca"
 * output=-1;
 * Explanation 1: choose subsequence created from characters at index 0 and 4 in string A.The cost for that would be 3+1=4
 * which is minimum among all possible costs
 * Explanation 2: The subsequence string C can not be created from string A.so the cost would be -1.
 *
 * @author kavya k on 01-Mar-2020
 */
public class SubsequenceString {
}
