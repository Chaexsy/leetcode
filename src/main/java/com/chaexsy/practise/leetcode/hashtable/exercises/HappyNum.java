package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @author Chaexsy 2020-01-11 13:48
 */
public class HappyNum {
    /**
     * 解法1：
     *
     * 若一个数是快乐数，最终变换会回到1，因此确定循环终结条件；
     * 若不是快乐数，会进入死循环，如何终至死循环，将每次变换过后的值存入HashSet中，判断是否出现过重复值，出现则return false;
     *
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     */
    public boolean solution(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            n = change(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public int change(int n){
        int sum = 0;
        int num;
        // 每次都取个位的数字
        // 取完个位的数字后，就把数字缩小十倍扔掉个位
        // 再接着取下一个个位
        while(n != 0){
            num = n%10;
            n /= 10;
            sum += num*num;
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println(new HappyNum().solution(987));
    }
}
