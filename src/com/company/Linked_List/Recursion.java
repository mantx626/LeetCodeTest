package com.company.Linked_List;

public class Recursion {
    public class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode reversedhead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedhead;
    }
}
