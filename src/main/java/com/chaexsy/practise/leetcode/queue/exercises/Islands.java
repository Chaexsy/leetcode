package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.*;

/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 *
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * @author yusijia 2019-08-10 13:05
 * @since v.0.1
 */
public class Islands {
    private static final char LAND = '1';
    private static final char WATER = '0';
    private static int islandNum = 0;
    private static Map<String, Integer> used;

    // 上下左右四个方向
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public static void main(String[] args) {
        used = new HashMap<>();

        char[][] grid = new char[4][5];
//        grid[0] = new char[]{'1','1','0','0','0'};
//        grid[1] = new char[]{'1','1','0','0','0'};
//        grid[2] = new char[]{'0','0','1','0','0'};
//        grid[3] = new char[]{'0','0','0','1','1'};
        grid[0] = new char[]{'1','1','1','1','0'};
        grid[1] = new char[]{'1','1','0','1','0'};
        grid[2] = new char[]{'1','1','0','0','0'};
        grid[3] = new char[]{'0','0','0','0',0};


        numIslands(grid);
        System.out.println("Island num: " + islandNum);
    }

    public static void numIslands(char[][] grid) {
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                if(grid[row][col] == LAND){
                    searchIsland(grid, row, col);
                }
            }
        }
    }

    public static void searchIsland(char[][] grid, int startRow, int startCol) {
        if(used.get(startRow+"-"+startCol) != null){
            return;
        }


        // m和n 是数组的边界
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        // 把随便一块陆地所在的位置作为起始点（根节点）开始搜索
        q.add(new int[] { startRow, startCol });

        while (!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];

            used.put(startRow+"-"+startCol, 1);

            // 开始沿上下左右每个方向查找
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // 巡检过的网格不在重复巡检
                if(used.get(r+"-"+c) == null){
                    used.put(r+"-"+c, 1);
                }else{
                    continue;
                }


                // 查找到了二维数组的边界，或者查找到了墙壁，或者已经找到水了，就停下来。
                if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == WATER) {
                    continue;
                }

                // 还没找到水，把这一个节点加入队列开始搜索
                q.add(new int[] { r, c });
            }
        }

        islandNum++;
    }
}
