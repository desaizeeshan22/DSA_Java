package com.company.Trees;

import java.util.*;

public class Tree {

    private Node_BT root;

    public Node_BT getRoot() {
        return root;
    }

    public Tree() {
    }


    public void createTree() {
        Queue<Node_BT> queue = new LinkedList<Node_BT>();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter root node value : ");
        root = new Node_BT(userInput.nextInt());
        if (root.data == -1) {
            System.out.println("Root is empty,tree is a null tree");
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node_BT temp = queue.poll();
            System.out.println(String.format("Please enter left child node value of %d : ", temp.data));
            int lchildValue = userInput.nextInt();
            if (lchildValue != -1) {
                temp.lchild = new Node_BT(lchildValue);
                queue.add(temp.lchild);
            }
            System.out.println(String.format("Please enter right child node value of %d : ", temp.data));
            int rchildValue = userInput.nextInt();
            if (rchildValue != -1) {
                temp.rchild = new Node_BT(rchildValue);
                queue.add(temp.rchild);
            }
        }
    }

    public void inOrderTraversal(Node_BT Node) {
        if (Node == null) {
            return;
        }
        inOrderTraversal(Node.lchild);
        System.out.println(Node.data);
        inOrderTraversal(Node.rchild);
    }

    public void preOrderTraversal(Node_BT Node) {
        Stack<Node_BT> st = new Stack<>();
        Node_BT temp = Node;
        Node_BT q = null;
        List<Integer> res = new ArrayList<>();
        while (temp != null || !st.isEmpty()) {
            if (temp != null) {
                st.push(temp);
                res.add(temp.data);
                temp = temp.lchild;
            } else {
                q = st.peek().rchild;
                if (q == null) {
                    q = st.pop();
                    while (!st.isEmpty() && st.peek().rchild == q) {
                        q = st.pop();
                    }
                } else {
                    temp = q;
                }
            }
        }
        System.out.println(res);
    }
}
