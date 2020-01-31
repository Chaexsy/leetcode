package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

/**
 * Insert into a Binary Search Tree
 *
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * 例如,
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 * @author Chaexsy 2020-01-31 16:12
 */
public class InsertIntoBST {

    public TreeNode solution(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }

    private void insert(TreeNode node, int val){
        if(node.val > val){
            if(node.left == null){
                node.left = new TreeNode(val);
            }else{
                insert(node.left, val);
            }
        }else{
            if(node.right == null){
                node.right = new TreeNode(val);
            }else{
                insert(node.right, val);
            }
        }
    }
}
