package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
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
 * 思路：
 * 1.遍历网格，以每一个陆地为起点进行广度优先搜索
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
    private final int WARTER = 0;
    private final int LAND = 1;

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

    /**
     * 已经搜索过的节点
     */
    private Map<String, Boolean> searched;



    public int beginSearch(int[][] grids){
        int result = 0;
        searched = new HashMap<>();

        for(int i=0; i<grids.length; i++){
            for(int j=0; j<grids[i].length; j++){
                if(grids[i][j] == LAND && searched.get(i+"-"+j) == null){
                    result += search(grids, i, j);
                }
            }
        }

        return result;
    }

    public int search(int[][] grids, int row, int col){
        int result = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        searched.put(row+"-"+col, true);

        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            for(Map.Entry<String, int[]> entry:DIRECTIONS.entrySet()){
                int[] direction = entry.getValue();
                int nextRow = r + direction[0];
                int nextCol = c + direction[1];

                if(nextRow>=grids.length || nextRow<0 || nextCol>=grids[0].length || nextCol<0){
                    // 搜索到边界了，不再往这个方向搜索
                    continue;
                }

                if(grids[nextRow][nextCol] == WARTER){
                    // 搜索到水了，不再往这个方向搜索
                    continue;
                }

                if(searched.get(nextRow+"-"+nextCol) != null){
                    // 已经搜索过的节点不再搜索
                    continue;
                }

                searched.put(nextRow+"-"+nextCol, true);
                queue.add(new int[]{nextRow, nextCol});
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] grids1 = new int[4][5];
        grids1[0] = new int[]{1,1,1,1,0};
        grids1[1] = new int[]{1,1,0,1,0};
        grids1[2] = new int[]{1,1,0,0,0};
        grids1[3] = new int[]{0,0,0,0,0};

        System.out.println("grids1 has " + new IslandsNum().beginSearch(grids1) + " islands.");

        int[][] grids2 = new int[4][5];
        grids2[0] = new int[]{1,1,0,0,0};
        grids2[1] = new int[]{1,1,0,0,0};
        grids2[2] = new int[]{0,0,1,0,0};
        grids2[3] = new int[]{0,0,0,1,1};
        System.out.println("grids2 has " + new IslandsNum().beginSearch(grids2) + " islands.");
    }
}
