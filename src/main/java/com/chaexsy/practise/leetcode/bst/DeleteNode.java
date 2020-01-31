package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

/**
 * Delete Node in a BST
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * @author Chaexsy 2020-01-31 17:05
 */
public class DeleteNode {
    public TreeNode solution(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        delete(root, val);
        return root;
    }

    private void delete(TreeNode node, int val){
        if(node.val == val){
            if(node.left == null && node.right == null){
                // 目标节点没有子节点，直接删除
                node = null;
            }else if (node.left != null){
                // 目标节点有左子树，拿左子树替换目标节点
                node = node.left;
            }else if(node.right != null){
                // 目标节点有右子树，拿右子树替换目标节点
                node = node.right;
            }else{
                // 目标节点即有左子树又有右子树，拿中序遍历的后继节点和目标节点互换位置，再删除目标节点
                TreeNode next;
                if (node.right.left == null && node.right.right == null){
                    next = node.right;
                    int temp = next.val;
                    next.val = node.val;
                    node.val = temp;
                    next = null;
                }else if(node.right.left != null){
                    next = node.right.left;
                    int temp = next.val;
                    next.val = node.val;
                    node.val = temp;
                    next = null;
                }else if(node.right.right != null){
                    node = node.right;
                }
            }
        }else if(node.val > val){
            delete(node.left, val);
        }else{
            delete(node.right, val);
        }
    }
}
