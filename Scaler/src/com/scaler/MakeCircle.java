package com.scaler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kavya k on 15-Aug-2020
 */
public class MakeCircle {
    int count = 0;

    public int solve(String[] A) {
        Map<Character, List<Pair>> adjMap = new HashMap<>();
        int[] visited = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int m = A[i].length();
            adjMap.computeIfAbsent(A[i].charAt(0), s -> new ArrayList<Pair>()).add(new Pair(A[i].charAt(0), A[i].charAt(m - 1), i));
        }
        count = A.length;
        Character cur = A[0].charAt(0);
        recursion(cur, adjMap, visited, 0);
        for (int i = 0; i < A.length; i++) {
            if (visited[i] == 0) {
                return 0;
            }
        }
        if (cur == A[0].charAt(0)) {
            return 1;
        }
        return 0;
    }

    private boolean recursion(Character cur, Map<Character, List<Pair>> adjMap, int[] visited, int index) {
        System.out.println("cur " + cur + " map " + adjMap + " index " + index);
        if (adjMap.size() == 0 || !adjMap.containsKey(cur)) {
            if (count == index) {
                return true;
            }
            return false;
        }
        int size = adjMap.get(cur).size();
        System.out.println("size " + size);
        for (int i = 0; i < size; i++) {
            Pair temp = adjMap.get(cur).get(i);
            visited[temp.index] = 1;
            List<Pair> list = adjMap.get(cur);
            list.remove(temp);
            adjMap.put(cur, list);
            if (adjMap.get(cur).size() == 0) {
                adjMap.remove(cur);
            }
            if (!recursion(temp.second, adjMap, visited, index + 1)) {
                visited[temp.index] = 0;
                list.add(temp);
                adjMap.put(cur, list);
            } else {
                break;
            }
        }
        return true;
    }

    static class Pair {
        private Character first;
        private Character second;
        private int index;

        public Pair(Character first, Character second, int index) {
            this.first = first;
            this.second = second;
            this.index = index;
        }

        public String toString() {
            return "[" + first + ", " + second + ", " + index + "]";
        }
    }

    public static void main(String[] args) {
        MakeCircle circle = new MakeCircle();
        String[] s1 = {"ab", "bc", "ca", "bb"};
        System.out.println(circle.solve(s1));
    }
}
