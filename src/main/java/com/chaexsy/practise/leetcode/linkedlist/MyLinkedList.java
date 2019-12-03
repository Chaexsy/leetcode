package com.chaexsy.practise.leetcode.linkedlist;

/**
 * 设计链表
 *
 * @author Chaexsy 2019-12-02 23:45
 */
class MyLinkedList {
    private class Node{
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }

    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i = 0;

        Node cur = head;
        while (i<index){
            cur = cur.next;
            i++;
        }

        if(cur != null){
            return cur.val;
        }else {
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node curTail = head;

        while (curTail.next != null){
            curTail = curTail.next;
        }

        curTail.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node cur = head;
        int i = 0;
        while (i<index-1){
            cur = cur.next;
            i++;
        }

        if(cur!=null){
            Node node = new Node(val);
            node.next = cur.next;
            cur.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node prev = head;
        Node next;

        int i = 0;
        while (i<index-1){
            if(prev == null){
                continue;
            }

            prev = prev.next;
            i++;
        }

        if(prev != null){
            Node cur = prev.next;
            if(cur != null){
                prev.next = cur.next;
            }
        }
    }

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
