package com.company.Linked_List;

public class LinkedListMiddleNode {
    public class ListNode{
        int val;
        ListNode next;
    }
    public ListNode MiddleNode(ListNode head){
        ListNode i = head, j = head;
        while(j != null && j.next != null){
            i = i.next;
            j = j.next.next;
        }
        return i;
    }
}
