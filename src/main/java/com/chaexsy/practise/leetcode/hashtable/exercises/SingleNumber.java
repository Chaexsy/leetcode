package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author Chaexsy 2020-01-11 10:24
 */
public class SingleNumber {
    /**
     * 方法1：
     * 遍历过的数字放入set
     * 遇到重复的移除
     * 最后剩下的数字就是不重复的
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }

        if(!set.isEmpty() && set.size() == 1){
            return (int)set.toArray()[0];
        }else{
            return -1;
        }
    }

    /**
     * 解法2
     *
     * 利用异或操作的特性找出不重复数
     *      1. 两个重复的数进行异或等于0。 eg: 4^4 = 0
     *      2. 非零整数异或0等于它本身。 eg: 5^0 = 5
     *      2. a^b^c = a^(b^c) = (a^b)^c。eg: 4^1^4 = 4^4^1 = 0^1 = 1
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int solution2(int[] nums) {
        int result = nums[0];
        for (int i=1; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().solution2(new int[]{2,2,1}));
        System.out.println(new SingleNumber().solution2(new int[]{4,1,2,1,2}));

//        System.out.println(4^88^4^3^2^2^3);
    }
}
