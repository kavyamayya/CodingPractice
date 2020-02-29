package com.interviewbit;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author kavya k on 02-Feb-2020
 */
public class ProgrammingTeams {

    public static void main(String[] args){
        int[] array = new int[]{1,2,4,2,1};
        System.out.println(minNumTeams(array));
    }

    private static int minNumTeams(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        IntStream.range(0, array.length).forEach(i -> {
            if (map.containsKey(array[i])) {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            } else {
                map.put(array[i], 1);
            }
        });
        int max = 0;
        for(Integer i : map.values()){
            if(max<i){
                max = i;
            }
        }
        return max;
    }
}
