package com.company.Heap;

import com.company.Linked_List.LinkedListMiddleNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    //Q-215: Kth largest Element in an Array (Top K 问题)
    //method 1: sorting (O(nlogn))
    //method 2: Max Heap (O(n+klogn))
    //method 3: Min Heap (O(nlogk))
    public int fingKthlargest(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : nums){
            if (heap.size() < k || x >= heap.peek()){
                heap.offer(x);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
    //Q-23:Merge K Sorted Lists
    // K pointers
    //Method-1: Linear Scan O(k)
    //Method-2: Simple Sorting O(klogk)
    //Method-3: Min Heap O(logk) 总时间 O(nlogK)
    static Comparator<LinkedListMiddleNode.ListNode> cmp = new Comparator<LinkedListMiddleNode.ListNode>() {
        public int compare(LinkedListMiddleNode.ListNode e1, LinkedListMiddleNode.ListNode e2) {
            return e1.val - e2.val;
        }
    };
    public LinkedListMiddleNode.ListNode mergeKLists(LinkedListMiddleNode.ListNode[] lists){
        //定义comparator：https://www.cnblogs.com/wei-jing/p/10806236.html
        PriorityQueue<LinkedListMiddleNode.ListNode> heap = new PriorityQueue<>(cmp);
        for (LinkedListMiddleNode.ListNode list : lists){
            if (list != null){
                heap.offer(list);
            }
        }
        //result是结果，cur代表添加的尾位置。
        LinkedListMiddleNode.ListNode result = new LinkedListMiddleNode.ListNode(0), cur = result;
        while (!heap.isEmpty()) {
            LinkedListMiddleNode.ListNode top = heap.poll();//弹出堆顶元素。
            cur.next = top;//将弹出元素添加到result后
            cur = cur.next;//将cur移动到result尾
            if (top.next != null) {
                heap.offer(top.next);
            }
        }
        return result.next;

    }
}
