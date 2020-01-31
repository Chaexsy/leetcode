package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 提示：
 *
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * @author Chaexsy 2020-01-31 11:51
 */
public class BSTIterator2 {
    private Stack<TreeNode> stack;
    private TreeNode cur;

    /**
     * 解法2
     *
     * 受控递归思想
     * 用迭代模拟递归
     * 把迭代方法拆分成迭代器类
     */
    public BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        int res = -1;
        while (cur != null || !stack.isEmpty()) {
            // 节点不为空一直压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left; // 考虑左子树
            }
            // 节点为空，就出栈
            cur = stack.pop();
            res = cur.val;
            // 考虑右子树
            cur = cur.right;
            break;
        }

        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
