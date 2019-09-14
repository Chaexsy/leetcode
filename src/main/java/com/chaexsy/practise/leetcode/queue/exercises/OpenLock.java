package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.*;

/**
 * 打开转盘锁
 *
 * @author yusijia 2"0"19-"0"8-11 11:18
 * @since v."0".1
 */
public class OpenLock {
    private static String[] initStatus = {"0","0","0","0"};
    private static String[][] grid = new String[10][4];

    // 上下两个方向
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0}
    );

    static {
        grid[0] = new String[]{"0","0","0","0"};
        grid[1] = new String[]{"1","1","1","1"};
        grid[2] = new String[]{"2","2","2","2"};
        grid[3] = new String[]{"3","3","3","3"};
        grid[4] = new String[]{"4","4","4","4"};
        grid[5] = new String[]{"5","5","5","5"};
        grid[6] = new String[]{"6","6","6","6"};
        grid[7] = new String[]{"7","7","7","7"};
        grid[8] = new String[]{"8","8","8","8"};
        grid[9] = new String[]{"9","9","9","9"};
    }

    public static void main(String[] args){
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        int step = openLock(deadends, target);
        System.out.println("Step: " + step);
    }

    /**
     * 用一个队列保存要遍历的数字，从根节点 ‘0000’ 出发，将下一个遍历节点加到队列中，注意两点：
     *
     * 遍历过的节点放到死亡数字中，避免后续再遇到
     * 遇到给定的数字，直接返回当前深度，由于是一层一层往下遍历，最先遇到的节点肯定是路径最短的
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {
        //用来将数字转换为char的查询表
        char[] pos = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        Set<String> deadEndsSet = new HashSet<>(Arrays.asList(deadends));

        LinkedList<String> list = new LinkedList<>();
        if(target == null || target.length() == 0 || deadEndsSet.contains("0000")){
            return -1;
        }

        list.add("0000");
        int depth = 0;
        //广度优先遍历
        while (!list.isEmpty()) {
            int size = list.size();
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
        return -1;
    }

    private static List<String> getNextList(String str, char[] pos) {
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            char[] newChars = chars.clone();
            newChars[i] = pos[(num + 11) % 10];     //数字加一
            res.add(new String(newChars));
            newChars[i] = pos[(num + 9) % 10];      //数字减一
            res.add(new String(newChars));
        }
        return res;
    }
}
