package com.general.queue;

import java.util.Scanner;

public class CircularQueue {

    private static int front = -1;
    private static int rear = -1;
    private static int[] queueArray = null;
    private static int CAPACITY = 0;
    private static int size = 0;

    public CircularQueue(int capacity) {
        CAPACITY = capacity;
        queueArray = new int[capacity];
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("select one of the options from below : ");
            System.out.println("1- add element\n2- delete element\n3- capacity of the queue\n"
                    + "4- queue empty check\n5- queue full check\n6- size of the queue\n"
                    + "7- display the elements in the queue\npress any other key to exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("enter the element to be added : " );
                    enQueue(scanner.nextInt());
                    break;
                case 2:
                    deQueue();
                    break;
                case 3:
                    System.out.println("capacity of the queue is : "+ CAPACITY);
                    break;
                case 4:
                    System.out.println(isEmpty()?"queue is empty":"queue is not empty");
                    break;
                case 5:
                    System.out.println(isFull()?"queue is full":"queue is not full");
                    break;
                case 6:
                    System.out.println("size of the queue is : " + size);
                    break;
                case 7:
                    System.out.println("queue elements are :");
                    int count=0;
                    while(count<size) {
                        System.out.println(queueArray[((front+count)%CAPACITY)]);
                        count++;
                    }
                    break;
                default:
                    flag =false;
                    break;
            }
        }

    }

    public static void enQueue(int element) {
        System.out.println("adding element " + element);
        if(front == (rear+1)%CAPACITY){
            System.out.println("queue is full. Can not add the element.");
        }else {
            if (front == -1) {
                front = rear = 0;
                size++;
            } else {
                rear = (rear + 1) % CAPACITY;
                size++;
            }
            queueArray[rear] = element;
        }
    }

    public static void deQueue() {
        if (front!=-1) {
            System.out.println("removed the element : "+queueArray[front]);
            if(front == rear){
                front = rear =-1;
                size--;
            }else{
                front = (front+1)%CAPACITY;
                size--;
            }
        } else {
            System.out.println("queue is empty.No element to remove.");
        }
    }

    public static boolean isEmpty() {
        return front==-1;
    }

    public static boolean isFull() {
        return front == (rear+1)%CAPACITY;
    }
}