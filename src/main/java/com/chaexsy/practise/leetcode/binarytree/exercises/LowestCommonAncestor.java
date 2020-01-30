package com.chaexsy.practise.leetcode.binarytree.exercises;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

/**
 *  二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author Chaexsy 2020-01-30 18:08
 */
public class LowestCommonAncestor {
    private TreeNode ans;


    /**
     * 解法1
     *
     * 1.从根节点开始遍历树。
     * 2.如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。
     * 3.如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
     * 4.如果在遍历的任何点上，左、右或中三个标志中的任意两个变为 true，这意味着我们找到了节点 p 和 q 的最近公共祖先。
     */
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }

        // 搜索左子树，如果搜索到p或者q，设置left = 1，没搜索到则为 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        // 搜索右子树，如果搜索到p或者q，设置right = 1，没搜索到则为 0
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        // 如果节点本身是p或者q，则设置mid为1，否则为0
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // 以上三个变量如果有两个为1，则表示它是公共祖先
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // 以上三个变量如果任意一个为1，就表示搜索到了p或者q
        return (mid + left + right > 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new LowestCommonAncestor().solution(root, root.left, root.left.right.right).val);
    }
}
