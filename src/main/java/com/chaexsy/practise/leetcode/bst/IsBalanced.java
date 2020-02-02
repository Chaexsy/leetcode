package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;
import com.chaexsy.practise.leetcode.utils.PrintUtil;

/**
 * 平衡二叉树
 *
 * @author Chaexsy 2020-02-02 15:53
 */
public class IsBalanced {
    /**
     * 解法1
     * 不断递归比较左数和右数的深度
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int leftLength = getLength(root.left, 0);
        int rightLength = getLength(root.right, 0);

        if(Math.abs(leftLength - rightLength) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int getLength(TreeNode node, int length) {
        if(node == null){
            return length;
        }
        length++;
        int leftLength = getLength(node.left, length);
        int rightLength = getLength(node.right, length);

        return Math.max(leftLength, rightLength);
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);
//        System.out.println(new IsBalanced().isBalanced(node));

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(2);

        node2.left.left = new TreeNode(3);
        node2.left.right = new TreeNode(3);

        node2.left.left.left = new TreeNode(4);
        node2.left.left.right = new TreeNode(4);
        PrintUtil.printTree(node2);
        System.out.println(new IsBalanced().isBalanced(node2));
    }
}
