package com.chaexsy.practise.leetcode.linkedlist.exercises;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author yusijia 2019-12-15 19:42
 * @since v.0.1
 */
public class IntersectLinkList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 解法1（暴力双指针双循环）
     *
     * 双重循环遍历，找到第一个相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;

        while (pointA != null){
            ListNode pointB = headB;

            while (pointB != null){
                if(pointA == pointB){
                    return pointA;
                }
                pointB = pointB.next;
            }
            pointA = pointA.next;
        }


        return null;
    }

    /**
     * 解法2（Set法）
     *
     * 先遍历链表A，把链表A元素存入Set。
     * 再遍历链表B，判断B是否在Set中，第一个在Set中的元素就是交点。
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        return null;
    }


    /**
     * 解法3
     *
     * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        ListNode tailA = null, tailB = null;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;

            if(pA.next == null){
                tailA = pA;
            }
            if(pB.next == null){
                tailB = pB;
            }
            // 相交链表的尾部一定相同，如果尾部不同说明不是相交链表，直接返回
            if(tailA != null && tailB !=null && tailA != tailB){
                return  null;
            }
        }

        return pA;
    }
}
