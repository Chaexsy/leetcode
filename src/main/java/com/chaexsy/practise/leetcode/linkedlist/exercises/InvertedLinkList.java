package com.chaexsy.practise.leetcode.linkedlist.exercises;

/**
 * 反转链表
 * 反转一个单链表。
 *
 * @author yusijiayf1 2019-12-16 10:45
 */
public class InvertedLinkList {
    /**
     * 解法1
     * 遍历链表，每遍历一个节点，就把这个节点设置为头节点，当前头节点的next指向当前节点的下一个节点
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = head;
        while (head.next != null){
            ListNode next = head.next;
            ListNode nextNext = next.next;

            next.next = newHead;
            head.next = nextNext;
            newHead = next;
        }

        return newHead;
    }

    /**
     * 解法2
     * 遍历链表，把链表每个节点next设置为空，并压入栈
     * 出栈，重新组一个链表
     */
    public ListNode reverseList2(ListNode head) {
        return null;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);

        LinkListUtil.printLinkList("Before reverse: ", head);
        ListNode newHead = new InvertedLinkList().reverseList(head);
        LinkListUtil.printLinkList("After reverse: ",newHead);
    }
}
