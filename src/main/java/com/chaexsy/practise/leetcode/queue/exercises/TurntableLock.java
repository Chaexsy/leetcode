package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.*;

/**
 * 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 思路：
 * 1.以 0000 为原点，逐层向外层进行广度优先搜索
 * 2.每个节点外往外层搜索时，因为 锁有4位，而每一位都可以向上转或者向下转，所以每个节点都有8个子节点
 * 3.搜索过的节点接入死亡数字数组，不再搜索
 *
 * 关键有3点
 * 1. 死亡数字和搜索过的数字，相当于不能走的路，不用搜索
 * 2. 每个节点都有8个子节点，例如 0000，下一步可以搜索 1000,9000,0100,0900,0010,0090,0001,0009
 * 3. 搜索完一层的节点，深度才+1
 *
 * @author yusijiayf1 2019-08-23 16:05
 */
public class TurntableLock {

    public int openLock(String[] deadends, String target){
        int result = -1;

        char[] pos = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        Set<String> deadEndsSet = new HashSet<>(Arrays.asList(deadends));

        if(target == null || target.length() == 0 || deadEndsSet.contains("0000")){
            return -1;
        }

        LinkedList<String> list = new LinkedList<>();
        list.add("0000");

        int depth = 0;
        while (!list.isEmpty()){
            int size = list.size();
            // 搜索这一层的节点之前，先把这一层的节点长度取出来
            // 避免加了子节点后，就不知道这一层哪些是父节点哪些是子节点了
            while (size-- > 0) {
                String str = list.removeFirst();
                if (str.equals(target)) {
                    return depth;
                }
                if (!deadEndsSet.contains(str)) {
                    deadEndsSet.add(str);
                    list.addAll(getNextList(str, pos));
                }
            }
            //每一层遍历完，深度加一
            depth++;
        }

        return result;
    }

    private List<String> getNextList(String str, char[] pos) {
        List<String> res = new ArrayList<>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            char[] newChars = chars.clone();
            newChars[i] = pos[(num + 1) % 10];     //数字加一
            res.add(new String(newChars));
            newChars[i] = pos[(num + 9) % 10];      //数字减一
            res.add(new String(newChars));
        }
        return res;
    }

    public static void main(String[] args){
        String[] deadends1 = new String[]{"0201","0101","0102","1212","2002"};
        String target1 = "0202";
        System.out.println("1. min turn times: " + new TurntableLock().openLock(deadends1, target1));

        String[] deadends2 = new String[]{"8888"};
        String target2 = "0009";
        System.out.println("2. min turn times: " + new TurntableLock().openLock(deadends2, target2));

        String[] deadends3 = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";
        System.out.println("3. min turn times: " + new TurntableLock().openLock(deadends3, target3));

        String[] deadends4 = new String[]{"0000"};
        String target4 = "8888";
        System.out.println("4. min turn times: " + new TurntableLock().openLock(deadends4, target4));
    }
}
