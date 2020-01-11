package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false

 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author Chaexsy 2020-01-09 23:54
 */
public class ContainsDuplicate {
    /**
     * 解法1：
     * 利用set集合元素不重复特性
     * 把数组元素加入set集合
     * set的size小于数组长度说明有重复
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        if(nums.length > set.size()){
            return true;
        }else{
            return false;
        }
    }
}
