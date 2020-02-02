package com.chaexsy.practise.leetcode.binarytree;

/**
 * 二叉树
 *
 * @author Chaexsy 2020-01-27 15:26
 */
public class TreeNode {
    public int val;
    public int count;
    public TreeNode left;
    public TreeNode right;
    private boolean initialize;



    public TreeNode(int x) {
        val = x;
        count = 1;
    }

    public TreeNode(Integer[] nums){
        for (int i = 0; i < nums.length; i++) {
            insert(this, nums[i]);
        }
    }

    private void insert(TreeNode node, Integer val){
        if(val == null){
            return;
        }
        if(!initialize){
            this.val = val;
            initialize = true;
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

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
