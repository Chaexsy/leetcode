package com.chaexsy.practise.leetcode.linkedlist.exercises;

import java.util.List;

/**
 * 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author Chaexsy 2020-01-01 21:14
 */
public class RotateRight {
    /**
     * 解法1
     *
     * 1.找到队尾前面的节点 cur
     * 2.根据cur.next到队尾 tail
     * 3.cur.next设置为null，cur变成了队尾
     * 4.tail.next设置为head，1-4步把队尾转移到队首
     * 5.head = tail
     * 6.重复1-5 k次。
     *
     * 空间复杂度：O(1)
     * 时间复杂度：O(k*n)
     */
    public ListNode solution(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        for(int i=0; i<k; i++){
            ListNode cur = getNodeBeforeTail(head);
            ListNode tail = cur.next;
            cur.next = null;
            tail.next = head;
            head = tail;
        }

        return head;
    }

    private ListNode getNodeBeforeTail(ListNode node){
        ListNode cur = node;
        while (cur != null){
            if(cur.next != null && cur.next.next == null){
                break;
            }
            cur = cur.next;
        }

        return cur;
    }

    /**
     * 解法2：
     *
     * 先算出长度
     * 再移动指针
     *
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     */
    public ListNode solution2(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        // 1.计算链表长度
        int size = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            size++;
        }

        // 2.计算旋转后链表的分裂点
        int index = (k < size) ? (size - k) : (size - k % size);
        cur = head;
        for(int i=1; i<index; i++){
            cur = cur.next;
        }

        // 3.找到分裂点
        ListNode target = cur.next;
        if(target != null){
            // 4.分裂点右侧的链表，移动到队尾
            ListNode tail = target;
            while (tail.next != null){
                tail = tail.next;
            }
            // 5.cur为分裂点左侧链表的队尾
            cur.next = null;
            // 6.分裂点右侧的链表拼接到链表左侧
            tail.next = head;
            // 7.刷新head为拼接后的链表
            head = target;
        }

        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);

        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);

        LinkListUtil.printLinkList("before: ", l1);
        LinkListUtil.printLinkList("after: ", new RotateRight().solution2(l1, 4));
    }
}
