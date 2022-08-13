package com.company.Deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class main_deque {
    public static void main(String[] args) {
//        Deque d = new Deque(4);
//        d.insertFront(5);
//        d.delRear();
//        System.out.println(d.getFront());
//        System.out.println(d.getRear());
//        Deque_ll d_2 = new Deque_ll(6);
//        d_2.insertRear(1);
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
//        d_2.insertFront(2);
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
//        d_2.insertRear(4);
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
//        d_2.deleteRear();
//        System.out.println(d_2.getFront());
//        System.out.println(d_2.getLast());
        System.out.println(slidingMaxWindow(new ArrayList<Integer>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7)), 3));

    }

    //    You are given an array of integers nums, there is a sliding window of size k
//    which is moving from the very left of the array to the very right.
//    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//    Return the max sliding window.
    public static ArrayList<Integer> slidingMaxWindow(ArrayList<Integer> nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, deque, k, nums);
            deque.addLast(i);
            if (nums.get(i) > nums.get(maxIndex)) {
                maxIndex = i;
            }
        }
        output.add(nums.get(maxIndex));
        for (int i = k; i < nums.size(); i++) {
            cleanDeque(i, deque, k, nums);
            deque.addLast(i);
            output.add(nums.get(deque.getFirst()));
        }
        return output;

    }

    public static void cleanDeque(int i, ArrayDeque<Integer> deque, int k, ArrayList<Integer> nums) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums.get(i) > nums.get(deque.getLast())) {
            deque.removeLast();
        }
        return;
    }

}
