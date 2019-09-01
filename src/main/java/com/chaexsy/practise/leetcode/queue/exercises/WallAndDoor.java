package com.chaexsy.practise.leetcode.queue.exercises;

import java.util.*;

/**
 * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
 *
 * -1 表示墙或是障碍物
 * 0 表示一扇门
 * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
 * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
 *
 * 思路：
 * 1.遍历二维数组，找出空房间，以每个空房间为原点进行广度优先搜索
 * 2.每个空房间为一个节点（Node）加入待搜索队列，节点存储房间位置、当前搜索的深度、该节点需要搜索的方向。
 * 3.这种解法的关键在于需要控制一下搜索方向：
 *   将空房间隔壁的房间加入待搜索队列时，需要注意方向。
 *   比如搜索左边的空房间时，就设置左边空房间的搜索方向为左，上，下，不搜索右边，
 *   因为如果左边的房间搜索右边，等于又搜索到自己，会造成死循环。
 *
 * @author yusijiayf1 2019-08-23 9:43
 */
public class WallAndDoor {
    class Node{
        int row;
        int col;
        int step;
        String[] directions;

        Node(int row, int col, int step, String[] directions){
            this.row = row;
            this.col = col;
            this.step = step;
            this.directions = directions;
        }
    }

    private static final int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;

    /**
     * 上下左右四个方向
     */
    private static final Map<String, int[]> DIRECTIONS = new HashMap<String, int[]>(){
        {
            put("left", new int[] { 0, -1});
            put("right", new int[] { 0,  1});
            put("up", new int[] {-1,  0});
            put("down", new int[] { 1,  0});
        }
    };

    public void beginSearch(int[][] rooms){
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[i].length; j++){
                if(rooms[i][j] == INF){
                    // 初始节点，搜索上下左右四个方向
                    search(rooms, new Node(i,j,0, new String[]{"left", "right", "up", "down"}));
                }
            }
        }
    }

    public void search(int[][] rooms, Node room){
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Node> queue = new LinkedList<>();
        queue.add(room);

        boolean findGate = false;
        while (!queue.isEmpty() && !findGate){
            Node node = queue.poll();
            int row = node.row;
            int col = node.col;
            int step = node.step;

            for(String dir:node.directions){
                int[] direction = DIRECTIONS.get(dir);
                int r = row + direction[0];
                int c = col + direction[1];

                if(r>=m || r<0 || c>=n || c<0){
                    // 搜索到了数字边界，不再搜索
                    continue;
                }

                if(rooms[r][c] == GATE){
                    // 搜索到门了，设置目标房间到门的距离
                    rooms[room.row][room.col] = step+1;
                    findGate = true;
                    break;
                }else if(rooms[r][c] != WALL){
                    // 不是门，也不是墙，肯定是已经搜索过的或者没搜索过的房间
                    // 加入待搜索队列，继续下一个深度的搜索
                    queue.add(new Node(r, c, step+1, getNextDirections(dir)));
                }
            }
        }
    }

    private String[] getNextDirections(String dir){
        String[] result = null;
        switch (dir){
            case "left":
                result = new String[]{"left", "up", "down"};
                break;
            case "right":
                result = new String[]{"right", "up", "down"};
                break;
            case "up":
                result = new String[]{"left", "right", "up"};
                break;
            case "down":
                result = new String[]{"left", "right", "down"};
                break;
                default:
                result = new String[0];
        }

        return result;
    }

    public static void main(String[] args){
        int[][] arr = new int[4][4];
        arr[0] = new int[]{INF,  -1,   0,    INF};
        arr[1] = new int[]{INF,  INF,  INF,  -1};
        arr[2] = new int[]{INF,  -1,   INF,  -1};
        arr[3] = new int[]{0,    -1,   INF,  INF};

        new WallAndDoor().beginSearch(arr);

        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
        System.out.println(Arrays.toString(arr[3]));
    }
}
