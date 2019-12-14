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
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }


        Node cur = head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }

        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            return;
        }

        Node node = new Node(val);

        if(index == 0){
            node.next = head;
            head = node;
        }else{
            Node prev = head;

            for(int i=0; i<index-1; i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }

        if(index == 0){
            Node temp = this.head;
            this.head = head.next;
            temp.next = null;
        }else{
            Node prev = head;
            for(int i=0; i<index-1; i++){
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
        size--;
    }

    public static void main(String[] args){
        /*
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
        */

        /*
        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addAtHead(7);
        linkedList2.addAtTail(7);
        linkedList2.addAtHead(9);
        linkedList2.addAtTail(8);
        linkedList2.addAtHead(6);
        linkedList2.addAtHead(0);
        System.out.println(linkedList2.get(5));
        linkedList2.addAtHead(0);
        System.out.println(linkedList2.get(2));
        System.out.println(linkedList2.get(5));
        linkedList2.addAtTail(4);
        */

        MyLinkedList linkedList3 = new MyLinkedList();
        linkedList3.addAtHead(4);
        System.out.println(linkedList3.get(1));

    }
}
