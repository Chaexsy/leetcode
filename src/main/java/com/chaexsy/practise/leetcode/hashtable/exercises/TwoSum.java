package com.chaexsy.practise.leetcode.hashtable.exercises;

import com.chaexsy.practise.leetcode.arrayAndString.TowNumSum;
import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author yusijia 2020-01-11 17:47
 * @since v.0.1
 */
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        // 遍历过的数组元素，Key为元素值，value为元素索引
        Map<Integer, Integer> visited = new HashMap<>(1024);

        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            int left = target - nums[i];
            if(visited.get(left) != null){
                result[0] = visited.get(left);
                result[1] = i;
                break;
            }
            visited.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        PrintUtil.printArray(new TwoSum().solution(arr, 9));
    }
}
