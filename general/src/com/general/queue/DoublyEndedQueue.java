package com.general.queue;

import java.util.Scanner;

public class DoublyEndedQueue {
    public static int front = -1;
    public static int rear = -1;
    public static int CAPACITY;
    public static int[] queueArray;

    public DoublyEndedQueue(int capacity) {
        CAPACITY = capacity;
        queueArray = new int[CAPACITY];
    }

    public static void main(String[] args) {
        {
            DoublyEndedQueue queue = new DoublyEndedQueue(5);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select one of the options from below:");
            System.out.println("1 - add element to the front\n" + "2 - add element to the rear\n" +
                    "3 - delete element from the front\n" + "4 - delete element from the rear\n" +
                    "5 - capacity\n" + "6 - queue full check\n" + "7 - queue empty check\n" +
                    "8 - number of elements in the queue\n" + "9 - print the elements in the queue\n" +
                    "Press any other key to exit ");
            boolean run = true;
            while (run) {
                System.out.println("enter one of the options");
                int argument = scanner.nextInt();
                switch (argument) {
                    case 1:
                        System.out.println("enter the element to be added to the front: ");
                        addElementFront(scanner.nextInt());
                        break;
                    case 2:
                        System.out.println("enter the element to be added to the rear: ");
                        addElementRear(scanner.nextInt());
                        break;
                    case 3:
                        removeElementFront();
                        break;
                    case 4:
                        removeElementRear();
                        break;
                    case 5:
                        System.out.println("capacity of the queue is : " + CAPACITY);
                        //
                        break;
                    case 6:
                        System.out.println(queueFull() ? "queue is full." : "queue is not full");
                        break;
                    case 7:
                        System.out.println(queueEmpty() ? "queue is empty." : "queue is not empty");
                        // System.out.println("Size : " + numberOfElements);
                        break;
                    case 8:
                        System.out.println("Size : " + (front + 1));
                        break;
                    case 9:
                        System.out.println("queue elements : ");
                        for (int i = 0; i <= front; i++) {
                            System.out.print(queueArray[i] + " ");
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
    }

    //function to add element to the front of queue
    public static void addElementFront(int element) {
        if ((front + 1) != CAPACITY) {
            for (int i = front; i >= 0; i--) {
                queueArray[i + 1] = queueArray[i];
            }
            queueArray[0] = element;
            ++front;
        } else {
            System.out.println("queue is full. Can not add the element.");
        }
    }

    //function to add element to the rear of queue
    public static void addElementRear(int element) {
        if ((front + 1) != CAPACITY) {
            queueArray[++front] = element;
        } else {
            System.out.println("queue is full. Can not add the element.");
        }
    }

    public static void removeElementFront() {
        if (front != -1) {
            System.out.println("deleting element from the front : " + queueArray[0]);
            for (int i = 0; i < front; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            front--;
        } else {
            System.out.println("queue is empty.No element to remove.");
        }
    }

    public static void removeElementRear() {
        if (front != -1) {
            System.out.println("deleting element from the rear : " + queueArray[front--]);
        } else {
            System.out.println("queue is empty.No element to remove.");
        }
    }

    public static boolean queueFull() {
        return ((front + 1) == CAPACITY);
    }

    public static boolean queueEmpty() {
        return (front == -1);
    }

    public int getCAPACITY() {
        return CAPACITY;
    }
}