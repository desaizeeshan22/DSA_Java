package com.company.Deque;

import com.company.doubly_linked_list.Node_dll;

import static java.lang.Integer.MIN_VALUE;

public class Deque_ll {
    Node_dll first;
    int size;
    int capacity;
    Node_dll last;

    Deque_ll(int c) {
        this.capacity = c;
        this.size = 0;
        this.first = this.last = null;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("The deque is empty");
            return MIN_VALUE;
        }
        return first.data;
    }

    public int getLast() {
        if (isEmpty()) {
            System.out.println("The deque is empty");
            return MIN_VALUE;
        }
        return last.data;
    }

    public void insertFront(int data) {
        Node_dll temp = new Node_dll(data);
        if (isFull()) {
            System.out.println("The deque is full");
            return;
        }
        size += 1;
        if (isEmpty()) {
            first = last = temp;
            return;
        }
        temp.next = first;
        first.prev = temp;
        first = temp;
        return;
    }

    public void insertRear(int data) {
        Node_dll temp = new Node_dll(data);
        if (isFull()) {
            System.out.println("The deque is full");
            return;
        }
        if (isEmpty()) {
            size += 1;
            first = temp;
            last = temp;
            return;
        }
        size += 1;
        last.next = temp;
        temp.prev = last;
        last = temp;
        return;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("The Deque is empty");
            return MIN_VALUE;
        }
        size -= 1;
        int temp = last.data;
        if (first == last) {
            this.first = this.last = null;
            return temp;
        }
        last = last.prev;
        last.next = null;
        return temp;
    }
}
