package com.company.stack;

public class main_stack {
    public static void main(String [] args){
        Stack_d st=new Stack_d(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.display();
        System.out.println(" ");
        System.out.println(st.pop());
        System.out.println(" ");
        st.display();
        st.push(60);
        System.out.println(" ");
        st.display();
        st.push(70);
        st.push(80);
    }
}
