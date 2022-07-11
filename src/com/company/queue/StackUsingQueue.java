package com.company.queue;

import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> q1, q2;

    public int size() {
        return q1.size();
    }

    public int top() {
        return q1.peek();
    }

    public int pop() {
        return q1.poll();
    }

    public void push(int elem) {
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        q1.offer(elem);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }
}
