package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author Chaexsy 2020-01-31 10:37
 */
public class IsValidBST {
    /**
     * 解法1
     * 利用二叉搜索树中序遍历的结果是一个递增序列的特点
     * 1.先中序遍历树
     * 2.遍历中序遍历结果，看看是否是递增的
     */
    public boolean solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ldr(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void ldr(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        ldr(node.left, list);
        list.add(node.val);
        ldr(node.right, list);
    }

}
