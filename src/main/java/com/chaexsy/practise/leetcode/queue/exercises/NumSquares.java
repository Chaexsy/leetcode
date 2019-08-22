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
 *
 * 思路：
 * 1.先计算出n以内的完全平方数列表。
 * 2.从0出发，第一步 可以走到 1,4,9....
 * 3.第二步, 从1,4,9出发，每个节点又可以走1,4,9
 * 4.由此记录走过的路径 0-1-4, 0-1-9, 0-1-1...
 * 5.如果路径上的数字和 和 n 相等，就返回路径走过的步数。
 * 6.路径和相同的路径已存在时，就不重复走了。
 *
 * 优点：广度优先，每个节点的子节点就是所有完全平方数，记录路径，比对路径数字和和n是否相等，思路明确简单。
 * 缺点：随着搜索深度的增加，需要搜索的节点呈指数级上升，搜索节点和判断新路径要不要搜索都需要耗费大量资源，时间复杂度和空间复杂度都有问题。
 * @author yusijiayf1 2019-08-19 11:44
 */
public class NumSquares {
    /**
     * 每一轮 待搜索的完全平方数列表
     */
    private List<Integer> sqrtNumList;

    /**
     * 已经搜索的路径列表
     */
    private Map<Integer, String> searchedPathList;



    public static void main(String[] args){
        Long startTime = System.currentTimeMillis();
        NumSquares numSquares = new NumSquares();
        numSquares.ns(1311);
        Long endTime = System.currentTimeMillis();
        System.out.println("cost times: " + (endTime - startTime));
    }

    public int ns(int n) {
        LinkedList<String> list = new LinkedList<>();
        if(n <=0 ){
            return -1;
        }

        // 初始化完全平方数数组
        Long startTime = System.currentTimeMillis();
        sqrtNumList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(isSquares(i)){
                sqrtNumList.add(i);
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("init sqrt list cost times: " + (endTime - startTime));

        searchedPathList = new HashMap<>();

        // 起点是0
        list.add("0");
        //广度优先遍历
        while (!list.isEmpty()) {
            String path = list.removeFirst();

            System.out.println("Begin compare path: " + path);

            int pathNum = transPath2Num(path);

            if (pathNum == n) {
                System.out.println("Find it! path: " + path + ", depth: " + getPathDepth(path));
                return getPathDepth(path);
            }else{
                searchedPathList.put(pathNum, path);
                list.addAll(getNextPathList(path));
            }
        }
        return -1;
    }

    /**
     * 获取路径的深度
     * eg: 路径 0-9-4，深度 2
     * 0是原点，9,4 就是走了两步，所以深度是2。
     *
     * @param path 0-9-4
     * @return 2
     */
    private Integer getPathDepth(String path){
       return path.split("-").length - 1;
    }

    /**
     * 获取下一批要遍历的路径
     * 路径 = 当前路径 + 完全平方数
     *
     * @param currentPath 当前路径
     * @return ['0-9-1', '0-9-4', '0-9-9'...]
     */
    private List<String> getNextPathList(String currentPath) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < sqrtNumList.size(); i++) {
            String path = currentPath + "-" + sqrtNumList.get(i);
            if(validPath(path)){
                res.add(path);
            }
        }

        return res;
    }

    private boolean validPath(String path){
        if(searchedPathList.get(transPath2Num(path)) != null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 把路径上的数字相加得出路径的和
     *
     * @param path 0-1-4-9
     * @return 14
     */
    private Integer transPath2Num(String path){
        Integer num = 0;
        String[] arr = path.split("-");
        for(int i=0; i<arr.length; i++){
            num += Integer.parseInt(arr[i]);
        }

        return num;
    }

    /**
     * 判断一个正整数是否是完全平方数
     *
     * 用Math类sqrt开方，把结果强制转换为int类型，然后将结果计算乘方，
     * 判断是否和原来的数相等，相等就是完全平方数。
     */
    private boolean isSquares(int value) {
        if (value < 0) {
            return false;
        }
        double sqrtValue = Math.sqrt(value * 1.0);
        int sqrtSimiValue = (int) sqrtValue;
        if ((sqrtSimiValue * sqrtSimiValue) == value) {
            return true;
        } else {
            return false;
        }
    }
}
