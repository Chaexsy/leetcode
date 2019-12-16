package com.chaexsy.practise.leetcode.linkedlist.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * @author yusijia 2019-12-15 20:57
 * @since v.0.1
 */
public class RemoveNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 解法1
     *
     * 先遍历一遍链表，把链表节点放入哈希表，key为链表节点的序号，value为节点
     * 然后删除相应节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> visited = new HashMap<>(1024);

        ListNode node = head;
        int index = 0;
        while (node != null){
            visited.put(index, node);
            node = node.next;
            index++;
        }

        int deleteIndex = visited.size() - n;
        ListNode cur = visited.get(deleteIndex);
        ListNode prev = visited.get(deleteIndex-1);
        ListNode next = visited.get(deleteIndex+1);

        if(prev == null){
            // prev == null的时候表示要删除的是头节点
            head = next;
        }else{
            prev.next = next;
        }

        visited.remove(deleteIndex);

        if(visited.size() == 0){
            return null;
        }else{
            return head;
        }
    }

    /**
     * 第一个指针从列表的开头向前移动 n+1步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 n个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 n个结点。
     * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        new RemoveNodeFromEnd().removeNthFromEnd(head, 2);

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        new RemoveNodeFromEnd().removeNthFromEnd(head, 2);
    }
}
