package com.company.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    public Node_BT root;

    public BinarySearchTree() {

    }

    public void insert(int Data) {
        if (root == null) {
            root = new Node_BT(Data);
            return;
        }
        Node_BT p, q;
        p = q = root;
        while (q != null) {
            p = q;
            if (Data > q.data) {
                q = q.rchild;
            } else if (Data < q.data) {
                q = q.lchild;
            } else {
                System.out.println(String.format("Node %s already exists in the tree", q.data));
                return;
            }
        }
        if (Data > p.data) {
            p.rchild = new Node_BT(Data);
        }
        if (Data < p.data) {
            p.lchild = new Node_BT(Data);
        }
        return;
    }

    public Node_BT recursiveInsert(Node_BT root, int Data) {
        Node_BT temp = null;
        if (root == null) {
            temp = new Node_BT(Data);
            return temp;
        }
        if (Data > root.data) {
            root.rchild = recursiveInsert(root.rchild, Data);
        } else if (Data < root.data) {
            root.lchild = recursiveInsert(root.lchild, Data);
        }
        return root;
    }

    public List<Integer> SortedElements() {
        List<Integer> res = new ArrayList<>();
        Stack<Node_BT> st = new Stack<>();
        Node_BT temp = root;
        while (temp != null || !st.isEmpty()) {
            if (temp != null) {
                st.push(temp);
                temp = temp.lchild;
            } else {
                temp = st.pop();
                res.add(temp.data);
                temp = temp.rchild;
            }
        }
        return res;
    }

    public int height(Node_BT root) {
        if (root == null || (root.lchild == null && root.rchild == null)) {
            return 0;
        }
        return Math.max(height(root.lchild), height(root.rchild)) + 1;

    }

    public int iterativeHeight() {
        Stack<Node_BT> st = new Stack<>();
        int height = 0;
        int maxHeight = 0;
        Node_BT temp = root;
        while (!st.isEmpty() || temp != null) {
            maxHeight = Math.max(height, maxHeight);
            if (temp != null) {
                st.push(temp);
                height += 1;
                temp = temp.lchild;
            } else {
                temp = st.pop();
                height -= 1;
                temp = temp.rchild;
            }
        }
        return maxHeight - 1;
    }

    public Node_BT DeleteNode(Node_BT node, int key) {
        if (node == null || (node.lchild == null && node.rchild == null)) {
            if(node==root){
                root=null;
            }
            return null;
        }
        if (key > node.data) {
            node.rchild = DeleteNode(node.rchild, key);
        } else if (key < node.data) {
            node.lchild = DeleteNode(node.lchild, key);
        } else {
            if (node.lchild!=null&&height(node.lchild) < height(node.rchild)) {
                Node_BT InorderPred = InorderPre(node.lchild);
                node.data = InorderPred.data;
                DeleteNode(InorderPred, key);
            } else {
                Node_BT InorderSuccessor = InorderSucc(node.rchild);
                node.data = InorderSuccessor.data;
                DeleteNode(InorderSuccessor, key);
            }
        }
        return node;
    }

    public Node_BT InorderPre(Node_BT node) {
        Node_BT temp = node;
        while (temp != null && temp.rchild != null) {
            temp = temp.rchild;
        }
        return temp;
    }

    public Node_BT InorderSucc(Node_BT node) {
        Node_BT temp = node;
        while (temp != null && temp.lchild != null) {
            temp = temp.lchild;
        }
        return temp;
    }
}
