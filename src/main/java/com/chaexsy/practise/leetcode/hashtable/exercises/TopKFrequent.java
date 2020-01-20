package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * @author Chaexsy 2020-01-19 8:13
 */
public class TopKFrequent {
    /**
     * 解法1
     *
     * 统计每个数的频次，将结果存入哈希表。
     * 新建一个桶，将哈希表中每个数插入索引为它的频次的这个桶里。
     * 由于桶的索引是数的频次，越往后面的索引也就意味着频次越高，因此倒着遍历桶，
     * 取出最先遍历的k个数就是我们想要的答案。
     *
     */
    public List<Integer> solution(int[] nums, int k) {
        // key：数字，value：重复次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.merge(num, 1, (oldValue, one)->{
                return oldValue+one;
            });
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int count = entry.getValue();
            if(bucket[count]==null){
                bucket[count]=new ArrayList<>();
            }
            bucket[count].add(entry.getKey());
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=bucket.length-1; i>=0 && res.size()<k; i--){
            if(bucket[i]!=null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,2,2,3};
        int[] nums2 = new int[]{1};

        System.out.println(new TopKFrequent().solution(nums1, 2));
        System.out.println(new TopKFrequent().solution(nums2, 1));
    }
}
