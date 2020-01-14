package com.chaexsy.practise.leetcode.hashtable.exercises;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author Chaexsy 2020-01-13 9:36
 */
public class Intersect {
    /**
     * 解法1：
     * 先把num1，nums2遍历一遍，统计每个数字出现的次数，各自装入map1，map2
     * 再比较map1和map2，重复的数字，取map1和map2中次数少的，加入List
     * 最后把list转换为数组
     */
    public int[] solution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map1.containsKey(nums1[i])){
                map1.put(nums1[i], map1.get(nums1[i])+1);
            }else{
                map1.put(nums1[i], 1);
            }
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if(map2.containsKey(nums2[i])){
                map2.put(nums2[i], map2.get(nums2[i])+1);
            }else{
                map2.put(nums2[i], 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:map2.entrySet()){
            if(map1.containsKey(entry.getKey())){
                int time = Math.min(map1.get(entry.getKey()), entry.getValue());
                for(int j=0; j<time; j++){
                    resultList.add(entry.getKey());
                }
            }
        }

        int[] result = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

    /**
     * 解法2
     * 解法1的改良版本
     */
    public int[] solution2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums1.length ; i++) {
            if (map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums2.length ; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i <result.length ; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 解法3 * 较优解法
     * 数组双指针思路
     */
    public int[] solution3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,2,1};
//        int[] nums2 = new int[]{2,2};
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        PrintUtil.printArray(new Intersect().solution3(nums1, nums2));
    }
}
