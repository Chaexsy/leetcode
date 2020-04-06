package com.chaexsy.practise.leetcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 思路：
 * 俩俩交换，大的放在后面，第一次排序后最大值已在数组末尾。
 * 因为俩俩交换，需要n-1趟排序（比如10个数，需要9趟排序）
 *
 * 代码实现要点：
 * 两个for循环，外层循环控制排序的趟数，内层循环控制比较的次数。
 * 每趟过后，比较的次数都应该要减1，
 * 因为每次比较完以后，队尾都多了一个按顺序排序的大数，没有必要再比较了。
 *
 * @author yusijia 2020-04-06 20:17
 * @since v.0.1
 */
public class BubblingSort {

    public int[] solution(int[] arrays){
        // 装载临时变量
        int temp;
        // 记录是否发生了置换，0没有，1有
        int isChange;
        // 记录执行了多少趟
        int num = 0;

        // 外层循环是排序的趟数
        for(int i = 0; i < arrays.length-1; i++){
            // 每比较一趟就初始化为0
            isChange = 0;
            // 内层循环是当前趟数需要比较的次数
            for (int j = 0; j < arrays.length-i-1; j++) {
                // 前一位和后一位比较，如果前一位比后一位大，那么交换
                if(arrays[j] > arrays[j + 1]){
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;

                    isChange = 1;
                }
            }

            if(isChange == 0 ){
                break;
            }

            num++;
        }

        System.out.println("执行了 " + num + " 趟。");
        return arrays;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{5,1,2,3,4};
        arrays = new BubblingSort().solution(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
