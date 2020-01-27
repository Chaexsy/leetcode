package com.chaexsy.practise.leetcode.binarytree;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.*;

/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author Chaexsy 2020-01-27 22:56
 */
public class LevelOrderTraversal {
    /**
     * 解法1
     *
     * 利用队列
     * 逐层遍历
     * 遍历一层，就把下一层节点加入队列
     */
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(new ArrayList<TreeNode>(){{add(root);}});
        while (!queue.isEmpty()){
            List<TreeNode> nodeList = queue.poll();

            List<Integer> visited = new ArrayList<>();
            // 下一层节点
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (int i = 0; i < nodeList.size(); i++) {
                TreeNode node = nodeList.get(i);
                visited.add(node.val);
                if(node.left != null){
                    nextLevelNodes.add(node.left);
                }
                if(node.right != null){
                    nextLevelNodes.add(node.right);
                }
            }
            if(visited.size() > 0){
                result.add(visited);
            }
            if(nextLevelNodes.size() > 0){
                queue.add(nextLevelNodes);
            }
        }

        return result;
    }


    /**
     * 解法2
     */
    public List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        wfs(queue, result);
        return result;
    }

    private void wfs(Queue<TreeNode> queue, List<List<Integer>> result) {
        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> values = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                values.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(values);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = new LevelOrderTraversal().solution(root);
        for (int i = 0; i < result.size(); i++) {
            PrintUtil.printList(result.get(i));
        }
    }
}
