package com.chaexsy.practise.leetcode.linkedlist.exercises;

import java.util.Stack;

/**
 * 扁平化多级双向链表
 *
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 *
 * 示例:
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *
 * @author Chaexsy 2020-01-01 11:43
 */
public class Flatten {
    /**
     * 解法1：
     * 遍历链表
     * 当发现子节点分叉时，将next节点压入栈，将子节点设置为next节点
     * 遍历完成后，将栈中的链表出栈，拼接到原链表上
     *
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public Node solution(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();

        while (cur != null && (cur.next != null || cur.child != null)){
            if(cur.child != null){
                stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }else {
                cur.next.prev = cur;
                cur = cur.next;
            }
        }

        while (!stack.isEmpty()){
            cur.next = stack.pop();

            while (cur.next != null){
                cur.next.prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 解法2：
     * 深度优先搜索
     *
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    public Node solution2(Node head) {
        if (head == null) return head;
        // 伪造一个头节点，确保 prev 指针永远不会是null
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    /**
     *  return the tail of the flatten list
     */
    public Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        // the curr.next would be tempered in the recursive function
        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        node1.next.next.next.next.next = new Node(6);

        Node node2 = new Node(7);
        node2.next = new Node(8);
        node2.next.next = new Node(9);
        node2.next.next.next = new Node(10);

        Node node3 = new Node(11);
        node3.next = new Node(12);

        node1.next.next.child = node2;
        node2.next.child = node3;

        LinkListUtil.printLinkList("before:", node1);
        System.out.println();
        LinkListUtil.printLinkList("after:", new Flatten().solution(node1));
    }
}
