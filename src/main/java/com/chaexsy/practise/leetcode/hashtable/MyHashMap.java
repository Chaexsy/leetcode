package com.chaexsy.practise.leetcode.hashtable;

/**
 * 设计哈希映射
 *
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能：
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 注意：
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库
 *
 * @author Chaexsy 2020-01-06 8:19
 */
public class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value, Node next){
           this.key = key;
           this.value = value;
           this.next = next;
        }
    }

    private Node[] table;
    private final int DEFAULT_SIZE = 1024;

    /**
     *  Initialize your data structure here.
     */
    public MyHashMap() {
        table = new Node[DEFAULT_SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node head = table[hash(key)];
        if(head == null){
            table[hash(key)] = new Node(key, value, null);
            return;
        }
        if(head.key == key){
            head.value = value;
            return;
        }

        boolean duplicateFlag = false;
        Node cur = head;
        while (cur != null){
            if(cur.key == key){
                cur.value = value;
                duplicateFlag = true;
                break;
            }else if(cur.next == null){
                // 已经到尾巴了，还没找到相等的，跳出循环
                break;
            }
            cur = cur.next;
        }
        if(!duplicateFlag){
            cur.next = new Node(key, value, null);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node node = table[hash(key)];

        while (node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }

        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node head = table[hash(key)];
        if(head == null) return;
        if(head.key == key){
            table[hash(key)] = head.next;
            return;
        }

        Node prev = head;
        Node cur = prev.next;

        while (cur != null){
            if(cur.key == key){
                prev.next = prev.next.next;
                break;
            }

            prev = prev.next;
            cur = prev.next;
        }
    }

    private int hash(int key){
        int bucketNum = key % table.length;
//        System.out.println("key: " + key + "[" + bucketNum + "]");
        return bucketNum;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
//        hashMap.put(1, 1);
//        hashMap.put(1025, 1025);
//        hashMap.put(2049, 2049);
//        hashMap.put(3073, 3073);
//        hashMap.put(4097, 4097);
//        hashMap.put(5121, 5121);
//        hashMap.remove(2049);
//        hashMap.remove(4097);
//        hashMap.put(1025, 10251);
//        hashMap.put(1025, 10252);
        hashMap.put(68717, 1);
        hashMap.put(69741,33133);
        hashMap.put(69741,625);
        System.out.println(hashMap.get(69741));
//        System.out.println(hashMap.get(1025));
//        System.out.println(hashMap.get(2049));
    }
}
