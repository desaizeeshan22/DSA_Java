package com.company.stack;

import com.company.linked_list.Node;

import javax.imageio.metadata.IIOMetadataNode;

public class StackLinkedlistimpl {
    private Node head;
    private int capacity;
    private int size;

    StackLinkedlistimpl(int capacity) {
        head = null;
        size = 0;
        this.capacity = capacity;
    }

    StackLinkedlistimpl(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            temp.next = head;
            head = temp;
            size++;
        }
    }

    public void push(int elem) {
        if (size == capacity) {
            System.out.println("Stack is full");
            return;
        }
        Node temp = new Node(elem);
        temp.next = head;
        head = temp;
        size++;
    }

    public int pop() {
        if (!isEmpty()) {
            int elem = head.data;
            head = head.next;
            size--;
            return elem;
        }
        System.out.println("Stack is empty");
        return Integer.MAX_VALUE;
    }

    public int top() {
        return head == null ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
