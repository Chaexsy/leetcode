package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 墙与门
 *
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * 示例：
 *
 * 给定二维网格：
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * 运行完你的函数后，该网格应该变成：
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 * @author yusijia 2019-08-10 10:57
 * @since v.0.1
 */
public class DoorAndWall {
    private static int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;

    // 上下左右四个方向
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );


    public static void main(String[] args){
        int[][] rooms = new int[4][4];
        rooms[0] = new int[]{INF, -1, 0, INF};
        rooms[1] = new int[]{INF, INF, INF, -1};
        rooms[2] = new int[]{INF, -1, INF, -1};
        rooms[3] = new int[]{0, -1, INF, INF};

        wallsAndGates2(rooms);

        System.out.println(Arrays.toString(rooms[0]));
        System.out.println(Arrays.toString(rooms[1]));
        System.out.println(Arrays.toString(rooms[2]));
        System.out.println(Arrays.toString(rooms[3]));
    }

    /**
     * 方法 1： 暴力
     * 暴力方法十分简单，我们只需要从每个空的房间开始做宽度优先搜索，找到最近的门即可。
     * 我们搜索的时候，用一个二维的数组，记作 distance ，记录从起点出发的距离。
     * 它也能隐含一个位置是否已经被访问过的信息，以免被重复放入队列。
     *
     * @param rooms
     */
    public static void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == INF) {
                    rooms[row][col] = distanceToNearestGate(rooms, row, col);
                }
            }
        }
    }


    /**
     * 广度优先算法(二维数组）
     *
     * @param rooms 二维数组
     * @eturn 返回从根节点到目标节点最短需要走几步
     */
    public static int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
        // m和n 是数组的边界
        int m = rooms.length;
        int n = rooms[0].length;

        int[][] distance = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        // 把空房间所在的位置作为起始点（根节点）开始搜索
        q.add(new int[] { startRow, startCol });

        while (!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];

            // 开始沿上下左右每个方向查找
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // 查找到了二维数组的边界，或者查找到了墙壁，或者已经找到门了，就停下来。
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == WALL
                        || distance[r][c] != 0) {
                    continue;
                }

                // 每走一步，距离就加1
                distance[r][c] = distance[row][col] + 1;
                if (rooms[r][c] == GATE) {
                    // 找到门了
                    return distance[r][c];
                }

                // 还没找到门，把这一个节点加入队列开始搜索
                q.add(new int[] { r, c });
            }
        }

        return INF;
    }


    /**
     * 方法 2：宽度优先搜索
     *
     * 与其从一个空的房间开始找门，我们何不按另一种方式来搜索？
     * 换言之，我们从门开始做宽度优先搜索。
     * 由于宽度优先搜索保证我们在搜索 d + 1 距离的位置时， 距离为 d 的位置都已经被搜索过了，
     * 所以到达每一个房间的时候都一定是最短距离
     * @param rooms
     */
    public static void wallsAndGates2(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;

        // 先搜索出所有门的位置，加入到queue
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();

            // 门所在的行和列
            int row = point[0];
            int col = point[1];

            // 沿四个方向搜索空房间
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // 如果到达了二维数组边界，或者搜索的房间不是空房间，就继续下一个目标
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != INF) {
                    continue;
                }

                // 如果搜索到空房间，设置空房间的值
                rooms[r][c] = rooms[row][col] + 1;
                // 把空房间加入下一个搜索目标
                q.add(new int[] { r, c });
            }
        }
    }
}
