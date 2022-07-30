package com.company.Deque;

public class main_deque {
    public static void main(String[] args) {
//        Deque d = new Deque(4);
//        d.insertFront(5);
//        d.delRear();
//        System.out.println(d.getFront());
//        System.out.println(d.getRear());
        Deque_ll d_2 = new Deque_ll(6);
        d_2.insertRear(1);
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
        d_2.insertFront(2);
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
        d_2.insertRear(4);
        System.out.println(d_2.getFront());
        System.out.println(d_2.getLast());
//        d_2.deleteRear();
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
    }
}
