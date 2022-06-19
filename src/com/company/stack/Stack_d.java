package com.company.stack;

public class Stack_d {
    private int capacity;
    private int[] arr;
    private int top;
    private int size;

    Stack_d(int capacity) {
        top = -1;
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public void push(int elem) {
        if (size == capacity) {
            System.out.println("Stack is full");
            return;
        }
        this.top += 1;
        this.arr[top] = elem;
        this.size += 1;
        return;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -11111;
        }
        int elem = arr[top];
        top -= 1;
        size -= 1;
        return elem;
    }

    public int peek(int pos) {
        int i = 0;
        while (i < pos) {
            i++;
        }
        if (i > top) {
            System.out.println("position out of bounds");
            return -1111;
        }
        return arr[i];
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(String.format(" %d ", arr[i]));
        }
        System.out.print("]");
    }
}


