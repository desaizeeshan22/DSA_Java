package com.company.queue;

import com.company.linked_list.Node;

public class Queue_ll {
    private int size;
    private int capacity;
    private Node first;
    private Node rear;

    public Queue_ll(int capacity) {
        this.first = this.rear = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full,failed to enqueue item");
            return;
        }
        Node temp = new Node(item);
        if (first == null) {
            first = rear = temp;
        }
        rear.next = temp;
        rear = temp;
        size += 1;
        return;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        Node item = first;
        first = first.next;
        size -= 1;
        return item.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return Integer.MIN_VALUE;
        }
        return this.first.data;
    }
}
