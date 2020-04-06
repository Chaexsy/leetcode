package com.chaexsy.practise.leetcode.narytree;

import java.util.ArrayList;

/**
 * Maximum Depth of N-ary Tree
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 * @author Chaexsy 2020-02-03 11:18
 */
public class MaxDepth {
    public int solution(Node root) {
        if(root == null){
            return 0;
        }
        return getLength(root, 1);
    }

    public int getLength(Node node, int length) {
        if(node == null){
            return length;
        }
        if(node.children != null && node.children.size() > 0){
            int maxLength = 0;
            for (int i = 0; i < node.children.size(); i++) {
                maxLength = Math.max(maxLength, getLength(node.children.get(i), length + 1));
            }
            return maxLength;
        }else{
            return length;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        System.out.println(new MaxDepth().solution(root));
    }

}
