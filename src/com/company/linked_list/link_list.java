package com.company.linked_list;

public class link_list {
    public Node head;

    link_list() {
        head = null;
    }

    link_list(int[] array) {
        if (array.length == 0) {
            head = null;
            return;
        }
        Node temp = new Node(array[0]);
        head = temp;
        Node last = head;
        for (int i = 1; i < array.length; i++) {
            temp = new Node(array[i]);
            last.next = temp;
            last = temp;
        }

    }

    public void insert_beg(int number) {
        Node temp = new Node(number);
        if (head == null) {
            head = temp;
            return;
        }
        temp.next = head;
        head = temp;
        return;
    }

    public void display_ll() {
        Node curr = head;
        System.out.print("[ ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" ");
            curr = curr.next;
        }
        System.out.print("]");
    }

    public void recursive_trav(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data);
        System.out.print(" ");
        recursive_trav(head.next);
    }

    public void insert_end(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node temp = new Node(data);
        curr.next = temp;
    }

    public Node pop_beg() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public Node pop_end() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            Node temp = head;
            head = null;
            return temp;
        }
        Node p = head;
        Node q = head.next;
        while (q.next != null) {
            p = q;
            q = q.next;
        }
        p.next = null;
        return q;
    }

    public void del_last() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return;
    }

    public void insert_at_pos(int pos, int data) {
        Node temp = new Node(data);
        if (pos == 1) {
            temp.next = head;
            head = temp;
            return;
        }
        Node curr = head;
        for (int i = 0; i < pos - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        temp.next = curr.next;
        curr.next = temp;
        return;
    }

    public int iterative_search(int data) {
        Node curr = head;
        int pos = 0;
        while (curr != null) {
            if (curr.data == data) {
                return pos + 1;
            }
            curr = curr.next;
            pos += 1;
        }
        return -1;
    }

    public int recursive_search(Node head_node, int data) {
        if (head_node == null) {
            return -1;
        }
        if (head_node.data == data) {
            return 1;
        } else {
            int res = recursive_search(head_node.next, data);
            if (res == -1) {
                return -1;
            } else {
                return res + 1;
            }
        }
    }

    public void delete_pos(int pos) {
        if (head == null) {
            return;
        }
        if (pos == 1) {
            head = head.next;
            return;
        }
        int i = 0;
        Node curr = head;
        for (; i < pos - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        curr.next = curr.next.next;
        return;
    }

    public Node recursive_rev(Node first) {
        if (first == null || first.next == null) {
            return first;
        }
        Node temp = recursive_rev(first.next);
        first.next.next = first;
        first.next = null;
        return temp;
    }

    public void sorted_insert(int data) {
        Node temp = new Node(data);
        Node curr = head;
        if (head == null) {
            head = temp;
            return;
        }
        while (curr.next != null && curr.next.data < data) {
            curr = curr.next;
        }
        if (curr == head) {
            temp.next = head;
            head = temp;
            return;
        }
        temp.next = curr.next;
        curr.next = temp;
        return;
    }

    public int nth_node_end(int n) {
        Node dummy = new Node();
        dummy.next = head;
        Node slow = dummy;
        Node fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public void iterative_reverse() {
        Node p = null;
        Node q = head;
        while (q != null) {
            Node temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head = p;
    }

    public void remove_dups_sorted_ll() {
        Node p = head;
        Node q = head;
        while (q.next != null) {
            if (p.data == q.data) {
                while (p.data == q.data && q.next != null) {
                    q = q.next;
                }
                p.next = q;
            } else {
                p = q;
                q = q.next;
            }
        }
        if (p.data == q.data) {
            p.next = null;
        }
    }

    public Node reverse_k_groups(Node head, int k) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count += 1;
        }
        if (next != null) {
            Node rest_head = reverse_k_groups(next, k);
            head.next = rest_head;
        }
        return prev;
    }

    public void iterative_rev_k_groups(int k) {
        Node curr = this.head;
        boolean firstPass = true;
        Node prevFirst = null;
        while (curr != null) {
            int count = 0;
            Node first = curr;
            Node prev = null;
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count += 1;
            }
            if (firstPass) {
                this.head = prev;
                firstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
    }
}
