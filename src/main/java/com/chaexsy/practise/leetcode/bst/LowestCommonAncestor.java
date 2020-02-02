package com.chaexsy.practise.leetcode.bst;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;
import com.chaexsy.practise.leetcode.utils.PrintUtil;

/**
 * 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * @author Chaexsy 2020-02-02 14:36
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
        search(root, p, q);
        return ans;
    }

    private boolean search(TreeNode node, TreeNode p, TreeNode q){
        if (node == null) {
            return false;
        }
        int left = search(node.left, p, q) ? 1 : 0;
        int right = search(node.right, p, q) ? 1 : 0;
        int mid = node.val == p.val || node.val == q.val ? 1 : 0;

        if(left + right + mid >= 2){
            ans = node;
        }

        return (mid + left + right > 0);
    }

    /**
     * 解法2
     *
     * 利用二叉搜索树特性
     *
     * 从根节点开始遍历树
     * 如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
     * 如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
     * 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了
     */
    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return solution2(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return solution2(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = new TreeNode(nums);
        PrintUtil.printTree(root);
        System.out.println("father:" + new LowestCommonAncestor().solution(root, new TreeNode(2), new TreeNode(4)).val);
    }

}
