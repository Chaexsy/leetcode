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
    private final int BUCKET_SIZE = 100;
    private final int ARRAY_SIZE = 10000;



    public MyHashSet() {
        table = new int[BUCKET_SIZE][ARRAY_SIZE+1];
    }

    public void add(int key) {
//        System.out.println("key: " + key + ", [" + getBucketHash(key) + "][" + getArrayHash(key)+"]");
        table[getBucketHash(key)][getArrayHash(key)] = 1;
    }

    public void remove(int key) {
        table[getBucketHash(key)][getArrayHash(key)] = 0;
    }

    public boolean contains(int key) {
        return table[getBucketHash(key)][getArrayHash(key)] > 0;
    }

    private int getBucketHash(int key){
        return key % BUCKET_SIZE;
    }

    private int getArrayHash(int key){
        return key / BUCKET_SIZE;
    }

    public static void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));

//        MyHashSet hashSet = new MyHashSet();
//        hashSet.add(0);
//        System.out.println(hashSet.contains(0));
//        hashSet.add(1000000);
//        System.out.println(hashSet.contains(1000000));
//        hashSet.remove(0);
//        System.out.println(hashSet.contains(0));

//        hashSet.add(0);
//        hashSet.add(1);
//        hashSet.add(2);
//        hashSet.add(100);
//        hashSet.add(200);
//        hashSet.add(10000);
//        hashSet.add(1000000);
//        System.out.println(hashSet.contains(10000));
    }
}
