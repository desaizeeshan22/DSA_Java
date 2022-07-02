package com.company.stack;

public class main_stack {
    public static void main(String [] args){
//        Stack_d st=new Stack_d(5);
//        st.push(10);
//        st.push(20);
//        st.push(30);
//        st.push(40);
//        st.push(50);
//        st.display();
//        System.out.println(" ");
//        System.out.println(st.pop());
//        System.out.println(" ");
//        st.display();
//        st.push(60);
//        System.out.println(" ");
//        st.display();
//        st.push(70);
//        st.push(80);
        Stack_d st=new Stack_d(5);
        System.out.println(st.stockSpan(new int[]{100,80,60,70,60,75,85}));
        System.out.println(st.stockSpanalt(new int[]{100,80,60,70,60,75,85}));
        System.out.println(st.prevGreaterElement(new int[]{15,10,18,12,4,6,2,8}));
        System.out.println(st.nextGreaterElement(new int[]{5,15,10,8,6,12,9,18}));
    }
}
