package com.chaexsy.practise.leetcode.narytree;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.*;

/**
 * N-ary Tree Preorder Traversal
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author Chaexsy 2020-02-02 23:00
 */
public class Preorder {
    /**
     * 解法1
     * 递归
     */
    public List<Integer> solution(Node root) {
        List<Integer> result = new ArrayList<>();
        ldr(root, result);
        return result;
    }

    private void ldr(Node node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);

        if(node.children != null && node.children.size() > 0){
            for(int i=0; i<node.children.size(); i++){
                ldr(node.children.get(i), list);
            }
        }
    }

    /**
     * 解法2
     * 迭代
     */
    public List<Integer> solution2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);

            if(node.children != null && node.children.size() > 0){
                for (int i = node.children.size()-1; i >= 0 ; i--) {
                    stack.add(node.children.get(i));
                }
            }
        }
        return result;
    }
}
