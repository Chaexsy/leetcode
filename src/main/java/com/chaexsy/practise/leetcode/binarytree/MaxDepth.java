package com.chaexsy.practise.leetcode.binarytree;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author Chaexsy 2020-01-28 9:05
 */
public class MaxDepth {
    private int maxDepth;

    /**
     * 解法1
     * 自顶向下的思路
     * 1. root 深度为一
     * 2. 递归搜索子节点，每深入一层就将深度+1，传递到子节点
     * 3. 搜索到叶子节点时更新最大深度
     */
    public int solution(TreeNode root) {
        maxDepth = 0;
        ldr(root, 1);
        return maxDepth;
    }

    public void ldr(TreeNode node, int depth){
        if(node.left == null && node.right == null){
            maxDepth = Math.max(depth, maxDepth);
        }else{
            if(node.left != null){
                ldr(node.left, depth+1);
            }
            if(node.right != null){
                ldr(node.right, depth+1);
            }
        }
    }

    /**
     * 解法2
     * 自底向上的思路
     * 1. 一个根节点，以其左子节点为根的最大深度为 l 和以其右子节点为根的最大深度为 r
     * 2. 根节点的深度 x = max（l，r）+ 1
     * 3. 对于每一个节点来说，都可以在解决它子节点的问题之后得到答案
     */
    public int solution2(TreeNode root) {
        return ldr2(root);
    }

    private int ldr2(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = ldr2(node.left);
        int rightDepth = ldr2(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new MaxDepth().solution2(root));
    }
}
