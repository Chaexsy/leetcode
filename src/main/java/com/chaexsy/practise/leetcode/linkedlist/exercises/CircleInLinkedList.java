package com.chaexsy.practise.leetcode.linkedlist.exercises;

/**
 * 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author yusijia 2019-12-14 13:49
 * @since v.0.1
 */
public class CircleInLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while (slowNode != null && fastNode!= null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(slowNode == fastNode){
                hasCycle = true;
                break;
            }
        }

        return hasCycle;
    }
}
