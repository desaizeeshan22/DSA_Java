package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class main_queue {
    public static void main(String[] args) {
//        Queue_ll q=new Queue_ll(4);
//        q.enqueue( 10);
//        System.out.println(q.getFront());
//        q.enqueue( 20);
//        System.out.println(q.getFront());
//        q.enqueue( 30);
//        System.out.println(q.getFront());
//        q.enqueue( 40);
//        q.enqueue(50);
//        System.out.println(q.getSize());
//        System.out.println(q.dequeue());
//        System.out.println(q.getSize());
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        recreverseQueue(q);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }


    }

    public static void recreverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int x = q.poll();
        recreverseQueue(q);
        q.offer(x);
        return;

    }
}
