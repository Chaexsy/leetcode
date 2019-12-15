package com.chaexsy.practise.leetcode.linkedlist.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * @author Chaexsy 2019-12-14 16:55
 */
public class CircleInLinkedList2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode cur = head;
        visited.add(cur);
        while (cur.next != null){
            if(visited.contains(cur)){
                return cur;
            }
            cur = cur.next;
            visited.add(cur);
        }

        return null;
    }

    public static void main(String[] args){

    }
}
