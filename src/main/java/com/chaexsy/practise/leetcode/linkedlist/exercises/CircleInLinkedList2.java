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

    /**
     * 解法1
     *
     * 遍历链表
     * 访问过一个节点，接放入已访问列表
     * 第一次遇到要访问的节点已经访问过的时候，就是环形链表尾连接到列表中的节点
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode cur = head;
        visited.add(cur);
        while (cur!=null){
            cur = cur.next;

            if(visited.contains(cur)){
                return cur;
            }

            visited.add(cur);
        }

        return null;
    }

    /**
     * 解法2：双指针
     *
     * 设链表共有 a+b个节点，其中 链表头部到链表入口 有 a 个节点（不计链表入口节点）， 链表环 有 b 个节点
     * 设两指针分别走了 f，s 步，则有：
     *
     * 第一次相遇时：
     * 1.fast 走的步数是slow步数的 2倍，即 f = 2s；
     * 2.fast 比 slow多走了n个环的长度，即 f = s + nb（ 解析： 双指针都走过a步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）
     * 以上两式相减得：f=2nb，s = nb，即fast和slow 指针分别走了 2n，n 个 环的周长 （注意： n 是未知数，不同链表的情况不同）。
     *
     * 分析：
     * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb（先走a步到入口节点，之后每绕1圈环（b步）都会再次到入口节点）。
     * 而目前，slow 指针走过的步数为nb步。因此，我们只要想办法让 slow 再走a步停下来，就可以到环的入口。
     * 但是我们不知道a的值，该怎么办？依然是使用双指针法。
     * 我们构建一个指针，此指针需要有以下性质：此指针和slow 一起向前走a步后，两者在入口节点重合。
     * 那么从哪里走到入口节点需要a步？答案是链表头部head。
     *
     * 双指针第二次相遇：
     * 第一次相遇后，把快指针移到链表头，快指针速度将为1（和慢指针相同）
     * 然后快慢指针同时走，它们相遇的地方就是环的入口
     *
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args){

    }
}
