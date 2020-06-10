package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * <p>
 * Problem Constraints
 * 1 <= A <= 109
 * <p>
 * Input Format
 * First and only argument of input contains single integer A
 * <p>
 * Output Format
 * Return a string denoting the corresponding title.
 * <p>
 * Example Input
 * Input 1:
 * A = 3
 * Input 2:
 * A = 27
 * <p>
 * Example Output
 * Output 1:
 * "C"
 * Output 2:
 * "AA"
 * <p>
 * Example Explanation
 * Explanation 1:
 * 3 corrseponds to C.
 * Explanation 2:
 * 1 -> A,
 * 2 -> B,
 * 3 -> C,
 * ...
 * 26 -> Z,
 * 27 -> AA,
 * 28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        int reminder = A % 26;
        int quotient = A / 26;
        if (reminder == 0) {
            reminder = 26;
            quotient -= 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) (reminder + 64));
        while (quotient / 26 != 0) {
            int rem = quotient % 26;
            quotient = quotient / 26;
            if (rem == 0) {
                rem = 26;
                quotient -= 1;
            }
            sb.insert(0, (char) (rem + 64));
        }
        if (quotient != 0) {
            sb.insert(0, (char) (quotient + 64));
        }
        return sb.toString();
    }
}
