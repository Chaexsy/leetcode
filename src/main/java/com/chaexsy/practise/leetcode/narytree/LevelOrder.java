package com.chaexsy.practise.leetcode.narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * @author Chaexsy 2020-02-02 23:02
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(new ArrayList<Node>(){{add(root);}});
        while (!queue.isEmpty()){
            // 当前这一层从左到右的节点值列表
            List<Integer> visited = new ArrayList<>();
            // 下一层的节点
            List<Node> nextLevelNodes = new ArrayList<>();

            // 取出一层的节点进行遍历
            List<Node> nodeList = queue.poll();
            for (int i = 0; i < nodeList.size(); i++) {
                Node node = nodeList.get(i);
                visited.add(node.val);

                if(node.children != null && node.children.size() > 0){
                    for (int j = 0; j <node.children.size(); j++) {
                        nextLevelNodes.add(node.children.get(j));
                    }
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
}
