package com.company.linked_list;

public class main_linked_list {
    public static void main(String [] args){
        link_list ll=new link_list();
        ll.insert_beg(50);
        ll.insert_beg(40);
        ll.insert_beg(30);
        ll.insert_beg(20);
        ll.insert_beg(10);
////        ll.display_ll();
//        Node newHead=ll.reverse_k_groups(ll.head,3);
//        ll.head=newHead;
        ll.iterative_rev_k_groups(3);
        ll.display_ll();
//        ll.recursive_trav(ll.head);
//        ll.insert_end(10);
//        ll.insert_end(20);
//        ll.insert_end(20);
//        ll.insert_end(30);
//        ll.insert_end(30);
//        ll.insert_end(30);
//        ll.insert_end(40);
//        ll.insert_end(40);
//        ll.insert_end(40);
//        ll.insert_end(50);
//        ll.insert_end(50);
//        ll.delete_pos(2);
//        ll.pop_beg();
//        ll.pop_beg();
//        ll.pop_beg();
//        ll.pop_end();
//        ll.pop_end();
//        ll.display_ll();
//        ll.insert_at_pos(2,40);
//        ll.insert_at_pos(1,50);
//        System.out.println(" ");
//        System.out.println(ll.iterative_search(40));
//        System.out.println(ll.recursive_search(ll.head,20));
//        Node first=ll.recursive_rev(ll.head);
//        display(first);
//        ll.sorted_insert(5);
//        ll.iterative_reverse();
//        ll.remove_dups_sorted_ll();
//        ll.display_ll();
//        System.out.println(ll.nth_node_end(2));

    }
    public static void display(Node head){
        Node curr=head;
        System.out.print("[ ");
        while(curr!=null){
            System.out.print(curr.data);
            System.out.print(" ");
            curr=curr.next;
        }
        System.out.print("]");
    }
}
