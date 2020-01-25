package com.chaexsy.practise.leetcode.binarysearch;

/**
 * 猜数字大小
 *
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 * @author Chaexsy 2020-01-24 14:30
 */
public class GuessNumber {
    public int solution(int n) {
        int left = 1, right = n;
        while (left <= right){
            int middle = left + (right-left)/2;
            int res = guess(middle);
            if(res == 0){
                return middle;
            }else if(res < 0){
                right = middle - 1;
            }else if(res > 0){
                left = middle + 1;
            }
        }

        return -1;
    }

    private int guess(int num){
        int pick = 6;
        if(num == pick)
            return 0;
        else if(num > pick)
            return 1;
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumber().solution(10));
    }
}
