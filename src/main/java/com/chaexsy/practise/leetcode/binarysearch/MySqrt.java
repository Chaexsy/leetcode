package com.chaexsy.practise.leetcode.binarysearch;

/**
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * @author Chaexsy 2020-01-24 13:52
 */
public class MySqrt {
    public int solution(int x) {
        long left = 0;
        // 一般数字的一半加1总是大于它的平方根，所以定这个值作为搜索边界
        long right = x/2 + 1;

        while (left <= right){
            long middle = (left + right)/2;
            long square = middle * middle;
            long nextSquare = (middle+1) * (middle+1);
            if(square == x){
                return (int)middle;
            }else if(square < x){
                if(nextSquare > x){
                    // 该补丁是为了应对 8的平方根应输出2这种情况。
                    // 2*2 < 8
                    // 3*3 > 8
                    return (int)middle;
                }
                left = middle + 1;
            }else if(square > x){
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().solution(2147395599));
    }
}
