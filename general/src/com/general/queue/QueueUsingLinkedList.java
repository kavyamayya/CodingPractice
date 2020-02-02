package com.general.queue;

import com.general.linkedlist.SinglePointerNode;

import java.util.Scanner;

/**
 * @author kavya k on 01-Feb-2020
 */
public class QueueUsingLinkedList {
    private SinglePointerNode head = null;
    public static void main(String[] args) {
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Select one of the options from below:");
            System.out.println("1 - add element\n" + "2 - delete element\n" + "3 - front\n"
                    + "4 - rear\n" + "5 - queue empty check\n" + "6 - number of elements in the queue\n"
                    + "7 - print the elements in the queue\n" + "Press any other key to exit ");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("enter one of the options");
            int argument = scanner.nextInt();
            int value ;
            switch (argument) {
                case 1:
                    System.out.println("enter the element to be added : ");
                    queueUsingLinkedList.enQueue(scanner.nextInt());
                    break;
                case 2:
                    value = queueUsingLinkedList.deQueue();
                    System.out.println(value == -1?"No element to delete.": String.format("Deleted element :%d", value));
                    break;
                case 3:
                    value = queueUsingLinkedList.front();
                    System.out.println("Front element : " + (value == -1?"No element in the queue":value));
                    break;
                case 4:
                    value = queueUsingLinkedList.rear();
                    System.out.println("Rear element : " + (value == -1?"No element in the queue":value));
                    break;
                case 5:
                    System.out.println(queueUsingLinkedList.queueEmpty() ? "queue is empty." : "queue is not empty");
                    break;
                case 6:
                    System.out.println("Size : " + queueUsingLinkedList.numberOfElements());
                    break;
                case 7:
                    queueUsingLinkedList.displayElements();
                    break;
                default:
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    public void enQueue(int element) {
        SinglePointerNode newNode = new SinglePointerNode(element);
        if (head != null) {
            SinglePointerNode traversalNode = head;
            while (traversalNode.getNext() != null) {
                traversalNode = traversalNode.getNext();
            }
            traversalNode.setNext(newNode);
        } else {
            head = newNode;
        }
    }

    public int deQueue() {
        if (head != null) {
            int ele = head.getData();
            head = head.getNext();
            return ele;
        } else {
            return -1;
        }
    }

    public int front(){
        if(head!=null){
            return head.getData();
        }
        return -1;
    }

    public int rear(){
        if(head !=null) {
            SinglePointerNode traversalNode = head;
            while (traversalNode.getNext() != null) {
                traversalNode = traversalNode.getNext();
            }
            return traversalNode.getData();
        }
        return -1;
    }

    public boolean queueEmpty(){
        return head == null;
    }

    public int numberOfElements(){
        int count = 0;
        if(head != null) {
            SinglePointerNode traversalNode = head;
            count++;
            while (traversalNode.getNext() != null) {
                traversalNode = traversalNode.getNext();
                count++;
            }
        }
        return count;
    }

    public void displayElements(){
        SinglePointerNode traversalNode = head;
        while(traversalNode != null){
            System.out.println("Node element : " + traversalNode.getData());
            traversalNode = traversalNode.getNext();
        }
    }
}
