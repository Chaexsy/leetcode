package com.chaexsy.practise.leetcode.binarytree;

/**
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author Chaexsy 2020-01-28 11:38
 */
public class HasPathSum {
    private boolean result = false;

    /**
     * 解法1
     * 自顶向下，深度优先搜索
     * 逐层递归，逐层累加
     */
    public boolean solution(TreeNode root, int sum) {
        if(root == null) return false;
        ldr(root, 0, sum);
        return result;
    }

    private void ldr(TreeNode node, int sum, int target){
        // result为true时没有必要再搜索了
        // 直接返回提高效率
        if(result){
            return;
        }

        if(node.left == null && node.right == null){
            if(node.val + sum == target){
                result = true;
            }
        }else {
            if(node.left != null){
                ldr(node.left, sum+node.val, target);
            }
            if(node.right != null){
                ldr(node.right, sum+node.val, target);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(new HasPathSum().solution(root, 22));
    }
}
