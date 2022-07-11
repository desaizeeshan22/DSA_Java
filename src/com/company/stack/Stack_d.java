package com.company.stack;

import java.util.*;

import static java.lang.Integer.max;

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

    public ArrayList<Integer> stockSpan(int[] array) {
        int span = 1;
        Stack<int[]> st = new Stack<int[]>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        st.push(new int[]{array[0], 1});
        for (int i = 1; i < array.length; i++) {
            span = 1;
            while (!st.isEmpty() && array[i] >= st.peek()[0]) {
                span += st.peek()[1];
                st.pop();
            }
            st.push(new int[]{array[i], span});
            result.add(span);
        }
        return result;
    }

    public ArrayList<Integer> stockSpanalt(int[] array) {
        int span = 1;
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        st.push(0);
        for (int i = 1; i < array.length; i++) {
            span = 1;
            while (st.isEmpty() == false && array[st.peek()] <= array[i]) {
                st.pop();
            }
            span = st.isEmpty() ? i + 1 : i - st.peek();
            result.add(span);
            st.push(i);
        }
        return result;
    }

    public ArrayList<Integer> prevGreaterElement(int[] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < array.length; i++) {
            while (!st.isEmpty() && st.peek() <= array[i]) {
                st.pop();
            }
            int elem = st.isEmpty() ? -1 : st.peek();
            st.push(array[i]);
            result.add(elem);
        }
        return result;
    }

    public ArrayList<Integer> nextGreaterElement(int[] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = array.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < array[i]) {
                st.pop();
            }
            int elem = st.isEmpty() ? -1 : st.peek();
            st.push(array[i]);
            result.add(elem);
        }
        Collections.reverse(result);
        return result;
    }

    public int maxAreaNaive(int[] array) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] >= array[i]) {
                    curr += array[i];
                } else {
                    break;
                }
            }
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] >= array[i]) {
                    curr += array[i];
                } else {
                    break;
                }
            }
            res = max(res, curr);
        }

        return res;
    }
    public int maxAreaEff(int []array){
        Stack<Integer>st=new Stack<Integer>();
        st.push(-1);
        int maxArea=0;
        for(int i=0;i<array.length;i++){
            while(st.peek()!=-1&&array[st.peek()]>=array[i]){
                int currHeight=array[st.pop()];
                maxArea=Math.max(maxArea,currHeight*(i-st.peek()-1));
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int currHeight=array[st.pop()];
            maxArea=Math.max(maxArea,array.length-st.peek()-1);
        }
        return maxArea;
    }
    public String infixToPostfix(String infix){
        String res="";
        Stack<Character>st=new Stack<Character>();
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        String operators="^*/+-";
        for(int i=0;i<operators.length();i++){
            if(operators.charAt(i)=='^'){
                map.put(operators.charAt(i),3);
            }
            if(operators.charAt(i)=='*'||operators.charAt(i)=='/'){
                map.put(operators.charAt(i),2);
            }
            if(operators.charAt(i)=='+'||operators.charAt(i)=='-'){
                map.put(operators.charAt(i),1);
            }
        }
        for(int i=0;i<infix.length();i++){
            if(infix.charAt(i)=='('){
                st.push(infix.charAt(i));
            }
            else if(infix.charAt(i)==')'){
                while(!st.isEmpty()&&st.peek()!='('){
                    res+=st.pop();
                }
                if(!st.isEmpty()&&st.peek()==')') {
                    st.pop();
                }
            }
            else if(!map.containsKey(infix.charAt(i))){
                res+=infix.charAt(i);
            }
            else{
                if((st.isEmpty())||st.peek()=='('||(map.get(infix.charAt(i))>map.get(st.peek()))){
                    st.push(infix.charAt(i));
                }
                else if(map.get(infix.charAt(i))<=map.get(st.peek())){
                    while(!st.isEmpty()&&st.peek()!='('&&map.get(infix.charAt(i))<=map.get(st.peek())){
                        res+=st.pop();
                    }
                    st.push(infix.charAt(i));
                }
                }
            }
        while(!st.isEmpty()){
            if(st.peek()=='('||st.peek()==')'){
                st.pop();
            }
            else {
                res += st.pop();
            }
        }
        return res;
    }
}


