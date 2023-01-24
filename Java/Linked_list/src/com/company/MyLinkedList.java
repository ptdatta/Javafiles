package com.company;

public class MyLinkedList {
    Node head;
    Node tail;
    int size=0;
    public class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }

    public MyLinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public int get(int index) {
        Node node=head;
        for(int i=1;i<=index;i++){
            if(node.next!=null){
                node=node.next;
            }else{
                return -1;
            }
        }

        if(node!=null){
            return node.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void addAtTail(int val) {
        if(tail==null){
            addAtHead(val);
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
            return ;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        Node temp=head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(size==0){

        }
        else if(index<0 || index>=size){

        }
        else if(index==0){
            if(size==1){
                head=null;
                tail=null;
                size--;

            }
            else{
                head=head.next;
                size--;

            }
        }
        else if(index==size-1){
            Node temp=head;
            int i=0;
            while(i<size-2){
                temp=temp.next;
                i++;
            }
            temp.next=null;
            tail=temp;
            size--;
        }
        else{
            Node temp=head;
            Node nn=head;

            for(int i=0;i<index-1;i++){
                temp=temp.next;
                nn=nn.next;
            }
            nn=nn.next.next;
            temp.next=nn;
            size--;

        }
    }

    public static void main(String[] args) {
        MyLinkedList a=new MyLinkedList();
        a.addAtTail(1);
        a.addAtTail(3);
        System.out.println(a.get(1));
    }
}
