package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;
import com.chaexsy.practise.leetcode.utils.PrintUtil;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author Chaexsy 2020-02-02 16:19
 */
public class SortedArrayToBST {
    private TreeNode root;
    private int[] nums;

    /**
     * 解法1：
     *
     * 利用二叉搜索树的中序遍历结果为递增序列特性
     *
     * 1.不断截取数组中点来生成根节点
     * 2.然后中点左右两边的数组元素再去构造左右子树
     * 3.重复以上过程
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        division(0, nums.length-1);
        return root;
    }

    private void division(int start, int end){
        if(start > end){
            return;
        }

        int mid = start + (end - start)/2;
        if(root == null){
            root = new TreeNode(nums[mid]);
        }else{
            insert(root, nums[mid]);
        }

        int is = start;
        int ie = mid - 1;
        int rs = mid + 1;
        int re = end;

        division(is, ie);
        division(rs, re);
    }

    private void insert(TreeNode node, Integer val){
        if(val == null){
            return;
        }
        if(node.val > val){
            if(node.left == null){
                node.left = new TreeNode(val);
            }else{
                insert(node.left, val);
            }
        }else{
            if(node.right == null){
                node.right = new TreeNode(val);
            }else{
                insert(node.right, val);
            }
        }
    }

    /**
     * 解法2
     * 解法1的简化优化版本
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = buildTree(nums, l, m - 1);
        node.right = buildTree(nums, m + 1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = new SortedArrayToBST().sortedArrayToBST2(nums);
        PrintUtil.printTree(root);
    }
}
