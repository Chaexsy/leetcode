package com.chaexsy.practise.leetcode.binarytree.exercises;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author Chaexsy 2020-01-29 16:05
 */
public class BuildTree1 {
    /**
     * 中序遍历序列中,元素和索引的位置关系
     * key：元素
     * value：索引
     */
    private HashMap<Integer,Integer> inorderMap = new HashMap<>();
    /**
     * 后续遍历序列中,元素和索引的位置关系
     * key：元素
     * value：索引
     */
    private HashMap<Integer,Integer> postorderMap = new HashMap<>();

    private int[] post;

    /**
     * 解法1
     * 不断递归确定左右子树的边界
     */
    public TreeNode solution(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = inorderMap.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }

    /**
     * 解法2
     * 根据后序遍历根节点总在最后的特点
     * 不断递归 找出根节点 -> 分割左右子树 的循环
     * 直到无法再分割左右子树即为叶子节点
     */
    public TreeNode solution2(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }

        for(int i = 0;i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
            postorderMap.put(postorder[i], i);
        }

        return buildTree2(0, inorder.length-1, inorder, postorder);
    }

    /**
     * 构建子树
     *
     * @param startIndex 子树在中序遍历数组中的起始位置
     * @param endIndex 子树在中序遍历数组中的结束位置
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return 子树
     */
    private TreeNode buildTree2(int startIndex, int endIndex, int[] inorder, int[] postorder){
        int rootIndex = getRootIndex(startIndex, endIndex, inorder, postorder);
        TreeNode node = new TreeNode(inorder[rootIndex]);

        // 中序遍历，根节点左边的元素的左子树的元素
        int ls = startIndex;
        int le = rootIndex -1;
        // 中序遍历，根节点右边的元素的右子树的元素
        int rs = rootIndex + 1;
        int re = endIndex;

        if(ls <= le){
            node.left = buildTree2(ls, le, inorder, postorder);
        }
        if(rs <= re){
            node.right = buildTree2(rs, re, inorder, postorder);
        }
        return node;
    }

    /**
     * 根据子树的边界范围寻找子树的根节点在中序遍历数组中的索引
     *
     * @param startIndex 子树在中序遍历数组中的起始位置
     * @param endIndex 子树在中序遍历数组中的结束位置
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return 子树的根节点在中序遍历数组中的索引
     */
    private int getRootIndex(int startIndex, int endIndex, int[] inorder, int[] postorder){
        int rootIndexInPostOrder = -1;
        for(int i=startIndex; i<=endIndex; i++){
            // 后序遍历，根节点总是在最后的，所以根节点选索引最大的一个
            rootIndexInPostOrder = Math.max(rootIndexInPostOrder, postorderMap.get(inorder[i]));
        }

        return inorderMap.get(postorder[rootIndexInPostOrder]);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = new BuildTree1().solution2(inorder, postorder);
        System.out.println(root.val);
    }
}
