package com.general.queue;

import java.util.Scanner;


public class BasicQueue {

    public static int[] queueArray;
    public static int CAPACITY;
    public static int rear = -1;
    public static int front = -1;

    public BasicQueue(int capacity) {
        CAPACITY = capacity;
        queueArray = new int[CAPACITY];
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public static void main(String[] args) {
        BasicQueue queue = new BasicQueue(5);
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
			System.out.println("-------------------------------------------------------------------");
            System.out.println("Select one of the options from below:");
            System.out.println("1 - add element\n" + "2 - delete element\n" + "3 - capacity\n"
                    + "4 - queue full check\n" + "5 - queue empty check\n" + "6 - number of elements in the queue\n"
                    + "7 - print the elements in the queue\n" + "Press any other key to exit ");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("enter one of the options");
            int argument = scanner.nextInt();
            switch (argument) {
                case 1:
                    System.out.println("enter the element to be added : ");
                    addElement(scanner.nextInt());
                    break;
                case 2:
                    removeElement();
                    break;
                case 3:
                    System.out.println("capacity of the queue is : " + queue.getCAPACITY());
                    break;
                case 4:
                    System.out.println(queueFull() ? "queue is full." : "queue is not full");
                    break;
                case 5:
                    System.out.println(queueEmpty() ? "queue is empty." : "queue is not empty");
                    break;
                case 6:
                    System.out.println("Size : " + (rear==-1?(rear - front):(rear-front+1)));
                    break;
                case 7:
                    System.out.print("queue elements : ");
                    if (front != -1) {
                        for (int i = front; i <= rear; i++) {
                            System.out.print(queueArray[i] + " ");
                        }
                    }
                    System.out.println();
                    break;
                default:
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    //function to add element to queue
    public static void addElement(int num) {
        System.out.println("adding element : " + num);
        if ((rear + 1) != CAPACITY) {
            if (rear == -1 && front == -1) {
                ++front;
                queueArray[++rear] = num;
            } else {
                queueArray[++rear] = num;
            }
        } else {
            System.out.println("queue is overflowed");
        }
    }

    //function remove element from queue
    public static void removeElement() {
        System.out.println("front : " + front);
        if (front != -1 && front <= rear) {
            System.out.println("removed element : " + queueArray[front]);
            front++;
        } else {
            System.out.println("queue is empty. No element to delete.");
        }
    }

    // function to check the queue contents
    public static int[] queueElements() {
        return queueArray;
    }

    // function to check queue empty condition
    public static boolean queueEmpty() {
        System.out.println("rear : " + rear);
        System.out.println("front : " + front);
        return (front > rear || (rear == -1 && front == -1));
    }

    // function to check queue full condition
    public static boolean queueFull() {
        System.out.println("rear : " + rear);
        System.out.println("front : " + front);
        return ((rear + 1) == CAPACITY && front == 0);
    }
}
