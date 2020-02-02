package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;
import com.chaexsy.practise.leetcode.utils.PrintUtil;
import com.chaexsy.practise.leetcode.utils.TreePrinter;

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
    public TreeNode solution(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        return delete(root, key);
    }

    private TreeNode delete(TreeNode node, int val){
        if (node == null) return null;

        if(node.val == val){
            if(node.left == null && node.right == null){
                // 目标节点是叶子节点，没有子节点，直接删除
                node = null;
            }else if (node.right != null){
                // 目标节点存在右子树
                // 则拿中序遍历的后继节点的值替换目标节点，再删除后继节点
                node.val = successor(node);
                node.right = delete(node.right, node.val);
            }else{
                // 目标节点不存在右子树，但是存在左子树
                // 则拿中序遍历的前驱节点的值替换目标节点,再删除后继节点
                node.val = predecessor(node);
                node.left = delete(node.left, node.val);
            }
        }else if(node.val > val){
            node.left = delete(node.left, val);
        }else{
            node.right = delete(node.right, val);
        }

        return node;
    }

    /**
     * 获取中序遍历的后继节点的值
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /**
     * 获取中序遍历的前驱节点的值
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        PrintUtil.printTree(root);
        TreeNode afterDeleteTree = new DeleteNode().solution(root, 2);
        System.out.println("After delete: ");
        PrintUtil.printTree(afterDeleteTree);
    }
}
