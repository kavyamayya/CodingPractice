/*
package scaler.test.sudhir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

*
 * @author kavya k on 02-Feb-2020


public class TaskScheduling {
    public static void main(String[] args){
        int[] A = new int[]{5,1,4,2,3};
        int[] B = new int[]{1,2,3,4,5};
        System.out.println(findClockCycle(A,B));
    }

    private static int findClockCycle(int[] A ,int[] B){
        List<Integer> arrayList = Arrays.stream(A).boxed().collect(Collectors.toList());
        int clockCycle=0;
        int front=0;
        int end = A.length-1;
        for (int value : B) {
            int curNum = arrayList.get(front);
            while (value != curNum) {
                arrayList.add(curNum);
                front++;
                end++;
                clockCycle++;
                curNum = arrayList.get(front);
            }
            front++;
            clockCycle++;
        }
        return clockCycle;
    }
}
*/
