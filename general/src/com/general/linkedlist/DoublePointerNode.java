package com.general.linkedlist;

/**
 * @author kavya k on 26-Jan-2020
 */
public class DoublePointerNode {
    private int data;
    private DoublePointerNode next;
    private DoublePointerNode prev;

    public DoublePointerNode(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublePointerNode getNext() {
        return next;
    }

    public void setNext(DoublePointerNode next) {
        this.next = next;
    }

    public DoublePointerNode getPrev() {
        return prev;
    }

    public void setPrev(DoublePointerNode prev) {
        this.prev = prev;
    }
}
