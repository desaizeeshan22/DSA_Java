package com.company.Trees;

import com.company.linked_list.Node;

import java.util.*;


public class main_tree {
    public static void main(String[] args) {
//        Node_BT root = new Node_BT(10);
//        root.lchild = new Node_BT(20);
//        root.rchild = new Node_BT(30);
//        root.lchild.lchild = new Node_BT(5);
//        root.lchild.rchild = new Node_BT(25);
//        root.rchild.rchild = new Node_BT(35);
//        root.rchild.lchild = new Node_BT(8);
//        InorderTraversal(root);
//        System.out.println(" ");
//        iterativeInorderTraversal(root);
//        System.out.println(" ");
//        PreorderTraversal(root);
//        PostorderTraversal(root);
//        ArrayList<Integer> result = iterativePostorderTraversal(root);
//        System.out.println(result);
//        System.out.println(iterativePreorderTraversal(root));
//        System.out.println(heightTree(root));
//        System.out.println(iterativeHeight(root));
//        Tree tree = new Tree();
//        tree.createTree();
//        tree.inOrderTraversal(tree.getRoot());
//        tree.preOrderTraversal(tree.getRoot());
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(20, 40, 15, 25, 35, 50));
        tree.root = tree.recursiveInsert(tree.root, 30);
        for (int elem : list) {
            tree.recursiveInsert(tree.root, elem);
        }
        System.out.println(tree.SortedElements());
        System.out.println(tree.DeleteNode(tree.root,35));
        System.out.println(tree.SortedElements());
//        System.out.println(tree.iterativeHeight());
//        System.out.println(tree.height(tree.root));
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
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        System.out.print(" ");
        PreorderTraversal(root.lchild);
        PreorderTraversal(root.rchild);
    }

    public static void PostorderTraversal(Node_BT root) {
        if (root == null) {
            return;
        }
        PostorderTraversal(root.lchild);
        PostorderTraversal(root.rchild);
        System.out.print(root.data);
        System.out.print(" ");
    }

    public static ArrayList<Integer> iterativePostorderTraversal(Node_BT root) {
        Stack<Node_BT> st = new Stack<Node_BT>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node_BT curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.lchild;
            } else {
                Node_BT temp = st.peek().rchild;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    result.add(temp.data);
                    while (!st.isEmpty() && st.peek().rchild == temp) {
                        temp = st.peek();
                        st.pop();
                        result.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> iterativePreorderTraversal(Node_BT root) {
        Stack<Node_BT> st = new Stack<Node_BT>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node_BT curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                result.add(curr.data);
                curr = curr.lchild;
            } else {
                curr = st.pop();
                curr = curr.rchild;
            }
        }
        return result;
    }

    public static int heightTree(Node_BT root) {
        if (root == null || (root.lchild == null && root.rchild == null)) {
            return 0;
        }
        return Integer.max(heightTree(root.lchild), heightTree(root.rchild)) + 1;
    }

    public static int iterativeHeight(Node_BT root) {
        int maxHeight = 0;
        int height = 0;
        Stack<Node_BT> st = new Stack<>();
        Node_BT curr = root;
        while (!st.isEmpty() || curr != null) {
            maxHeight = Math.max(height, maxHeight);
            if (curr != null) {
                st.push(curr);
                height += 1;
                curr = curr.lchild;
            } else {
                Node_BT temp = st.peek().rchild;
                if (temp == null) {
                    temp = st.pop();
                    height -= 1;
                    while (!st.isEmpty() && st.peek().rchild == temp) {
                        temp = st.pop();
                        height -= 1;
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return maxHeight - 1;
    }

}
