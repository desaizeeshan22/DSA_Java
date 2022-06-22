package com.company.stack;

public class TwoStack {
    int[] array;
    int top1;
    int top2;
    int capacity;
    int size;
    public TwoStack(int capacity){
        this.capacity = capacity;
        this.top1=-1;
        this.top2= capacity;
        this.array=new int[capacity];
    }
    public void push1(int elem){
        if(top1<top2-1) {
            top1++;
            array[top1]=elem;
            return ;
        }
        System.out.println("Stack is full");
        return ;
    }
    public void push2(int elem){
        if(top1<top2-1) {
            top2--;
            array[top2]=elem;
            return ;
        }
        System.out.println("Stack is full");
        return ;
    }

    public int pop1(){
        if(top1>=0){
            int elem=array[top1];
            top1--;
            return elem;
        }
        System.out.println("Stack1 is empty");
        return Integer.MAX_VALUE;
    }
    public int pop2(){
        if(top2<capacity){
            int elem=array[top2];
            top2++;
            return elem;
        }
        System.out.println("Stack2 is empty");
        return Integer.MAX_VALUE;
    }


}
