package com.company.Linked_List;

public class LinkedListMiddleNode {
    public static class ListNode{
        public int val;
        public ListNode next;


        public ListNode(int i) {

        }
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
