package com.chaexsy.practise.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author Chaexsy 2020-01-28 9:35
 */
public class IsSymmetricTree {
    /**
     * 解法1
     * 自底向上递归思想
     * 自底向上检查左右子树是否互为镜像
     */
    public boolean solution(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /**
     * 解法2
     * 迭代
     */
    public boolean solution2(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            // 一次取两个节点来进行比对
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 != null){
                return false;
            }
            if(node1 != null && node2 == null){
                return false;
            }
            if(node1 != null && node2 != null){
                if(node1.val != node2.val){
                    return false;
                }else{
                    queue.add(node1.right);
                    queue.add(node2.left);
                    queue.add(node1.left);
                    queue.add(node2.right);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new IsSymmetricTree().solution2(root));
    }
}
