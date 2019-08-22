package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.*;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @author yusijiayf1 2019-08-20 13:50
 */
public class NumSquares3 {
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }


    public static void main(String[] args){
        Long startTime = System.currentTimeMillis();
        System.out.println(new NumSquares3().ns(12311));
        Long endTime = System.currentTimeMillis();
        System.out.println("cost times: " + (endTime - startTime));
    }

    public int ns(int n) {
        Queue<Node> queue = new LinkedList<>();
        if(n <=0 ){
            return -1;
        }

        //  已经搜索过的节点值列表
        boolean[] searchedNodeValueList = new boolean[n];

        // 起点是0
        queue.add(new Node(0,0));

        //广度优先遍历
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 子节点里面已经判断过了节点值和目标数字是否相等
            // 所以 node的值肯定不等于目标数字，不需要再比对
            // 直接搜索子节点就行了

            // 把开始搜索子节点
            for (int i = 1; i <= n; i++) {
                // node子节点的数字是 node自身的值 加上 1*1, 2*2, 3*3, 4*4...
                int value = node.val + i*i;

                // 子节点的数字最大不能超过目标数字
                if(value > n){
                    break;
                }

                if (value == n) {
                    // 子节点值和目标数字相同，直接返回子节点深度，不用在搜索了
                    return (node.step+1);
                }

                if(!searchedNodeValueList[value]){
                    Node subNode = new Node(value, node.step+1);
                    queue.add(subNode);
                    // 搜索过的子节点 加入已搜索列表
                    searchedNodeValueList[subNode.val] = true;
                }
            }
        }
        return -1;
    }
}
