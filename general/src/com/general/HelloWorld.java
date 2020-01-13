package com.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        ArrayList<Integer> a = new ArrayList<>();
        a.add(12);
        a.add(23);
        Queue<Integer> q = new LinkedList<>(a);
        System.out.println(q.remove());
        q.add(34);
        System.out.println(q.remove());


    }
}
