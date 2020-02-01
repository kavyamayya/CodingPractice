package com.general.linkedlist;

import java.util.Scanner;

/**
 * @author kavya k on 18-Jan-2020
 */
public class DoublyLinkedList {

    public static DoublePointerNode head=null;

    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Select one of the options from below:");
            System.out.println("1 - add element to the front\n" + "2 - add element to the last\n" + "3 - delete" +
                    " element from the front\n" + "4 - delete element from the last\n"
                    + "5 - insert at the position\n" + "6 - delete at the position\n"
                    + "7 - print the elements in the linked list\n" + "Press any other key to exit ");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("enter one of the options");
            int argument = scanner.nextInt();
            int value;
            switch (argument) {
                case 1:
                    System.out.println("enter the element to be added to the front: ");
                    doublyLinkedList.addElementFront(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("enter the element to be added to the back: ");
                    doublyLinkedList.addElementBack(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("delete the element from the front: ");
                    value = doublyLinkedList.deleteElementFront();
                    System.out.println(value != -1 ? value : "No element to delete");
                    break;
                case 4:
                    System.out.print("delete the element from the back: ");
                    value = doublyLinkedList.deleteElementBack();
                    System.out.println(value != -1 ? value : "No element to delete");
                    break;
                case 5:
                    System.out.println("enter the element to be added at the position : ");
                    int element = scanner.nextInt();
                    System.out.println("enter the index : ");
                    int position = scanner.nextInt();
                    doublyLinkedList.addElementPosition(element , position);
                    break;
                case 6:
                    System.out.println("enter the position from which element is to be deleted : ");
                    value = doublyLinkedList.deleteElementPosition(scanner.nextInt());
                    System.out.println(value != -1 ? value : "No element to delete");
                    break;
                case 7:
                    System.out.println("linked list elements : ");
                    doublyLinkedList.displayList();
                    break;
                default:
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    public void addElementFront(int element) {
        DoublePointerNode newNode = new DoublePointerNode(element);
        if(head == null) {
            head = newNode;
        }else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addElementBack(int element) {
        DoublePointerNode newNode = new DoublePointerNode(element);
        if(head != null) {
            DoublePointerNode traversalNode = head;
            while (traversalNode.getNext() != null) {
                traversalNode = traversalNode.getNext();
            }
            newNode.setPrev(traversalNode);
            traversalNode.setNext(newNode);
        }else{
            head = newNode;
        }
    }

    public void addElementPosition(int element , int index) {
        DoublePointerNode newNode = new DoublePointerNode(element);
        int count = 0;
        DoublePointerNode traversalNode = head;
        if (index < 0) {
            System.out.println("Invalid position specified");
            return;
        }
        if (index == 0) {
            if(head!=null){
                newNode.setNext(head);
                head.setPrev(newNode);
            }
            head = newNode;
        } else {
            while (count < index - 1 && traversalNode.getNext() != null) {
                traversalNode = traversalNode.getNext();
                count++;
            }
            if (traversalNode.getNext() == null && count < index - 1) {
                System.out.println("the specified position is greater than the size of the linked list.");
            } else {
                newNode.setNext(traversalNode.getNext());
                newNode.setPrev(traversalNode);
                traversalNode.getNext().setPrev(newNode);
                traversalNode.setNext(newNode);

            }
        }
    }

    public int deleteElementFront(){
        System.out.println(head);
        if(head !=null) {
            int ele = head.getData();
            head.setPrev(null);
            head = head.getNext();
            return ele;
        }else{
            return -1;
        }
    }

    public int deleteElementBack() {
        if (head == null) {
            return -1;
        }
        int value;
        if (head.getNext() != null) {
            DoublePointerNode traversalNode = head;
            while (traversalNode.getNext().getNext() != null) {
                traversalNode = traversalNode.getNext();
            }
            value = traversalNode.getNext().getData();
            traversalNode.setNext(null);
            return value;
        }
        value = head.getData();
        head = null;
        return value;
    }

    public int deleteElementPosition(int index) {
        if (head == null) {
            return -1;
        }
        int value = -1;
        if (index == 0) {
            value = head.getData();
            head = head.getNext();
            head.setPrev(null);
            return value;
        }
        DoublePointerNode curNode = head;
        int count = 0;
        while (count < index - 1 && curNode.getNext() != null) {
            curNode = curNode.getNext();
            count++;
        }
        if (curNode.getNext() == null && count < index) {
            System.out.println("specified index does not exist in the list");
        } else {
            value = curNode.getNext().getData();
            curNode.setNext(curNode.getNext().getNext());
        }
        return value;
    }

    public void displayList() {
        DoublePointerNode nodeRef = head;
        while (nodeRef != null) {
            System.out.println("node value : " + nodeRef.getData());
            System.out.println("prev value : " + (nodeRef.getPrev() != null?nodeRef.getPrev().getData():null));
            System.out.println("next value : " + (nodeRef.getNext() == null?null:nodeRef.getNext().getData()));
            nodeRef = nodeRef.getNext();
        }
    }
}
