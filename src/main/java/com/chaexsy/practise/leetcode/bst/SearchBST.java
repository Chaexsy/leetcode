package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

/**
 * Search in a Binary Search Tree
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * @author Chaexsy 2020-01-31 14:30
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        return findNode(root, val);
    }

    private TreeNode findNode(TreeNode node, int target){
        if(node == null){
            return null;
        }
        if(node.val == target){
            return node;
        }else if(node.val > target){
            return findNode(node.left, target);
        }else{
            return findNode(node.right, target);
        }
    }


}
