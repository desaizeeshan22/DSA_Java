package com.company.doubly_linked_list;

public class Node_dll {
    int data;
    Node_dll prev;
    Node_dll next;

    Node_dll() {
        data = 0;
        prev = null;
        next = null;
    }

    Node_dll(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}
