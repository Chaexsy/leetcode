package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author Chaexsy 2020-01-16 10:23
 */
public class ContainsNearbyDuplicate {
    public boolean solution(int[] nums, int k) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(visited.containsKey(nums[i]) && (i-visited.get(nums[i]) <= k)){
                return true;
            }

            visited.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,3,1};
        int[] nums2 = new int[]{1,0,1,1};
        int[] nums3 = new int[]{1,2,3,1,2,3};

        System.out.println(new ContainsNearbyDuplicate().solution(nums1, 3));
        System.out.println(new ContainsNearbyDuplicate().solution(nums2, 1));
        System.out.println(new ContainsNearbyDuplicate().solution(nums3, 2));
    }
}
