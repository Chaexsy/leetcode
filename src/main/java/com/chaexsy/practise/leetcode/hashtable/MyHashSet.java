package com.chaexsy.practise.leetcode.hashtable;

/**
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 注意：
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 * @author yusijia 2020-01-05 17:17
 * @since v.0.1
 */
public class MyHashSet {
    private int[][] table;
    private int size;
    private final int DEFAULT_SIZE = 100;



    public MyHashSet() {
        size = DEFAULT_SIZE;
        table = new int[100][size];
    }

    public void add(int key) {
        table[hash(key)] = key;
    }

    public void remove(int key) {
        table[hash(key)] = null;
    }

    public boolean contains(int key) {
        return table[hash(key)] != null;
    }

    private int hash(int key){
        return key % size;
    }

    public static void main(String[] args){
//        MyHashSet hashSet = new MyHashSet();
//        hashSet.add(1);
//        hashSet.add(2);
//        System.out.println(hashSet.contains(1));
//        System.out.println(hashSet.contains(3));
//        hashSet.add(2);
//        System.out.println(hashSet.contains(2));
//        hashSet.remove(2);
//        System.out.println(hashSet.contains(2));

        MyHashSet hashSet = new MyHashSet();
//        hashSet.add(0);
//        System.out.println(hashSet.contains(0));
//        hashSet.add(1000000);
//        System.out.println(hashSet.contains(1000000));
//        hashSet.remove(0);
//        System.out.println(hashSet.contains(0));

        hashSet.add(10000);
        System.out.println(hashSet.contains(10000));
    }
}
