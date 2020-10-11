package com.company.Linked_List;


public class LastkthNode {
    public LinkedListMiddleNode.ListNode lastkthNode(LinkedListMiddleNode.ListNode head, int k){
        LinkedListMiddleNode.ListNode i = head, j = head;
        for (int c = 0; c < k; c++){
            j = j.next;
        }
        while (j != null){
            i = i.next;
            j = j.next;
        }
        return i;
    }

}
