package com.company.queue;

import java.util.Stack;

public class Queue {
    private int front;
    private int rear;
    private int[] arr;
    private int capacity;
    private int size;

    Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        front = this.size = 0;
        rear = capacity - 1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size += 1;
        return;
    }

    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int temp = this.arr[front];
        size -= 1;
        front = (front + 1) % capacity;
        return temp;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public int getSize() {
        return size;
    }

    public int getFront() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.arr[rear];
    }

    public void reverse() {
        Stack<Integer> st = new Stack<Integer>();
        while (!isEmpty()) {
            st.push(this.dequeue());
        }
        while (!st.isEmpty()) {
            this.enqueue(st.pop());
        }
    }
}
