package com.company.Trees;

public class Node_AVL {
    public Node_AVL lchild;
    public Node_AVL rchild;
    public int data;
    public int height;

    public Node_AVL(int data) {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }
}
