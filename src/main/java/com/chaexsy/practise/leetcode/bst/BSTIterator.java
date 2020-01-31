package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
public class BSTIterator {
    private List<Integer> nodeList;
    private int index;

    /**
     * 解法1
     *
     * 先中序遍历把树展开到数组
     * 再操作数组
     */
    public BSTIterator(TreeNode root) {
        index = -1;
        nodeList = new ArrayList<>();
        ldr(root);
    }

    private void ldr(TreeNode node) {
        if (node == null) {
            return;
        }
        ldr(node.left);
        nodeList.add(node.val);
        ldr(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        return nodeList.get(++index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < nodeList.size()-1;
    }
}
