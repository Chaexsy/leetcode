package com.chaexsy.practise.leetcode.linkedlist.exercises;


/**
 * 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author yusijiayf1 2019-12-16 11:17
 */
public class RemoveNodeInLinkList {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 遍历所有节点，删除匹配节点
        ListNode prev = dummyNode;
        while (prev != null){
            ListNode cur = prev.next;
            if(cur != null && cur.val == val){
                prev.next = cur.next;
            }else{
                prev = prev.next;
            }
        }

        return dummyNode.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(6);
        head.next.next.next = new  ListNode(3);
        head.next.next.next.next = new  ListNode(4);
        head.next.next.next.next.next = new  ListNode(5);
        head.next.next.next.next.next.next = new  ListNode(6);

//        ListNode head = new ListNode(1);
//        head.next = new  ListNode(1);
//        head.next.next = new  ListNode(1);

        LinkListUtil.printLinkList("Before remove: ", head);
        ListNode newHead = new RemoveNodeInLinkList().removeElements(head, 6);
        LinkListUtil.printLinkList("After remove: ",newHead);
    }
}
