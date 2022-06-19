package com.company.doubly_linked_list;

public class main_doubly_linked_list {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        doubly_link_list dll = new doubly_link_list(arr);
        dll.display_dll();
//        dll.insert_beg(5);
        System.out.println(" ");
//        dll.reverse_dll();
//        dll.display_dll();
//        System.out.println(" ");
//        dll.reverse_dll();
//        dll.insert_end(50);
        dll.display_dll();
        dll.delete_last();
        System.out.println(" ");
        dll.display_dll();


    }
}
