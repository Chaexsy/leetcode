package com.chaexsy.practise.leetcode.binarytree.exercises;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * 给定一个二叉树
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
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author Chaexsy 2020-01-30 14:20
 */
public class ConnectRightNode2 {
    /**
     * 解法1
     */
    public Node solution(Node root) {
        ldr(root);
        return root;
    }

    private void ldr(Node node){
        if(node == null){
            return;
        }
        if(node.right == null && node.left == null){
            return;
        }

        if(node.left != null && node.right != null){
            // 左右子树都不为空，左子树的next指向右子树
            node.left.next = node.right;
            node.right.next = getConnectRight(node);
        }else if (node.left == null){
            // 左子树为空，右子树不为空，右子树寻找右侧连接点
            node.right.next = getConnectRight(node);
        }else{
            // 左子树不为空，右子树为空，左子树寻找右侧连接点
            node.left.next = getConnectRight(node);
        }

        // 这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        ldr(node.right);
        ldr(node.left);
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private Node getConnectRight(Node node){
        if (node.next == null) {
            return null;
        }

        Node cur = node.next;
        while (cur != null && cur.left == null && cur.right == null){
            cur = cur.next;
        }

        if(cur == null){
            return null;
        }

        if (cur.left != null){
            return cur.left;
        }else{
            return cur.right;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

//        node.right.right = new Node(7);

        Node result = new ConnectRightNode2().solution(node);
        System.out.println(result.val);
    }
}
