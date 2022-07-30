package com.company.Deque;

import static java.lang.Integer.MIN_VALUE;

public class Deque {
    int[] array;
    int front;
    int rear;
    int capacity;
    int size;

    Deque(int c) {
        this.capacity = c;
        this.array = new int[capacity];
        front = 0;
        size = 0;
        rear = (front + size - 1) % capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFront(int num) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        front = (front - 1 + capacity) % capacity;
        this.array[front] = num;
        size += 1;
    }

    public int delFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return MIN_VALUE;
        }
        int temp = this.array[front];
        front = (front + 1) % capacity;
        size -= 1;
        return temp;
    }

    public void insertRear(int num) {
        if (isFull()) {
            System.out.println("Deque is empty");
            return;
        }
        rear = (front - size + 1) % capacity;
        rear = (rear + 1) % capacity;
        this.array[rear] = num;
        size += 1;
    }

    public int delRear() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return MIN_VALUE;
        }
        rear = (front - size + 1) % capacity;
        int temp = this.array[rear];
        rear = (rear - 1 + capacity) % capacity;
        size -= 1;
        return temp;
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return MIN_VALUE;
        }
        rear = (front + size - 1) % capacity;
        return this.array[rear];
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return MIN_VALUE;
        }
        return this.array[front];
    }
}
