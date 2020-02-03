package com.chaexsy.practise.leetcode.bst;

import java.util.TreeSet;

/**
 * 存在重复元素 III
 *
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
 * 并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * @author Chaexsy 2020-02-02 22:32
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * 解法1
     * 线性搜索：将每个元素与它之前的 k 个元素比较，查看它们的数值之差是不是在 t 以内。
     *
     * 解决这个问题需要找到一组满足以下条件的 i 和 j：
     * 1. |i-j| <= k
     * 2. |nums[i]-nums[j]| <= t
     *
     * 我们需要维护了一个k大小的滑动窗口。
     * 这种情况下，第一个条件始终是满足的，只需要通过线性搜索来检查第二个条件是否满足就可以了。
     */
    public boolean solution1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法2
     * 思路：
     * 如果窗口中维护的元素是有序的，只需要用二分搜索检查条件二是否是满足的就可以了。
     * 利用自平衡二叉搜索树，可以在对数时间内通过 插入 和 删除 来对滑动窗口内元素排序。
     *
     *整个算法的伪代码：
     *
     * ·初始化一颗空的二叉搜索树 set
     * ·对于每个元素x，遍历整个数组
     *      在 set 上查找大于等于x的最小的数，如果 s - x ≤ t 则返回 true
     *      在 set 上查找小于等于x的最大的数，如果 x - g ≤ t 则返回 true
     *      在 set 中插入x
     *      如果树的大小超过了k, 则移除最早加入树的那个数。
     * ·返回 false
     *
     */
    public boolean solution2(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
