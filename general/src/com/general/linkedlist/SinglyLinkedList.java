package com.general.linkedlist;

import java.util.Scanner;

/**
 * @author kavya k on 12-Jan-2020
 */
public class SinglyLinkedList {

    public static Node head=null;

    public static void main(String[] args){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Select one of the options from below:");
            System.out.println("1 - add element to the front\n" + "2 - add element to the last\n" + "3 - delete" +
                    " element from the front\n" + "4 - delete element from the last"
                    + "5 - insert at the position\n" + "6 - delete at the position\n"
                    + "7 - print the elements in the linked list\n" + "Press any other key to exit ");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("enter one of the options");
            int argument = scanner.nextInt();
            switch (argument) {
                case 1:
                    System.out.println("enter the element to be added to the front: ");
                    addElementFront(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("enter the element to be added to the back: ");
                    addElementBack(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("delete the element from the front: ");
                    System.out.println(deleteElementFront());
                    break;
                case 4:
                    System.out.print("delete the element from the back: ");
                    System.out.println(deleteElementBack());
                    break;
                case 5:
                    System.out.println("enter the element to be added at the position : ");
                    int element = scanner.nextInt();
                    System.out.println("enter the index : ");
                    int position = scanner.nextInt();
                    addElementPosition(element , position);
                    break;
                case 6:
                    System.out.println("enter the position from which element is to be deleted : ");
                    System.out.println(deleteElementPosition(scanner.nextInt()));
                    break;
                case 7:
                    System.out.println("linked list elements : ");
                    Node nodeRef = singlyLinkedList.head;
                    while(nodeRef !=null){
                        System.out.println("node value : " + nodeRef.getData());
                        nodeRef = nodeRef.getNext();
                    }
                    break;
                default:
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    public static void addElementFront(int element) {
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
        }else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public static void addElementBack(int element) {
        Node newNode = new Node(element);
        if(head != null) {
            Node traversalNode = head;
            Node temp = traversalNode;
            while (traversalNode != null) {
                temp = traversalNode;
                traversalNode = traversalNode.getNext();
            }
            temp.setNext(newNode);
        }else{
            head = newNode;
        }
    }

    public static void addElementPosition(int element , int index) {
        Node newNode = new Node(element);
        int count = 0;
        if(head != null) {
            Node traversalNode = head;
            Node temp = traversalNode;
            while (count != index && traversalNode!=null) {
                temp = traversalNode;
                traversalNode = traversalNode.getNext();
                count++;
            }
            if(count ==index) {
                newNode.setNext(traversalNode);
                temp.setNext(newNode);
            }else{
                System.out.println("the specified index is greater than the maximum index of the linked list.");
            }
        }else{
            if(index !=0){
                System.out.println("the count of numbers less than specified index");
            }else {
                head = newNode;
            }
        }
    }

    public static int deleteElementFront(){
        System.out.println(head);
        if(head !=null) {
            int ele = head.getData();
            head = head.getNext();
            return ele;
        }else{
            System.out.println("no element to delete ");
            return -1;
        }
    }

    public static int deleteElementBack(){
        if (head != null && head.getNext() != null) {
            Node traversalNode = head;
            Node temp = traversalNode;
            while (traversalNode.getNext() != null) {
                temp = traversalNode;
                traversalNode = traversalNode.getNext();
            }
            temp.setNext(null);
            return traversalNode.getData();
        } else if (head!=null && head.getNext() == null) {
            int returnValue = head.getData();
            head = null;
            return returnValue;
        } else {
            System.out.println("no element to delete ");
            return -1;
        }
    }

    public static int deleteElementPosition(int index){
        int count = 0;
        if(head != null) {
            Node traversalNode = head;
            Node temp = traversalNode;
            Node nextNod = traversalNode;
            while (count != index && traversalNode.getNext()!=null) {
                temp = traversalNode;
                nextNod = traversalNode.getNext().getNext();
                traversalNode = traversalNode.getNext();
                count++;
            }
            if(count ==index && count!=0) {
                temp.setNext(nextNod);
                return traversalNode.getData();
            }else if(count ==index && count==0){
                int ret = head.getData();
                head = head.getNext();
                return ret;
            }else{
                System.out.println("no element in the specified index.");
                return -1;
            }
        }else{
            System.out.println("No element in the linked list");
            return -1;
        }
    }
    static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
