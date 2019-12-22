package com.chaexsy.practise.leetcode.linkedlist.exercises;

import java.util.Stack;

/**
 * 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author Chaexsy 2019-12-22 15:48
 */
public class PalindromeLinkedList {
    /**
     * 解法1：双指针
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean isPalindrome(ListNode head) {
        boolean result = true;

        int size = 0;
        ListNode cur = head;
        while (cur!=null){
            cur = cur.next;
            size++;
        }

        ListNode first = head;
        ListNode second = head;
        int index=0;
        while (second != null){
            if(index >= size/2){
                if(first.val != second.val){
                    result = false;
                    break;
                }
                first = first.next;
            }

            second = second.next;
            index++;
        }

        return result;
    }

    /**
     * 解法2：栈
     * 利用栈后进先出的特性和原链表做比较
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean isPalindrome2(ListNode head) {
        boolean result = true;

        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while (!stack.isEmpty()){
            if(stack.pop().val != cur.val){
                result = false;
                break;
            }
            cur = cur.next;
        }

        return result;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(1);
        head.next.next.next.next = new  ListNode(2);

        LinkListUtil.printLinkList("LinkList: ", head);
        System.out.println("是否是回文链表：" + new PalindromeLinkedList().isPalindrome2(head));
    }
}
