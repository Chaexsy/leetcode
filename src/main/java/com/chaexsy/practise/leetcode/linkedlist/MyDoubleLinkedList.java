package com.chaexsy.practise.leetcode.linkedlist;

import org.apache.commons.lang3.StringUtils;

/**
 * 双链表
 *
 * @author yusijiayf1 2019-12-23 10:37
 */
public class MyDoubleLinkedList {
    private class Node{
        public int val;
        public Node prev;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private int size;



    /** Initialize your data structure here. */
    public MyDoubleLinkedList() {
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size ){
            return -1;
        }

        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }

        return node.val;
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
        if(index < 0 || index > size ){
            return;
        }

        Node newNode = new Node(val);

        if(index == 0){
            newNode.next = head;
            if(head != null){
                head.prev = newNode;
            }
            head = newNode;
        }else{
            Node prev = head;
            for(int i=0; i<index-1; i++){
                prev = prev.next;
            }

            newNode.next = prev.next;
            newNode.prev = prev;

            prev.next = newNode;
            if(newNode.next != null){
                // 添加节点到链表末尾时，newNode.next是空的
                newNode.next.prev = newNode;
            }
        }

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size-1 ){
            return;
        }

        if(index == 0){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
        }else{
            Node prev = head;
            for(int i=0; i<index-1; i++){
                prev = prev.next;
            }

            prev.next = prev.next.next;
            if(prev.next != null){
                // 删除链表末尾节点时，prev.next是空的
                prev.next.prev = prev;
            }
        }

        size--;
    }

    public Node getHead() {
        return head;
    }

    public static void main(String[] args){
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        printLinkList("", linkedList);
        linkedList.deleteAtIndex(2);
        printLinkList("", linkedList);
    }

    public static void printLinkList(String prefix, MyDoubleLinkedList link){
        Node cur = link.getHead();

        if(StringUtils.isNotBlank(prefix)){
            System.out.print(prefix);
        }
        while (cur != null){
            if(cur.next != null){
                System.out.print(cur.val+"-");
            }else{
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
        System.out.println();
    }
}
