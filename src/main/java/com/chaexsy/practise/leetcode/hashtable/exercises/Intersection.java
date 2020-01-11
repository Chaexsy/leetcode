package com.chaexsy.practise.leetcode.hashtable.exercises;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序
 *
 * @author Chaexsy 2020-01-11 11:00
 */
public class Intersection {
    /**
     * 解法1：
     * 双重for循环暴力遍历比对重复元素
     * 重复元素加入set，再转换为数组
     *
     * 时间复杂度：O(n2)
     * 空间复杂度：O(n)
     */
    public int[] solution(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
           for(int j=0; j<nums2.length; j++){
               if(nums1[i] == nums2[j]){
                   set.add(nums1[i]);
                   break;
               }
           }
        }

        int[] result = new int[set.size()];

        int index = 0;
        for(int num:set){
            result[index] = num;
            index++;
        }
        return result;
    }

    /**
     * 解法2
     * 先把数组1放到set1中
     * 遍历数组2，把和set1重合的元素放到set2里
     * 再把set2转换成数组
     *
     * 注：也可以利用set接口的的retainAll方法来获得重合元素
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] solution2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            set1.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int i=0; i<nums2.length; i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        int result[] = new int[set2.size()];
        int index = 0;
        for(int num:set2){
            result[index] = num;
            index++;
        }
        return result;
    }

    /**
     * 解法3：
     * 类似布隆过滤器原理？
     */
    public int[] solution3(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        boolean[] bool = new boolean[1200];
        for (int i = 0; i < nums1.length; i++) {
            bool[nums1[i]] = true;
        }
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (bool[nums2[i]]) {
                nums1[k++] = nums2[i];
                bool[nums2[i]] = false;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums1[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,2,1};
//        int[] nums2 = new int[]{2,2};

        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        PrintUtil.printArray(new Intersection().solution2(nums1, nums2));
    }
}
