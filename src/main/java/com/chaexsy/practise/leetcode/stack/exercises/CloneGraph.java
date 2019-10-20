package com.chaexsy.practise.leetcode.stack.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 *
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 * @author Chaexsy 2019-10-19 16:48
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node clone(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node,Node> visited) {
        if (node == null)
            return null;
        if (visited.containsKey(node))
            return visited.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n,visited));
        return clone;
    }

}
