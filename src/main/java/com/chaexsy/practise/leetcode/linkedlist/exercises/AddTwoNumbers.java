package com.chaexsy.practise.leetcode.linkedlist.exercises;

import java.util.Stack;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Chaexsy 2020-01-01 10:34
 */
public class AddTwoNumbers {
    /**
     * 解法1
     * 从头遍历链表，两两相加，超出10就进位
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        boolean carryFlag = false;
        while (l1 != null || l2 != null){
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;
            int sum = s1 + s2;
            if(carryFlag){
                sum += 1;
                carryFlag = false;
            }
            if(sum >= 10){
                sum -= 10;
                carryFlag = true;
            }

            result.next = new ListNode(sum);
            result = result.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carryFlag){
            result.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new  ListNode(4);
//        l1.next.next = new  ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new  ListNode(9);
//        l2.next.next = new  ListNode(4);

        LinkListUtil.printLinkList("LinkList: ", new AddTwoNumbers().solution(l1, l2));
    }
}
