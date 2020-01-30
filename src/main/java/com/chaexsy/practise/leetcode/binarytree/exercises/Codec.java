package com.chaexsy.practise.leetcode.binarytree.exercises;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * @author Chaexsy 2020-01-30 19:43
 */
public class Codec {
    /**
     * 序列化方法1
     * 按层遍历树，广度优先搜索
     */
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                result.append("null").append(",");
            }else{
                result.append(node.val).append(",");

                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return result.toString().substring(0, result.length()-1);
    }

    /**
     * 反序列化方法1
     * 根据分层遍历的结果一层一层地把树搭起来
     */
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }

        String[] nodeStrs = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodeStrs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if("null".equals(nodeStrs[index])){
                node.left = null;
            }else{
                node.left = new TreeNode(Integer.parseInt(nodeStrs[index]));
                queue.add(node.left);
            }
            index++;
            if("null".equals(nodeStrs[index])){
                node.right = null;
            }else{
                node.right = new TreeNode(Integer.parseInt(nodeStrs[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = new Codec().serialize(root);
        System.out.println(str);
        TreeNode deserializeTree = new Codec().deserialize(str);
        System.out.println(deserializeTree.val);

    }
}
