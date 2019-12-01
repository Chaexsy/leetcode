package com.chaexsy.practise.leetcode.stack.exercises;

import java.util.List;
import java.util.Set;

/**
 * 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 * 注意:
 *
 * 1.数组非空，且长度不会超过20。
 * 2.初始的数组的和不会超过1000。
 * 3.保证返回的最终结果能被32位整数存下。
 *
 * @author Chaexsy 2019-10-19 17:17
 */
public class TargetSum {
    private int result = 0;


    /**
     * 暴力解法：
     * 执行用时 :673 ms, 在所有 Java 提交中击败了19.31%的用户
     * 内存消耗 :35.2 MB, 在所有 Java 提交中击败了81.70%的用户
     *
     * @param nums 数组
     * @param S 目标和
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return result;
    }

    /**
     * 深度优先搜索
     *
     * @param nums 数组
     * @param S 目标和
     * @param index 当前元素的数组下标
     * @param cS 目前的和
     */
    private void dfs(int[] nums, int S, int index, int cS) {
        if (cS == S && index == nums.length) {
            result++;
            return;
        }
        if (index >= nums.length) {
            return;
        }

        //+
        dfs(nums, S, index + 1, cS + nums[index]);
        //-
        dfs(nums, S, index + 1, cS - nums[index]);
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int sum = 3;
        System.out.println(new TargetSum().findTargetSumWays(nums, sum));

    }
}
