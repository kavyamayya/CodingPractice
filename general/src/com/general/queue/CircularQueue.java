package com.general.queue;

public class CircularQueue {

    public static void main(String[] args){
        System.out.println(foo(3 , 5));
    }

    public static int foo(int x , int y){
        if(y == 0){
            System.out.println("last loop foo");
            return 1;
        }
        System.out.println("foo  x : " + x +" y " +y);
        return bar(x , foo(x , y-1));
    }

    public static int bar(int x , int y){
        if(y == 0) {
            System.out.println("last loop bar");
            return 0;
        }
        System.out.println("bar  x : " + x +" y : " +y);
        return (x + bar(x , y-1));
    }
}
