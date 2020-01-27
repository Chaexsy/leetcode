package com.chaexsy.practise.leetcode.binarytree;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Chaexsy 2020-01-27 20:14
 */
public class PostorderTraversal {
    /**
     * 解法1
     * 递归，深度优先搜索
     */
    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ldr(root, result);
        return result;
    }

    private void ldr(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        ldr(node.left, list);
        ldr(node.right, list);
        list.add(node.val);
    }

    /**
     * 解法2
     * 迭代
     */
    public List<Integer> solution2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        PrintUtil.printList(new PostorderTraversal().solution2(root));
    }
}
