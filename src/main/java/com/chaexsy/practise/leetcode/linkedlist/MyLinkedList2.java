package com.chaexsy.practise.leetcode.linkedlist;

/**
 * @author Chaexsy 2019-12-03 22:46
 */
public class MyLinkedList2 {
    private class Node{
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }
    private Node dummyHead;
    int size;

    public MyLinkedList2() {
        dummyHead = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;
        Node curr = dummyHead.next;
        for(int i = 0; i < index; i++)
            curr = curr.next;
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        if(index < 0)
            addAtHead(val);
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)
            return;
        Node prev = dummyHead;
        for(int i = 0; i < index; i++)
            prev = prev.next;
        Node reNode = prev.next;
        prev.next = reNode.next;
        reNode.next = null;
        size--;
    }

    public static void main(String[] args){
        MyLinkedList2 linkedList = new MyLinkedList2();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(0);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
    }
}
