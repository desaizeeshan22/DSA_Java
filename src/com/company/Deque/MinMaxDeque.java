package com.company.Deque;

import java.util.ArrayDeque;

public class MinMaxDeque {
    private int size;
    private int capacity;
    private ArrayDeque<Integer> collection;

    public MinMaxDeque(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.collection = new ArrayDeque<Integer>();
    }

    public int GetMax() {
        if (isEmpty()) {
            System.out.println("Container is empty");
            return Integer.MAX_VALUE;
        }
        return this.collection.getLast();
    }

    public int GetMin() {
        if (isEmpty()) {
            System.out.println("Container is empty");
            return Integer.MIN_VALUE;
        }
        return this.collection.getFirst();
    }

    public void InsertMin(int val) {
        if (isEmpty() || val < GetMin()) {
            this.collection.addFirst(val);
            return;
        }
        System.out.println("Cannot insert value as existing minimum is lesser than value to be inserted");
        return;

    }

    public void InsertMax(int val) {
        if (isEmpty() || val > GetMax()) {
            this.collection.addLast(val);
            return;
        }
        System.out.println("Cannot insert value as existing maximum is greater than value to be inserted");
        return;

    }


    boolean isEmpty() {
        return this.size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }
}
