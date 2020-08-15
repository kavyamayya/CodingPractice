package com.scaler.backtracking;

import java.util.ArrayList;

/**
 * @author kavya k on 13-Aug-2020
 * Letter Phone
 * Problem Description
 * Given a digit string A, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 * NOTE: Make sure the returned strings are lexicographically sorted.
 * Problem Constraints
 * 1 <= |A| <= 10
 * Input Format
 * The only argument is a digit string A.
 * Output Format
 * Return a string array denoting the possible letter combinations.
 * Example Input
 * Input 1:
 *  A = "23"
 * Input 2:
 *  A = "012"
 * Example Output
 * Output 1:
 *  ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Output 2:
 *  ["01a", "01b", "01c"]
 * Example Explanation
 * Explanation 1:
 *  There are 9 possible letter combinations.
 * Explanation 2:
 *  Only 3 possible letter combinations.
 */
public class LetterPhone {
    int resultIndex=0;
    public String[] letterCombinations(String A) {
        int count = 1;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<A.length();i++){
            switch(A.charAt(i)){
                case '0':
                    list.add("0");
                    count*=1;
                    break;
                case '1':
                    list.add("1");
                    count*=1;
                    break;
                case '2':
                    list.add("abc");
                    count*=3;
                    break;
                case '3':
                    list.add("def");
                    count*=3;
                    break;
                case '4':
                    list.add("ghi");
                    count*=3;
                    break;
                case '5':
                    list.add("jkl");
                    count*=3;
                    break;
                case '6':
                    list.add("mno");
                    count*=3;
                    break;
                case '7':
                    list.add("pqrs");
                    count*=4;
                    break;
                case '8':
                    list.add("tuv");
                    count*=3;
                    break;
                case '9':
                    list.add("wxyz");
                    count*=4;
                    break;
            }
        }
        String[] result = new String[count];
        StringBuilder sb = new StringBuilder();
        findComb(result,0,list,sb);
        return result;
    }
    public void findComb(String[] result , int index , ArrayList<String> list , StringBuilder sb){
        if(index==list.size()){
            result[resultIndex] = new String(sb+"");
            return;
        }
        for(int i=0;i<list.get(index).length();i++){
            sb.append(list.get(index).charAt(i));
            findComb(result,index+1,list,sb);
            resultIndex++;
            sb.setLength(sb.length()-1);
        }
        resultIndex--;
    }
}
