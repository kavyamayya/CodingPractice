package com.scaler;

/**
 * @author kavya k on 22-Aug-2020
 *
 *
 *  9 -> 8 -> 7 ->6 -> 5 -> 4 -> 3 -> 2 -> 1
 *
 *   curnode = null
 *   first = 9
 *   next = 8
 *   9.next = curnode
 *   curNode = 9
 *   8
 *   next =7
 *   8.next = 9
 *   curnode = 8
 *
 *   7
 *   next = 6
 *   7.next = 8
 *   when node = kth node
 *  first.next = 6
 *
 *  first = 6
 *
 *  k will be given
 *  k = 3
 *  7 -> 8 ->9 ->4 -> 5 ->6 ->1 ->2 ->3

 *
 */
public class LinkedListReverse {
    static LinkedListNode headNew = null;
    static boolean first = true;
    public static LinkedListNode reverseLinkedList(LinkedListNode head , int k){
        LinkedListNode curNode = null;
        LinkedListNode nextNode = null;

        LinkedListNode traverseNode = head;
        LinkedListNode join = null;
        LinkedListNode lastNode = null;
        LinkedListNode firstNode= head;
        while(traverseNode != null) {
            LinkedListNode endNode = getLastNode(k , firstNode);
            if(join !=null){
                join.next = endNode;
            }
            join= firstNode;
            traverseNode = firstNode.next;
            firstNode = traverseNode;
            System.out.println("endNode :"+endNode.value);
        }
        return headNew;
    }

    public static LinkedListNode getLastNode(int k , LinkedListNode firstNode){
        int temp = k;
        LinkedListNode curNode = null;
        LinkedListNode nextNode = null;
        LinkedListNode traverseNode = firstNode;
        while (temp > 0 && traverseNode != null) {
            nextNode = traverseNode.next;  //
            traverseNode.next = curNode;
            curNode = traverseNode;
            traverseNode = nextNode;
            temp--;
        }
        firstNode.next = nextNode;
        if(first){
            headNew = curNode;
            first = false;
        }
        return curNode;
    }

    public static void main(String[] args){
        LinkedListNode head = new LinkedListNode(9);
        LinkedListNode second = new LinkedListNode(8);
        LinkedListNode third = new LinkedListNode(7);
        LinkedListNode fourth = new LinkedListNode(6);
        LinkedListNode fifth = new LinkedListNode(5);
        LinkedListNode sixth = new LinkedListNode(4);
        LinkedListNode seventh = new LinkedListNode(3);
        LinkedListNode eighth = new LinkedListNode(2);
        LinkedListNode ninth = new LinkedListNode(1);
        LinkedListNode tenth = new LinkedListNode(10);
        LinkedListNode eleventh = new LinkedListNode(11);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;
        tenth.next=eleventh;
        LinkedListNode curBefore = head;
        while(curBefore!=null){
            System.out.print(curBefore.value+" ");
            curBefore = curBefore.next;
        }
        System.out.println();
         LinkedListNode res = reverseLinkedList(head , 4);
        LinkedListNode curAfter = res;
        while(curAfter!=null){
            System.out.print(curAfter.value+" ");
            curAfter = curAfter.next;
        }
    }
}

class LinkedListNode{
    int value;
    LinkedListNode next;

    LinkedListNode(int value ){
        this.value = value;
    }
}
