import java.util.Date;

/*
 * @author kavya k on 06-Feb-2020
 */

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3, 7, 5};
        int sum=12;
        int N = 5;
        System.out.println(subArray(array ,sum,N));
    }

    private static String subArray(int[] array , int sum ,int N){
        int count = 0;
        int r=0,l=0;
        boolean flag=true;
        while(r<N){
            if(array[r]>sum){
                r++;
                count=0;
                l=r;
            }else{
                if(count==0){
                    l=r;
                }
                count=count+array[r];
                if(count ==sum){
                    break;
                }else if(count>sum){
                    r=l+1;
                    count =0;
                }else{
                    r++;
                }
            }
            if(r == N && sum!=count){
                flag = false;
            }
        }
        if(flag){
            l++;r++;
            return l +" "+r;
        }
        return "-1";
    }
}
