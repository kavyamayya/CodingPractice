package com.scaler.graphs;

import java.util.*;

/**
 * @author kavya k on 15-Aug-2020
 */
public class MakeCircle {
    int count = 0;
    int index = 0;
    boolean flag = false;
    Character finaal=null;
    Set<Character> visSet = new HashSet<>();
    public int solve(String[] A) {
        Map<Character, List<Pair>> adjMap = new HashMap<>();
        int[] visited = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int m = A[i].length();
            adjMap.computeIfAbsent(A[i].charAt(0), s -> new ArrayList<Pair>()).add(new Pair(A[i].charAt(0), A[i].charAt(m - 1), i));
        }
        count = A.length;
        Map<Character, List<Pair>> adjMapNew = new HashMap<>();
        adjMapNew = (Map<Character, List<Pair>>) ((HashMap<Character, List<Pair>>) adjMap).clone();
        for(Map.Entry<Character , List<Pair>> entry: adjMap.entrySet()){
            List<Pair> pairs = entry.getValue();
            int n=pairs.size();
            for(int i=0;i<n;i++){
                Pair temp = pairs.get(i);
                visSet.add(temp.first);
                visited[temp.index] = 1;
                List<Pair> list = new ArrayList<>();
                list.addAll(adjMapNew.get(pairs.get(i).first));
                list.remove(temp);
                adjMapNew.put(temp.first, list);
                if (adjMapNew.get(temp.first).size() == 0) {
                    adjMapNew.remove(temp.first);
                }
                int res = check(temp.second , adjMapNew,visited);
                if( res == count && temp.first == finaal){
                    return 1;
                }else if(res != count && temp.first == finaal){
                    for(int m=0;m<visited.length;m++) {
                        if (visited[m] == 0){
                            if (!(A[m].charAt(0) == A[m].charAt(A[m].length() - 1) && visSet.contains(A[m].charAt(0)))) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(flag){
                        return 0;
                    }
                }else{
                    return 0;
                }

                Arrays.fill(visited,0);
                visSet.clear();
                adjMapNew = (Map<Character, List<Pair>>) ((HashMap<Character, List<Pair>>) adjMap).clone();
            }
        }
        return 1;
    }

    private int check(Character cur, Map<Character, List<Pair>> adjMap, int[] visited){
        int cou = 1;
        while(adjMap.size()!=0){
            if(!adjMap.containsKey(cur)){
                break;
            }
            cou++;
            Pair temp = adjMap.get(cur).get(0);
            visSet.add(temp.first);
            visited[temp.index] = 1;
            List<Pair> list = new ArrayList<>();
            list.addAll(adjMap.get(cur));
            list.remove(temp);
            adjMap.put(cur, list);
            if (adjMap.get(cur).size() == 0) {
                adjMap.remove(cur);
            }
            cur = temp.second;
        }
        finaal =cur;
        return cou;
    }

    private void recursion(Character cur, Map<Character, List<Pair>> adjMap, int[] visited) {
        //System.out.println("cur " + cur + " map " + adjMap + " index " + index);
        if (adjMap.size() == 0 || !adjMap.containsKey(cur)) {
            return;
        }
        int size = adjMap.get(cur).size();
        //System.out.println("size " + size);
        for (int i = 0; i < size; i++) {
            index++;
            Pair temp = adjMap.get(cur).get(0);
            visited[temp.index] = 1;
            List<Pair> list = adjMap.get(cur);
            list.remove(temp);
            adjMap.put(cur, list);
            if (adjMap.get(cur).size() == 0) {
                adjMap.remove(cur);
            }
            recursion(temp.second, adjMap, visited);
            if (index != count){
                index -=1;
                visited[temp.index] = 0;
                list.add(temp);
                adjMap.put(cur, list);
            } else {
                break;
            }
        }
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
        String[] s2 = {"ihgg", "gigfi", "hggii", "gh", "ihhfhfh" };
        String[] s3 = {"ab", "bc", "ca", "bb", "ac", "za","cb","bz","cc","bb","zz"};
        String[] s4={"aab", "bac", "zaz", "cda" };
        System.out.println(circle.solve(s1));
        System.out.println(circle.solve(s2));
        System.out.println(circle.solve(s3));
        System.out.println(circle.solve(s4));
    }
}
