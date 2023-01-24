package com.company;

public class BST {
    public class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    static Node root;
    BST(){
        root=null;
    }


    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public Node search(Node root,int value){
        if(root==null || root.data==value){
            return root;
        }
        if(root.data>value){
            return search(root.left,value);
        }
        return search(root.right,value);
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }


    //    Inorder=> left->root->right
    public void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+"->");
        inorder(root.right);
    }

//    Preorder
    public void preorder(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+"->");
        preorder(root.left);
        preorder(root.right);
    }

//    Postorder
public void postorder(Node root){
    if(root==null) {
        return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data+"->");
}
    public void insertTree(int val){
        root=insert(root,val);
    }
    public Node searchTree(int val) {
        return search(root, val);
    }
    void deleteKey(int key) { root = deleteRec(root, key); }
    public void inOrder(){
        inorder(root);
    }
    public void preOrder(){
        preorder(root);
    }
    public void postOrder(){
        postorder(root);
    }

    public static void main(String[] args) {
        BST tree1 = new BST();

        tree1.insertTree(6);
        tree1.insertTree(4);
        tree1.insertTree(8);
        tree1.insertTree(3);
        tree1.insertTree(5);
        tree1.insertTree(7);
        tree1.insertTree(9);
        tree1.deleteKey(5);
        tree1.inOrder();
        System.out.println();
        tree1.preOrder();
        System.out.println();
        tree1.postOrder();
        System.out.println();
    }
}
