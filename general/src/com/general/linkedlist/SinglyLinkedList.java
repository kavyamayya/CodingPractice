package com.general.linkedlist;

import java.util.Scanner;

/**
 * @author kavya k on 12-Jan-2020
 */
public class SinglyLinkedList {

    private SinglePointerNode head = null;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
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
            switch (argument) {
                case 1:
                    System.out.println("enter the element to be added to the front: ");
                    singlyLinkedList.addElementFront(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("enter the element to be added to the back: ");
                    singlyLinkedList.addElementBack(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("delete the element from the front: ");
                    System.out.println(singlyLinkedList.deleteElementFront());
                    break;
                case 4:
                    System.out.print("delete the element from the back: ");
                    System.out.println(singlyLinkedList.deleteElementBack());
                    break;
                case 5:
                    System.out.println("enter the element to be added at the position : ");
                    int element = scanner.nextInt();
                    System.out.println("enter the index : ");
                    int position = scanner.nextInt();
                    singlyLinkedList.addElementPosition(element, position);
                    break;
                case 6:
                    System.out.println("enter the position from which element is to be deleted : ");
                    int value = singlyLinkedList.deleteElementPosition(scanner.nextInt());
                    System.out.println(value != -1 ? value : "No element to delete");
                    break;
                case 7:
                    System.out.println("linked list elements : ");
                    singlyLinkedList.displayList();
                    break;
                default:
                    run = false;
                    break;
            }
        }
        scanner.close();
    }

    public void addElementFront(int element) {
        SinglePointerNode newNode = new SinglePointerNode(element);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addElementBack(int element) {
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

    public void addElementPosition(int element, int index) {
        SinglePointerNode newNode = new SinglePointerNode(element);
        int count = 0;
        SinglePointerNode traversalNode = head;
        if (index < 0) {
            System.out.println("Invalid position specified");
            return;
        }
        if (index == 0) {
            newNode.setNext(head);
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
                traversalNode.setNext(newNode);
            }
        }
    }

    public int deleteElementFront() {
        if (head != null) {
            int ele = head.getData();
            head = head.getNext();
            return ele;
        } else {
            return -1;
        }
    }

    public int deleteElementBack() {
        if (head == null) {
            return -1;
        }
        if (head.getNext() != null) {
            SinglePointerNode traversalNode = head;
            SinglePointerNode temp = traversalNode;
            while (traversalNode.getNext() != null) {
                temp = traversalNode;
                traversalNode = traversalNode.getNext();
            }
            temp.setNext(null);
            return traversalNode.getData();
        }
        int value = head.getData();
        head = null;
        return value;
    }

    public int deleteElementPosition(int index) {
        if (head == null) {
            System.out.println("There is no element in the list");
            return -1;
        }
        int value = -1;
        if (index == 0) {
            value = head.getData();
            head = head.getNext();
            return value;
        }
        SinglePointerNode curNode = head;
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
        SinglePointerNode nodeRef = head;
        while (nodeRef != null) {
            System.out.println("node value value: " + nodeRef.getData());
            System.out.println("next value : " + (nodeRef.getNext() == null?null:nodeRef.getNext().getData()));
            nodeRef = nodeRef.getNext();
        }
    }
}
