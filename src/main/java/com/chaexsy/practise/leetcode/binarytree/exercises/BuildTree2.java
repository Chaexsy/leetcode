package com.chaexsy.practise.leetcode.binarytree.exercises;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * @author Chaexsy 2020-01-30 13:57
 */
public class BuildTree2 {
    /**
     * 中序遍历序列中,元素和索引的位置关系
     * key：元素
     * value：索引
     */
    private HashMap<Integer,Integer> inorderMap = new HashMap<>();
    /**
     * 前遍历序列中,元素和索引的位置关系
     * key：元素
     * value：索引
     */
    private HashMap<Integer,Integer> preorderMap = new HashMap<>();



    public TreeNode solution(int[] preorder, int[] inorder) {
        if(inorder.length == 0 || preorder.length == 0){
            return null;
        }

        for(int i = 0;i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
            preorderMap.put(preorder[i], i);
        }

        return buildTree(0, inorder.length-1, inorder, preorder);
    }

    /**
     * 构建子树
     *
     * @param startIndex 子树在中序遍历数组中的起始位置
     * @param endIndex 子树在中序遍历数组中的结束位置
     * @param inorder 中序遍历数组
     * @param preorder 前序遍历数组
     * @return 子树
     */
    private TreeNode buildTree(int startIndex, int endIndex, int[] inorder, int[] preorder){
        int rootIndex = getRootIndex(startIndex, endIndex, inorder, preorder);
        TreeNode node = new TreeNode(inorder[rootIndex]);

        // 中序遍历，根节点左边的元素的左子树的元素
        int ls = startIndex;
        int le = rootIndex -1;
        // 中序遍历，根节点右边的元素的右子树的元素
        int rs = rootIndex + 1;
        int re = endIndex;

        if(ls <= le){
            node.left = buildTree(ls, le, inorder, preorder);
        }
        if(rs <= re){
            node.right = buildTree(rs, re, inorder, preorder);
        }
        return node;
    }

    /**
     * 根据子树的边界范围寻找子树的根节点在中序遍历数组中的索引
     *
     * @param startIndex 子树在中序遍历数组中的起始位置
     * @param endIndex 子树在中序遍历数组中的结束位置
     * @param inorder 中序遍历数组
     * @param preorder 前序遍历数组
     * @return 子树的根节点在中序遍历数组中的索引
     */
    private int getRootIndex(int startIndex, int endIndex, int[] inorder, int[] preorder){
        int rootIndexInPreOrder = Integer.MAX_VALUE;
        for(int i=startIndex; i<=endIndex; i++){
            // 前序遍历，根节点总是在最前的，所以根节点索引选最小的一个
            rootIndexInPreOrder = Math.min(rootIndexInPreOrder, preorderMap.get(inorder[i]));
        }

        return inorderMap.get(preorder[rootIndexInPreOrder]);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{3,9,20,15,7};
        TreeNode root = new BuildTree2().solution(preorder, inorder);
        System.out.println(root.val);
    }
}
