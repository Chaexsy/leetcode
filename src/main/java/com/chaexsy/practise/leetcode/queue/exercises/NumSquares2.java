package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 思路：
 * 当每一次都可以判断出多种情况，有多次的时候就适合用BFS-广度优先遍历
 * 使用BFS应注意：
 * 队列：用来存储每一轮遍历得到的节点；
 * 标记：对于遍历过的节点，应该将它标记，防止重复遍历。
 * 我们将它第一个平方数可能出现的情况做分析 只要 i * i < n 就行
 * 再在此基础上进行二次可能出现的平方数分析
 * 注意：为了节省遍历的时间，曾经（ n - 以前出现的平方数） 这个值出现过，则在此出现这样的数时直接忽略。
 *
 * @author yusijiayf1 2019-08-20 9:19
 */
public class NumSquares2 {

    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        boolean record[] = new boolean[n];
        while (!queue.isEmpty()) {
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            // 每一层的广度遍历
            for (int i = 1;; i++) {
                int nextVal = val - i * i;
                // 说明已到最大平方数
                if (nextVal < 0)
                    break;

                // 由于是广度遍历，所以当遍历到0时，肯定是最短路径
                if(nextVal == 0)
                    return step;

                // 当再次出现时没有必要加入，因为在该节点的路径长度肯定不小于第一次出现的路径长
                if(!record[nextVal]){
                    queue.add(new Node(nextVal,step + 1));
                    record[nextVal] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        System.out.println(new NumSquares2().numSquares(12311));
        Long endTime = System.currentTimeMillis();
        System.out.println("Cost time: " + (endTime-startTime));
    }
}
