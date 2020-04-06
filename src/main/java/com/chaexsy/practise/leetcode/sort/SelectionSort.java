package com.chaexsy.practise.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 思路：
 * 找到数组中最大的元素，与数组最后一位元素交换。
 * 当只有一个数时，则不需要选择了，因此需要n-1趟排序
 *
 * 代码实现要点：
 * 两个for循环，外层循环控制排序的趟数，内层循环找到当前趟数的最大值，随后与当前趟数组最后的一位元素交换。
 *
 * @author yusijia 2020-04-06 20:40
 * @since v.0.1
 */
public class SelectionSort {
    public int[] solution(int[] arrays){
        // 记录当前趟数最大值的下标
        int pos;
        // 交换的变量
        int temp;

        // 外层循环控制需要排序的趟数
        for (int i = 0; i < arrays.length-1; i++) {
            // 新的趟数，把下标重新设置为0
            pos = 0;

            // 内层循环控制遍历数组的个数并得到最大数的下标
            for(int j = 0; j < arrays.length - i; j++){
                if(arrays[j] > arrays[pos]){
                    pos = j;
                }
            }

            // 把最大数和数组末尾的数交换
            temp = arrays[pos];
            arrays[pos] = arrays[pos] = arrays[arrays.length-i-1];
            arrays[arrays.length-i-1] = temp;
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{5,3,4,2,1};
        arrays = new SelectionSort().solution(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
