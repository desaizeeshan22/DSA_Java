package com.company.doubly_linked_list;

public class Node_dll {
    public int data;
    public Node_dll prev;
    public Node_dll next;

    public Node_dll() {
        data = 0;
        prev = null;
        next = null;
    }

    public Node_dll(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}
