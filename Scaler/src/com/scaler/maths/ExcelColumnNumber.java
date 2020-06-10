package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * <p>
 * Problem Constraints
 * 1 <= length of the column title <= 5
 * <p>
 * Input Format
 * Input a string which represents the column title in excel sheet.
 * <p>
 * Output Format
 * Return a single integer which represents the corresponding column number.
 * <p>
 * Example Input
 * Input 1:
 * AB
 * Input 2:
 * ABCD
 * <p>
 * Example Output
 * Output 1:
 * 28
 * Output 2:
 * 19010
 * <p>
 * Example Explanation
 * Explanation 1:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int sum = 0;
        int count = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int charToInt = (int) A.charAt(i) - 64;
            sum += charToInt * Math.pow(26, count);
            count++;
        }
        return sum;
    }
}
