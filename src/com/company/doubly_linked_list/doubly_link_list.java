package com.company.doubly_linked_list;

import com.company.linked_list.Node;

public class doubly_link_list {
    Node_dll head;
    doubly_link_list(){
        head=null;
    }
    doubly_link_list(int []array){
        if(array.length==0){
            head=null;
        }
        else {
            head = new Node_dll(array[0]);
            Node_dll curr=head;
            for(int i=1;i<array.length;i++){
                Node_dll temp=new Node_dll(array[i]);
                temp.prev=curr;
                curr.next=temp;
                curr=temp;
            }
        }
    }
    public void display_dll(){
        Node_dll curr=head;
        System.out.print("[ ");
        while(curr!=null){
            System.out.print(curr.data);
            System.out.print(" ");
            curr=curr.next;
        }
        System.out.print("]");
    }
    public void insert_beg(int data_inserted){
        Node_dll temp=new Node_dll(data_inserted);
        temp.next=this.head;
        if(head!=null){
            this.head.prev = temp;
        }
        this.head=temp;
    }

    public void reverse_dll(){
        if(head==null|| head.next == null){
            return ;
        }
        Node_dll curr=head;
        Node_dll p=head;
        while(curr!=null){
            Node_dll temp=curr.next;
            if(temp==null){
                head=curr;
            }
            curr.next=curr.prev;
            curr.prev=temp;
            curr=temp;
        }
//        head=p;

    }
    public void insert_end(int data){
        if(head==null){
            head=new Node_dll(data);
            return;
        }
        Node_dll curr=head;
//        Node_dll p=curr;
        while(curr.next!=null){
//            p=curr;
            curr=curr.next;
        }
        Node_dll temp=new Node_dll(data);
        curr.next=temp;
        temp.prev=curr;
    }

    public int delete_head(){
        if(head==null){
            return -111;
        }
        int temp=head.data;
        if(head.next==null){
            head=null;
            return temp;
        }
        head=head.next;
        head.prev=null;
        return temp;
    }
    public void delete_last(){
        if(head==null||head.next==null){
        head=null;
        return ;
        }
        Node_dll curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        Node_dll temp=curr.prev;
        curr.prev=null;
        temp.next=null;
    }
}
