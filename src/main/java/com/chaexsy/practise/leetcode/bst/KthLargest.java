package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;
import com.chaexsy.practise.leetcode.utils.PrintUtil;

/**
 * Kth Largest Element in a Stream
 *
 * 设计一个找到数据流中第K大元素的类（class）。
 * 注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * @author Chaexsy 2020-02-02 11:59
 */
public class KthLargest {
    private TreeNode root;
    private int k;



    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            insert(this.root, nums[i]);
        }
    }

    private void insert(TreeNode node, int val){
        if(root == null){
            root = new TreeNode(val);
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
        node.count = node.count + 1;
    }

    public int add(int val) {
        insert(this.root, val);
        return findLargestNode(root, k);
    }

    public int findLargestNode(TreeNode node, int k){
        int rightChildCount = node.right == null ? 0 : node.right.count;
        int leftChildCount = node.left == null ? 0 : node.left.count;
        int rootCount = node.count - rightChildCount - leftChildCount;

        if (k <= rightChildCount) {
            // 如果k小于等于右子树中节点数，说明第k大的节点在右子树
            // 先在右子树中搜索第k大的节点
            return findLargestNode(node.right, k);
        }else if (k > rightChildCount + rootCount) {
            // 如果k大于右子树节点数加根节点出现次数，那么第k大的节点在左子树
            return findLargestNode(node.left, k - rightChildCount - rootCount);
        } else {
            // k = rightChildCount + rootCount( rootCount 总是等于1)
            // 如果k等于右子树节点数加根节点出现次数，那么第k大的节点为根节点
            return node.val;
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,8,2};
        int[] nums = new int[]{5,2,1,4,3,6,7};
        int[] nums2 = new int[0];
        int k = 4;
        KthLargest kthLargest = new KthLargest(1, nums2);
        kthLargest.add(-3);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(0);
        kthLargest.add(4);
        PrintUtil.printTreeWithNum(kthLargest.getRoot());
        kthLargest.findLargestNode(kthLargest.root, k);
    }
}
