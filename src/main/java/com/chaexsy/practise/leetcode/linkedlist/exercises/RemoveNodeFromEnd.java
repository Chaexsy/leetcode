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
