package com.chaexsy.practise.leetcode.binarytree;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Chaexsy 2020-01-27 18:14
 */
public class InorderTraversal {
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
        list.add(node.val);
        ldr(node.right, list);
    }

    /**
     * 解法2
     * 迭代
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        PrintUtil.printList(new InorderTraversal().solution2(root));
    }
}
