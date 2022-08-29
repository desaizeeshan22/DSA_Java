package com.company.Trees;

import java.util.Stack;

public class main_tree {
    public static void main(String[] args) {
        Node_BT root = new Node_BT(10);
        root.lchild = new Node_BT(20);
        root.rchild = new Node_BT(30);
        root.lchild.lchild = new Node_BT(5);
        root.lchild.rchild = new Node_BT(25);
        root.rchild.rchild = new Node_BT(35);
//        InorderTraversal(root);
//        System.out.println(" ");
//        iterativeInorderTraversal(root);
//        System.out.println(" ");
        PreorderTraversal(root);
    }

    public static void InorderTraversal(Node_BT root) {
        if (root == null) {
            return;
        }
        InorderTraversal(root.lchild);
        System.out.print(root.data + " ");
        InorderTraversal(root.rchild);
    }

    public static void iterativeInorderTraversal(Node_BT root) {
        Stack<Node_BT> st = new Stack<Node_BT>();
        Node_BT curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.lchild;
            } else {
                curr = st.pop();
                System.out.print(curr.data + " ");
                curr = curr.rchild;
            }
        }
    }

    public static void PreorderTraversal(Node_BT root) {
        if(root == null){
            return  ;
        }
        System.out.print(root.data);
        System.out.print(" ");
        PreorderTraversal(root.lchild);
        PreorderTraversal(root.rchild);
    }
}
