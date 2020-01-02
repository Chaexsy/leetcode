package com.chaexsy.practise.leetcode.linkedlist.exercises;

/**
 * 带有一个子节点的双向链表
 *
 * @author Chaexsy 2020-01-01 11:47
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int x) {
        val = x;
    }

    public Node(int val, Node prev, Node next, Node child){
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
