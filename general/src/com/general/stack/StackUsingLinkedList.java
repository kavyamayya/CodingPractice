package com.general.stack;

import com.general.linkedlist.SinglePointerNode;

import java.util.Scanner;

/**
 * @author kavya k on 01-Feb-2020
 */
public class StackUsingLinkedList {
    private SinglePointerNode top = null;
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select one of the options from below:");
        System.out.println("1 - push\n" + "2 - pop\n" + "3 - top element\n" + "4 - stack empty check\n" +
                "5 - number of elements in the stack\n"
                + "6 - print the elements in the stack\n"+"Press any other key to exit ");
        boolean run = true;
        while (run) {
            System.out.println("enter one of the options");
            int argument = scanner.nextInt();
            int value;
            switch (argument) {
                case 1:
                    System.out.println("enter the element to be pushed : ");
                    stack.push(scanner.nextInt());
                    break;
                case 2:
                    value = stack.pop();
                    System.out.println((value == -1) ? "No element to pop" : String.format("pop element : %d", value));
                    break;
                case 3:
                    value = stack.top();
                    System.out.println("Top element :" + (value==-1?"No element in the stack.":value));
                    break;
                case 4:
                    System.out.println(stack.isEmpty()?"stack is empty.":"stack is not empty");
                    break;
                case 5:
                    System.out.println("Size : " + stack.numberOfElements());
                    break;
                case 6:
                    stack.display();
                    break;
                default:
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    public void push(int element) {
        SinglePointerNode newNode = new SinglePointerNode(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    public int pop() {
        if (top != null) {
            int ele = top.getData();
            top = top.getNext();
            return ele;
        } else {
            return -1;
        }
    }

    public int top(){
        return top !=null?top.getData():-1;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int numberOfElements(){
        int count = 0;
        if(top != null) {
            SinglePointerNode traversalNode = top;
            count++;
            while (traversalNode.getNext() != null) {
                traversalNode = traversalNode.getNext();
                count++;
            }
        }
        return count;
    }

    public void display(){
        SinglePointerNode traversalNode = top;
        while(traversalNode != null){
            System.out.println("Node element : " + traversalNode.getData());
            traversalNode = traversalNode.getNext();
        }
    }
}
