package com.chaexsy.practise.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 思路：
 * 将一个元素插入到已有序的数组中，在初始时未知是否存在有序的数据，因此将元素第一个元素看成是有序的。
 * 与有序的数组进行比较，比它大则直接放入，比它小则移动数组元素的位置，找到个合适的位置插入。
 * 当只有一个数时，则不需要插入了，因此需要n-1趟排序
 *
 * 代码实现：
 * 一个for循环内嵌一个while循环实现，外层for循环控制需要排序的趟数，while循环找到合适的插入位置(并且插入的位置不能小于0)。
 *
 * @author yusijia 2020-04-06 20:56
 * @since v.0.1
 */
public class InsertionSort {
    public int[] solution(int[] arrays){
        // 临时变量
        int temp;

        // 外层循环控制需要排序的趟数（从1开始因为将第0位看成了有序数据）
        for (int i = 1; i < arrays.length; i++) {

            temp = arrays[i];

            // 如果前一位（已排序的数据）比当前数据大，那么就进入循环比较（参考第二趟排序）
            int j = i-1;
            while (j >= 0 && arrays[j] > temp){
                // 往后退一个位置，让当前数据与之前前位进行比较
                arrays[j+1] = arrays[j];
                // 不断往前，直到退出循环
                j--;
            }

            // 退出了循环说明找到合适的位置了，将当前数据插入到合适的位置中
            arrays[j+1] = temp;
        }

        return arrays;

    }

    public static void main(String[] args) {
        int[] arrays = new int[]{5,3,4,2,1};
        arrays = new InsertionSort().solution(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
