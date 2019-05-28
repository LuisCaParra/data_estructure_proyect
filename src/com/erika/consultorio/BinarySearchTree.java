package com.erika.consultorio;

public class BinarySearchTree {
    //lass containing left and right child of current node and key value
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    //calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    //A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {

        //If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        //Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        //return the (unchanged) node pointer
        return root;
    }

    //calls InorderRec()
    void inorder()  {
        inorderRec(root);
    }

    //inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

}
