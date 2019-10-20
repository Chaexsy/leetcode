package com.chaexsy.practise.leetcode.stack.exercises;

import java.util.*;

/**
 * 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水y1 包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 *
 * 思路（深度优先搜索）：
 * 1.遍历网格，以每一个陆地为起点进行深度优先搜索
 * 2.进行上下左右四个方向的搜索，如果搜索到陆地，则继续搜索
 * 3.已经搜索过的网格存储到哈希表，下次不再重复搜索
 * 4.如此可以保证把和 起点陆地相临的陆地全部搜索出来
 * 5.搜索完 一块陆地，岛屿数量就+1
 * 6.继续遍历下一个陆地，如果这个陆地之前已经被搜索过了，则不再重复搜索
 * 7.如果这个陆地没被搜索过，则继续2-5.
 *
 * @author yusijiayf1 2019-08-23 14:49
 */
public class IslandsNum {
    private final char WATER = '0';
    private final char LAND = '1';

    /**
     * 上下左右四个搜索方向
     */
    private final Map<String, int[]> DIRECTIONS = new HashMap<String, int[]>(){
        {
            put("left", new int[] { 0, -1});
            put("right", new int[] { 0,  1});
            put("up", new int[] {-1,  0});
            put("down", new int[] { 1,  0});
        }
    };



    public int numIslands(char[][] grids){
        int count = 0;
        Set<String> visited = new HashSet<>();

        for(int i=0; i<grids.length; i++){
            for(int j=0; j<grids[i].length; j++){
                if(grids[i][j] == LAND && !visited.contains(i + "-" + j)){
                    dfs(grids, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grids, int row, int col, Set<String> visited) {
        System.out.println("search node:{" + row + "," + col + "}");
        for(Map.Entry<String, int[]> entry:DIRECTIONS.entrySet()){
            int[] direction = entry.getValue();
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow>=grids.length || nextRow<0 || nextCol>=grids[0].length || nextCol<0){
                // 搜索到边界了，不再往这个方向搜索
                continue;
            }

            if(grids[nextRow][nextCol] == WATER){
                // 搜索到水了，不再往这个方向搜索
                continue;
            }

            // 搜索过的节点加入已搜索列表
            visited.add(row + "-" + col);

            if(visited.contains(nextRow + "-" + nextCol)){
                // 如果后面的节点已经搜索过了，就不再搜索
                continue;
            }

            // 继续搜索后面的节点
            dfs(grids, nextRow, nextCol, visited);
        }
    }


    public static void main(String[] args){
        char[][] grids1 = new char[4][5];
        grids1[0] = new char[]{'1','1','1','1','0'};
        grids1[1] = new char[]{'1','1','0','1','0'};
        grids1[2] = new char[]{'1','1','0','0','0'};
        grids1[3] = new char[]{'0','0','0','0','0'};

        System.out.println("grids1 has " + new IslandsNum().numIslands(grids1) + " islands.");

        char[][] grids2 = new char[4][5];
        grids2[0] = new char[]{'1','1','0','0','0'};
        grids2[1] = new char[]{'1','1','0','0','0'};
        grids2[2] = new char[]{'0','0','1','0','0'};
        grids2[3] = new char[]{'0','0','0','1','1'};
        System.out.println("grids2 has " + new IslandsNum().numIslands(grids2) + " islands.");
    }
}
