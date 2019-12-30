package com.chaexsy.practise.leetcode.linkedlist.exercises;

/**
 * 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author Chaexsy 2019-12-25 23:32
 */
public class MergeLinklist {
    /**
     * 解法1 交替连接，不能保证合并后的链表也是有序的
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = l1;

        ListNode temp1 = l1.next;
        ListNode temp2 = null;
        l1.next = l2;
        l1 = l1.next;
        boolean tempFlag = false;

        while (l1 != null){
            if(!tempFlag){
                temp2 = l1.next;
                l1.next = temp1;
            }else{
                temp1 = l1.next;
                l1.next = temp2;
            }

            l1 = l1.next;
            tempFlag = !tempFlag;
        }

        return head;
    }

    /**
     * 解法1 交替连接，不能保证合并后的链表也是有序的
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode front;
        ListNode back;
        if(l1.val <= l2.val){
            front = l1;
            back = l2;
        }else {
            front = l1;
            back = l2;
        }
        ListNode temp;
        ListNode head = front;
        front = front.next;
        while (front != null){
            if(front.val >= back.val){
                temp = front.next;
                front.next = back;
                back = temp;
            }
            if(front.next == null && back != null){
                front.next = back;
                break;
            }
            front = front.next;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new  ListNode(5);
        l1.next.next = new  ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new  ListNode(3);
        l2.next.next = new  ListNode(4);
        LinkListUtil.printLinkList("LinkList: ", new MergeLinklist().mergeTwoLists2(l1, l2));
    }
}
