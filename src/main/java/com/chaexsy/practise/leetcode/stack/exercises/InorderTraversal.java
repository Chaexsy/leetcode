package com.chaexsy.practise.leetcode.stack.exercises;

import java.util.*;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * @author Chaexsy 2019-11-03 17:33
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        ldr(queue, root, visited);

        while (!queue.isEmpty()){
            result.add(queue.poll().val);
        }

        return result;
    }

    public void ldr(Queue<TreeNode> queue, TreeNode node, Set<TreeNode> visited){
        if(node == null){
            return;
        }else{
            System.out.println("Begin search node: " + node.val);

            // 有左子树，就先去递归搜索左子树
            ldr(queue, node.left, visited);
            // 搜索了左子树在处理根节点
            if(!visited.contains(node)){
                queue.add(node);
                visited.add(node);
            }
            // 最后处理右子树
            ldr(queue, node.right, visited);
        }
    }



    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        right.left = rightLeft;
        root.right = right;

        List<Integer> result = new InorderTraversal().inorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
