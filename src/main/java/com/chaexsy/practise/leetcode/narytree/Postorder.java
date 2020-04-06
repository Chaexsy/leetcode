package com.chaexsy.practise.leetcode.narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Postorder Traversal
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author Chaexsy 2020-02-02 23:01
 */
public class Postorder {
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

        if(node.children != null && node.children.size() > 0){
            for(int i=0; i<node.children.size(); i++){
                ldr(node.children.get(i), list);
            }
        }
        list.add(node.val);
    }

    /**
     * 解法2
     * 迭代
     */
    public List<Integer> solution2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.addFirst(node.val);

            if(node.children != null && node.children.size() > 0){
                for (int i = 0; i < node.children.size() ; i++) {
                    stack.add(node.children.get(i));
                }
            }
        }
        return result;
    }
}
