package com.company;
//Adelson-Velskii and Landis or Self-balanceing tree

public class AVL {
    class Node{
        int val,height;
        Node left,right;
        Node (int d){
            val=d;
            height=1;
        }
    }
    Node root;

    int height(Node N){
        if(N==null) return 0;
        return N.height;
    }

    /*  z                   z
       / \                 / \
      t1  y      rR       t1  x
         / \    ---->        / \
        x   t4  <----       t2  y
       / \        lR           / \
      t2  t3                  t3  t4
     */
    Node rightRotate(Node y){
        Node x=y.left;
        Node t3=x.right;
        x.right=y;
        y.left=t3;
        y.height=Math.max(height(y.left),height(y.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    Node leftRotation(Node x){
        Node y=x.right;
        Node t3=y.left;
        y.left=x;
        x.right=t3;
        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(y.left),height(y.right))+1;
        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node,int val){
        if(node==null){
            return (new Node(val));
        }
        if(val<node.val){
            node.left=insert(node.left,val);
        }else if(val> node.val){
            node.right=insert(node.right,val);
        }else{
            return node;
        }
        node.height=1+Math.max(height(node.left),height(node.right));
        int balance=getBalance(node);
        if(balance>1 && val<node.left.val){
            return rightRotate(node);
        }
        if(balance<-1 && val>node.right.val){
            return leftRotation(node);
        }
        if(balance>1 && val>node.left.val){
            node.left=leftRotation(node.left);
            return rightRotate(node);
        }
        if(balance<-1 && val<node.right.val){
            node.right=rightRotate(node.right);
            return leftRotation(node);
        }
        return node;
    }

    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    Node  deleteNode (Node root,int val){
        if(root==null) return root;
        if(val< root.val){
            root.left=deleteNode(root.left,val);
        } else if (val>root.val) {
            root.right=deleteNode(root.right,val);
        }else{
            if(root.left==null || root.right==null){
                Node temp=null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if(temp==null){
                    temp=root;
                    root=null;
                }else{
                    root=temp;
                }
            }else{
                Node temp=minValueNode(root.right);
                root.val=temp.val;
                root.right=deleteNode(root.right,temp.val);
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if(balance>1 && getBalance(root.left)>=0){
            return rightRotate(root);
        }
        if(balance<-1 && getBalance(root.right)<=0){
            return leftRotation(root);
        }
        if(balance>1 && getBalance(root.left)<0){
            root.left=leftRotation(root.left);
            return rightRotate(root);
        }
        if(balance<-1 && getBalance(root.right) > 0){
            root.right=rightRotate(root.right);
            return leftRotation(root);
        }
        return root;
    }

    void preOrder(Node node){
        if (node != null) {
            System.out.print(node.val + "->");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL tree=new AVL();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        tree.preOrder(tree.root);
        System.out.println();
        tree.deleteNode(tree.root,40);
        tree.preOrder(tree.root);
    }
}
