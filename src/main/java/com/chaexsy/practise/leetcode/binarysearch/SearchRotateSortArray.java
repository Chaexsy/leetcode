package com.chaexsy.practise.leetcode.binarysearch;

/**
 * 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author Chaexsy 2020-01-24 15:08
 */
public class SearchRotateSortArray {
    /**
     * 解法1
     *
     * 先用二分查找法找到旋转点
     * 再用二分查找法分别搜索旋转点左右两边的区域
     */
    public int solution(int[] nums, int target) {
        int rotateIndex;

        int left = 0, right = nums.length;
        while (left < right){
            int middle = left + (right-left)/2;
            if(nums[middle] < nums[0]){
                right = middle;
            }else{
                left = middle+1;
            }
        }
        rotateIndex = left;

        int left1 = 0, right1 = rotateIndex - 1;
        int left2 = rotateIndex, right2 = nums.length - 1;

        while (left1 <= right1 || left2 <= right2){
            int middle1 = left1 + (right1-left1)/2;
            int middle2 = left2 + (right2-left2)/2;

            if(middle1 < nums.length){
                if(nums[middle1] == target){
                    return middle1;
                }else if(nums[middle1] < target){
                    left1 = middle1 + 1;
                }else if(nums[middle1] > target){
                    right1 = middle1 - 1;
                }
            }

            if(middle2 < nums.length){
                if(nums[middle2] == target){
                    return middle2;
                }else if(nums[middle2] < target){
                    left2 = middle2 + 1;
                }else if(nums[middle2] > target){
                    right2 = middle2 - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new SearchRotateSortArray().solution(nums, 0));
    }
}
