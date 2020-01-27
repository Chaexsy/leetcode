package com.chaexsy.practise.leetcode.binarytree;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Chaexsy 2020-01-27 15:28
 */
public class PreorderTraversal {
    /**
     * 解法1：
     * 递归
     */
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        search(root, result);
        return result;
    }

    private void search(TreeNode node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);
        search(node.left, list);
        search(node.right, list);
    }

    /**
     * 解法2：
     * 迭代，利用栈后进先出特性
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        PrintUtil.printList(new PreorderTraversal().solution2(root));
    }
}
