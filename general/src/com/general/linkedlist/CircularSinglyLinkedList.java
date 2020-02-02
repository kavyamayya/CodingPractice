package com.general.linkedlist;

import java.util.Scanner;

/**
 * @author kavya k on 01-Feb-2020
 */
public class CircularSinglyLinkedList {
    private SinglePointerNode head = null;

    public static void main(String[] args) {
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
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
                    circularSinglyLinkedList.addElementFront(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("enter the element to be added to the back: ");
                    circularSinglyLinkedList.addElementBack(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("delete the element from the front: ");
                    System.out.println(circularSinglyLinkedList.deleteElementFront());
                    break;
                case 4:
                    System.out.print("delete the element from the back: ");
                    System.out.println(circularSinglyLinkedList.deleteElementBack());
                    break;
                case 5:
                    System.out.println("enter the element to be added at the position : ");
                    int element = scanner.nextInt();
                    System.out.println("enter the index : ");
                    int position = scanner.nextInt();
                    circularSinglyLinkedList.addElementPosition(element, position);
                    break;
                case 6:
                    System.out.println("enter the position from which element is to be deleted : ");
                    int value = circularSinglyLinkedList.deleteElementPosition(scanner.nextInt());
                    System.out.println(value != -1 ? value : "No element to delete");
                    break;
                case 7:
                    System.out.println("linked list elements : ");
                    circularSinglyLinkedList.displayList();
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
            newNode.setNext(newNode);
        } else {
            SinglePointerNode traversalNode = head;
            while(traversalNode.getNext()!=head){
                traversalNode = traversalNode.getNext();
            }
            traversalNode.setNext(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addElementBack(int element) {
        SinglePointerNode newNode = new SinglePointerNode(element);
        if (head != null) {
            SinglePointerNode traversalNode = head;
            while (traversalNode.getNext() != head) {
                traversalNode = traversalNode.getNext();
            }
            traversalNode.setNext(newNode);
            newNode.setNext(head);
        } else {
            head = newNode;
            newNode.setNext(newNode);
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
            if(head!=null) {
                SinglePointerNode traversalNod = head;
                while (traversalNod.getNext() != head) {
                    traversalNod = traversalNod.getNext();
                }
                traversalNod.setNext(newNode);
                newNode.setNext(head);
                head = newNode;
            }else{
                head = newNode;
                head.setNext(newNode);
            }
        } else {
            while (count < index - 1 && traversalNode.getNext() != head) {
                traversalNode = traversalNode.getNext();
                count++;
            }
            if (traversalNode.getNext() == head && count < index - 1) {
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
            if (head.getNext() != head) {
                SinglePointerNode traversalNode = head;
                while (traversalNode.getNext() != head) {
                    traversalNode = traversalNode.getNext();
                }
                head = head.getNext();
                traversalNode.setNext(head);
            }else{
                head = null;
            }
            return ele;
        } else {
            return -1;
        }
    }

    public int deleteElementBack() {
        if (head == null) {
            return -1;
        }
        if (head.getNext() != head) {
            SinglePointerNode traversalNode = head;
            SinglePointerNode temp = traversalNode;
            while (traversalNode.getNext() != head) {
                temp = traversalNode;
                traversalNode = traversalNode.getNext();
            }
            temp.setNext(head);
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
            if(head.getNext() !=head) {
                SinglePointerNode traversalNode = head;
                while (traversalNode.getNext() != head) {
                    traversalNode = traversalNode.getNext();
                }
                head = head.getNext();
                traversalNode.setNext(head);
            }else{
                head = null;
            }
            return value;
        }
        SinglePointerNode curNode = head;
        int count = 0;
        while (count < index - 1 && curNode.getNext() != head) {
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
        if(head != null) {
            System.out.println("node value value: " +head.getData());
            System.out.println("next value : " + (nodeRef.getNext() == null?null:nodeRef.getNext().getData()));
            while (nodeRef.getNext() != head) {
                nodeRef = nodeRef.getNext();
                System.out.println("node value value: " + nodeRef.getData());
                System.out.println("next value : " + (nodeRef.getNext() == null?null:nodeRef.getNext().getData()));
            }
        }
    }
}
