package com.company;

public class Problems {
    private Node head;
    private Node tail;

    private int size;
    public Problems() {
        this.size = 0;
    }

    public void duplicates(){
        Node node =head;
        while(node.next!=null){
            if(node.value==node.next.value){
                node.next=node.next.next;
                size--;
            }else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
    }

    public static Problems merge(Problems first,Problems second){
       Node f=first.head;
       Node s= second.head;
       Problems ans=new Problems();
       while (f!=null && s!=null){
           if(f.value<s.value){
               ans.insertlast(f.value);
               f=f.next;
           }else{
               ans.insertlast(s.value);
               s=s.next;
           }
       }
       while (f!=null){
           ans.insertlast(f.value);
           f=f.next;
       }
       while (s!=null){
           ans.insertlast(s.value);
           s=s.next;
       }
       return  ans;
    }

    public void insertfirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertlast(int val){
        if(tail==null){
            insertfirst(val);
            return;
        }
       Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;
    }

    public boolean hasCycle(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public int CycleLength(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node temp=slow;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }

    public boolean isHappy(int n) {
       int slow=n;
       int fast=n;
       do{
           slow=findSq(slow);
           fast=findSq(findSq(fast));
       }while (slow!=fast);
       if(slow==1){
           return true;
       }
       return false;
    }
    private int findSq(int n){
        int l=0;
        while(n>=1){
            int c=n%10;
            l+=c*c;
            n=n/10;
        }
        return l;
    }

    public Node detectCycle(Node head) {
      int length=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length=CycleLength(slow);
                break;
            }
        }
        if(length==0){
            return null;
        }
        Node f=head;
        Node s=head;
        while(length>0){
            s=s.next;
            length--;
        }
        while(f!=s){
            f=f.next;
            s=s.next;
        }
        return s;
    }

    public Node middleNode(Node head) {
      Node s=head;
      Node f=head;
      while (f!=null && f.next!=null){
          s=s.next;
          f=f.next.next;
      }
      return s;
    }

    public Node mergeTwoLists(Node f, Node s) {
        Node ans=new Node();
        Node tail=ans;
        while (f!=null && s!=null){
            if(f.value<s.value){
                tail.next=f;
                f=f.next;
                tail=tail.next;
            }else{
                tail.next=s;
                s=s.next;
                tail=tail.next;
            }
        }
        if (f!=null){
            tail.next=f;

        }
        if (s!=null){
            tail.next=s;

        }
        return  ans.next;
    }

    public Node getmid(Node head) {
        Node midPrev=null;
        while(head!=null && head.next!=null){
            if(midPrev==null){
                midPrev=head;
            }else{
                midPrev=midPrev.next;
            }
//            midPrev=(midPrev==null)  ? head : midPrev.next;      Inshort
            head=head.next.next;
        }
        Node mid=midPrev.next;
        midPrev.next=null;
        return mid;
    }

    public Node sortlist(Node head){
        if(head==null  || head.next==null){
            return head;
        }
        Node mid=middleNode(head);
        Node left=sortlist(head);
        Node right=sortlist(mid);
        return mergeTwoLists(left,right);
    }

    public Node get(int index){
        Node node =head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public void bubblesort(){
        bubblesort(size-1,0);
    }

    private void bubblesort(int row, int col) {
        if(row==0){
            return ;
        }
        if(col<row){
            Node first=get(col);
            Node second=get(col+1);
            if(first.value>second.value){
                if(first==head){
                    head=second;
                    first.next=second.next;
                    second.next=first;
                }else if(second==tail){
                    Node prev=get(col-1);
                    prev.next=second;
                    tail=first;
                    first.next=null;
                    second.next=tail;
                }else{
                    Node prev=get(col-1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;
                }
            }
            bubblesort(row,col+1);
        }else{
            bubblesort(row-1,0);
        }
    }

//    recursion reverse
    public void reverseRec(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        reverseRec(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    //without recurtion
    public Node reverse(Node head){
        if(head==null){
            return head;
        }
        Node prev=null;
        Node present=head;
        Node next=present.next;
        while (present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }

    public void reorderList(Node head) {
       if(head==null || head.next==null){
           return;
       }
       Node mid=middleNode(head);
       Node hs=reverse(mid);
       Node hf=head;
       while(hf!=null && hs!=null){
           Node temp=hf.next;
           hf.next=hs;
           hf=temp;
           temp=hs.next;
           hs.next=hf;
           hs=temp;
       }
       if(hf!=null){
           hf.next=null;
       }
    }

    public Node reverseBetween(Node head, int left, int right) {
      if(left==right){
          return head;
      }
      Node present=head;
      Node prev=null;
        for (int i = 0;present!=null && i < left-1; i++) {
            prev=present;
            present=present.next;
        }
        Node last=prev;
        Node newEnd=present;
        //reverse
        Node next=present.next;
        for (int i = 0;present!=null && i < right-left+1; i++) {
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=present;
        return head;
    }

    public Node reverseKGroup(Node head, int k) {
         if(k<=1 || head==null){
             return head;
         }
        Node present=head;
        Node prev=null;
        while(true){

            Node last=prev;
            Node newEnd=present;
            //reverse
            Node next=present.next;
            for (int i = 0;present!=null && i < k; i++) {
                present.next=prev;
                prev=present;
                present=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }
            newEnd.next=present;
            if(present==null){
                break;
            }
            prev=newEnd;
        }
            return head;

    }

    public Node reversealternateKGroup(Node head, int k) {
         if(k<=1 || head==null){
             return head;
         }
        Node present=head;
        Node prev=null;
        while(present!=null){

            Node last=prev;
            Node newEnd=present;
            //reverse
            Node next=present.next;
            for (int i = 0;present!=null && i < k; i++) {
                present.next=prev;
                prev=present;
                present=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }
            newEnd.next=present;
            if(present==null){
                break;
            }
            prev=newEnd;
            //skip k nodes
            for (int i = 0;present!=null &&  i < k; i++) {
                prev=present;
                present=present.next;
            }
        }
            return head;

    }

    public Node rotateRight(Node head, int k) {
        if(head==null || head.next==null || k<=0){
            return head;
        }
        Node last=head;
        int length=1;
        while(last.next!=null){
            last=last.next;
            length++;
        }
        last.next=head;
        int rot=k%length;
        int skip=length-rot;
        Node newlast=head;
        for(int i=0;i<skip-1;i++){
            newlast=newlast.next;
        }
        head=newlast.next;
        newlast.next=null;
        return head;
    }

    public boolean isPalindrome(Node head) {
         Node mid=middleNode(head);
         Node headsecond=reverse(mid);
         Node rereverse=headsecond;
         while(head!=null && headsecond!=null){
             if(head.value!= headsecond.value){
                 break;
             }
             head=head.next;
             headsecond=headsecond.next;
         }
         reverse(rereverse);
         if(head==null || headsecond==null){
             return true;
         }
         return false;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value + "->");
            temp=temp.next;
        }
        System.out.print("END\n");
    }


    private class  Node{
        private int value;
        private Node next;
        public Node(){

        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Problems list=new Problems();
        list.insertlast(1);
        list.insertlast(1);
        list.insertlast(2);
        list.duplicates();
        list.display();
    }
}
