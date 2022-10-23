package com.company.Trees;

public class AVLTree {
    private Node_AVL root;

    public Node_AVL Rinsert(Node_AVL node, int data) {
        if (node == null) {
            node = new Node_AVL(data);
            node.height = height(node);
            return node;
        }
        Node_AVL temp = node;
        if (data < temp.data) {
            temp.lchild = Rinsert(temp.lchild, data);
        } else if (data > temp.data) {
            temp.rchild = Rinsert(temp.rchild, data);
        } else {
            System.out.println(String.format("Node with data %d ", data));
            return null;
        }
        node.height = height(node);
        if (balanceFactor(node) == 2 && balanceFactor(node.lchild) == 1) {
            return LL_Rotation(node);
        } else if (balanceFactor(node) == 2 && balanceFactor(node.lchild) == -1) {
            return LR_Rotation(node);
        } else if (balanceFactor(node) == -2 && balanceFactor(node.rchild) == -1) {
            return RR_Rotation(node);
        } else if (balanceFactor(node) == -2 && balanceFactor(node.rchild) == 1) {
            return RL_Rotation(node);
        }
        return node;
    }

    public Node_AVL LL_Rotation(Node_AVL node) {
        Node_AVL nodeLchild = node.lchild;
        Node_AVL nodeLRchild = node.lchild.rchild;
        nodeLchild.rchild = node;
        node.lchild = nodeLRchild;
        node.height = height(node);
        nodeLchild.height = height(nodeLchild);
        if (root == node) {
            root = nodeLchild;
        }
        return nodeLchild;
    }

    public Node_AVL RR_Rotation(Node_AVL node) {
        Node_AVL nodeRchild = node.rchild;
        Node_AVL nodeRLchild = node.rchild.lchild;
        nodeRchild.lchild = node;
        node.rchild = nodeRLchild;
        node.height=height(node);
        nodeRchild.height = height(nodeRchild);
        if (root == node) {
            root = nodeRchild;
        }
        return nodeRchild;
    }

    public Node_AVL LR_Rotation(Node_AVL node) {
        Node_AVL nodeLchild = node.lchild;
        Node_AVL nodeLRchild = node.lchild.rchild;
        nodeLchild.rchild = nodeLRchild.lchild;
        node.lchild = nodeLRchild.rchild;
        nodeLRchild.lchild = nodeLchild;
        nodeLRchild.rchild = node;
        node.height=height(node);
        nodeLchild.height=height(nodeLchild);
        nodeLRchild.height=height(nodeLRchild);
        if (root == node) {
            root = nodeLRchild;
        }
        return nodeLRchild;
    }

    public Node_AVL RL_Rotation(Node_AVL node) {
        Node_AVL nodeRchild = node.rchild;
        Node_AVL nodeRLchild = node.rchild.lchild;
        nodeRchild.lchild = nodeRLchild.rchild;
        node.rchild = nodeRLchild.lchild;
        nodeRLchild.lchild = node;
        nodeRLchild.rchild = nodeRchild;
        node.height=height(node);
        nodeRchild.height=height(nodeRchild);
        nodeRLchild.height=height(nodeRLchild);
        if (root == node) {
            root = nodeRLchild;
        }
        return nodeRLchild;
    }

    private int balanceFactor(Node_AVL node) {
        int heightLtree = 0;
        int heightRtree = 0;
        if (node != null && node.lchild != null) {
            heightLtree = node.lchild.height;
        }
        if (node != null && node.rchild != null) {
            heightRtree = node.rchild.height;
        }
        return heightLtree - heightRtree;
    }

    private Integer height(Node_AVL node) {
        if (node == null) {
            return 0;
        }
        if ((node.lchild == null && node.rchild == null)) {
            return 1;
        }
        return Math.max(height(node.lchild), height(node.rchild)) + 1;
    }
}

