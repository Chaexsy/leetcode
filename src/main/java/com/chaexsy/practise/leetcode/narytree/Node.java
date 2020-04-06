package com.chaexsy.practise.leetcode.narytree;

import java.util.List;

/**
 * N叉树
 *
 * @author Chaexsy 2020-02-03 9:07
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
