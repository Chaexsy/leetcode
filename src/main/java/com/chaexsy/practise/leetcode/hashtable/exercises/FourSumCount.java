package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author Chaexsy 2020-01-18 22:40
 */
public class FourSumCount {
    /**
     * 解法1：
     * 暴力4重for循环 -。-
     */
    public int solution(int[] A, int[] B, int[] C, int[] D) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int l = 0; l < D.length; l++) {
                        if(A[i] + B[j] + C[k] + D[l] == 0){
                            num ++;
                        }
                    }
                }
            }
        }

        return num;
    }

    /**
     * 解法2：
     * 题目说0<=N<=500
     * 1.如果采用暴力解法O(n^4)
     * 500^4=62500000000 这样计算机承受不了
     * 2.利用查找表将D放入查找表中 遍历A、B、C在查找表中找是否存在-A、-B、-C
     * 这样的话时间复杂度为O(n^3)
     * 500^3=125000000还是太大了
     * 3.如果能将其化解为O(n^2)的算法
     * 500^2=250000这样是可以接受的
     * 故只需要将C+D的每一种可能放入查找表（map）
     * 这样我们只需要寻找这个表里面有没有-A-B就行了
     * 有的话则A+B+C+D=0，然后统计一下个数
     *
     * 将数组C，D 任意组合的和存入查找表中， key是和，value 是出现的次数。记录A，B 任意组合的和的负值，然后在查找表中查找是否有对应的值
     * 时间复杂度：O(n^2。
     */
    public int solution2(int[] A, int[] B, int[] C, int[] D){
        int result = 0;

        // key C和D的合，value 和出现的次数
        Map<Integer, Integer> cdSum = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = C[i] + D[j];
                cdSum.merge(key, 1, (prev, one)->{
                    return prev + one;
                });
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(cdSum.containsKey(-A[i] - B[j])){
                    result+=cdSum.get(-A[i] - B[j]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{1, 2};
//        int[] B = new int[]{-2,-1};
//        int[] C = new int[]{-1, 2};
//        int[] D = new int[]{0, 2};
        int[] A = new int[]{-1, -1};
        int[] B = new int[]{-1,1};
        int[] C = new int[]{-1, 1};
        int[] D = new int[]{1, -1};

        System.out.println(new FourSumCount().solution2(A,B,C,D));
    }
}
