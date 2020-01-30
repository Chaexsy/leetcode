package com.chaexsy.practise.leetcode.binarytree.exercises;



/**
 * 填充每个节点的下一个右侧节点指针
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度
 *
 * @author Chaexsy 2020-01-30 14:20
 */
public class ConnectRightNode1 {
    /**
     * 解法1
     * 前序遍历搜索
     * 同一个节点下的两个子节点，left.next = right
     * 不同节点下的子节点连接，node.right.next = node.next.left
     */
    public Node solution(Node root) {
        ldr(root);
        return root;
    }

    private void ldr(Node node){
        if (node == null) return;

        if(node.left != null){
            node.left.next = node.right;
        }
        if(node.next != null && node.right != null){
            node.right.next = node.next.left;
        }

        ldr(node.left);
        ldr(node.right);
    }

    public static void main(String[] args){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node result = new ConnectRightNode1().solution(node);
        System.out.println(result.val);
    }
}
