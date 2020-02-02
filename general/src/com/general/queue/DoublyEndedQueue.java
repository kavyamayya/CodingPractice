package com.general.queue;

import java.util.Scanner;

public class DoublyEndedQueue {
    public static int front = -1;
    public static int rear = -1;
    public static int CAPACITY;
    public static int[] queueArray;
    private static int size = 0;

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
                        queue.addElementFront(scanner.nextInt());
                        break;
                    case 2:
                        System.out.println("enter the element to be added to the rear: ");
                        queue.addElementRear(scanner.nextInt());
                        break;
                    case 3:
                        queue.removeElementFront();
                        break;
                    case 4:
                        queue.removeElementRear();
                        break;
                    case 5:
                        System.out.println("capacity of the queue is : " + CAPACITY);
                        break;
                    case 6:
                        System.out.println(queue.queueFull() ? "queue is full." : "queue is not full");
                        break;
                    case 7:
                        System.out.println(queue.queueEmpty() ? "queue is empty." : "queue is not empty");
                        break;
                    case 8:
                        System.out.println("Size : " + size);
                        break;
                    case 9:
                        queue.display();
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
    public void addElementFront(int element) {
        System.out.println("adding element " + element);
        if(front == (rear+1)%CAPACITY){
            System.out.println("queue is full. Can not add the element.");
        }else {
            if (front == -1) {
                front = rear = 0;
                size++;
            } else {
                if (front == 0) {
                    front = CAPACITY - 1;
                } else {
                    front--;
                }
                size++;
            }
            queueArray[front] = element;
        }
    }

    //function to add element to the rear of queue
    public void addElementRear(int element) {
        System.out.println("adding element " + element);
        if(front == (rear+1)%CAPACITY){
            System.out.println("queue is full. Can not add the element.");
        }else {
            if (rear == -1) {
                front = rear = 0;
                size++;
            } else {
                rear = (rear + 1) % CAPACITY;
                size++;
            }
            queueArray[rear] = element;
        }
    }

    public void removeElementFront() {
        if (front != -1) {
            System.out.println("deleting element from the front : " + queueArray[front]);
            if(front == rear){
                front = rear =-1;
                size--;
            }else{
                front=(front+1)%CAPACITY;
                size--;
            }
        } else {
            System.out.println("queue is empty.No element to remove.");
        }
    }

    public void removeElementRear() {
        if (front != -1) {
            System.out.println("deleting element from the rear : " + queueArray[rear]);
            if(front == rear){
                front = rear =-1;
                size--;
            }else{
                rear=rear-1;
                size--;
            }
        } else {
            System.out.println("queue is empty.No element to remove.");
        }
    }

    public boolean queueFull() {
        return (front == (rear+1)%CAPACITY);
    }

    public boolean queueEmpty() {
        return (front == -1);
    }

    public void display(){
        int count=0;
        while(count<size) {
            System.out.println(queueArray[((front+count)%CAPACITY)]);
            count++;
        }
    }
}