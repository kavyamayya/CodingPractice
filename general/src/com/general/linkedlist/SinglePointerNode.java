package com.general.linkedlist;

/**
 * @author kavya k on 26-Jan-2020
 */
public class SinglePointerNode {
    private int data;
    private SinglePointerNode next;

    public SinglePointerNode(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglePointerNode getNext() {
        return next;
    }

    public void setNext(SinglePointerNode next) {
        this.next = next;
    }
}
