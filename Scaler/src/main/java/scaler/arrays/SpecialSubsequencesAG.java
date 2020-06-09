package scaler.arrays;

/**
 * You have given a string A having Uppercase English letters. You have to find that how many times subsequence "AG" is
 * there in the given string. NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 *
 * Problem Constraints
 * 1 <= length(A) <= 105
 *
 * Input Format
 * First and only argument is a string A.
 *
 * Output Format
 * Return an integer denoting the answer.
 *
 * Example Input
 * Input 1:
 * A = "ABCGAG"
 *
 * Example Output
 * Output 1:
 * 3
 *
 * Example Explanation
 * Explanation 1:
 * subsequence "AG" is 3 times in given string
 *
 * @author kavya k on 18-May-2020
 */
public class SpecialSubsequencesAG {

    public int solve(String A) {
        char[] charArray = A.toCharArray();
        int count=0;
        int[] countArray = new int[charArray.length];
        for(int i=charArray.length-1;i>=0;i--){
            countArray[i] = count;
            if(A.charAt(i)=='G'){
                count++;
            }
        }
        int sum =0;
        for(int i=0;i<charArray.length;i++){
            if(A.charAt(i) =='A'){
                sum+=countArray[i];
            }
        }
        return sum;
    }
}
