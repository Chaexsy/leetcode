package com.chaexsy.practise.leetcode.arrayAndString.exercises;

/**
 * 数组中出现超过一半的数字
 *
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * @author yusijiayf1 2019-12-16 17:13
 */
public class OverHalfArray {
    /**
     * 解法1：
     *
     * 如果一个数出现的次数超过数组一半的长度，那么就是说出现的次数比其他所有数字出现的次数还要多。
     * 因此我们可以考虑保存2个值，一个是数组中的一个数，一个是数的次数。
     * 当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1，如果不同则次数减1。
     * 如果次数为0了这保存当前遍历到的数，并把次数设为1。
     * 遍历完整个数组之后，返回当前保存的数字，即是我们要找的数字。
     */
    public int solution(int[] arr){
        int num = 0;
        int time = 0;
        for(int i=0; i<arr.length; i++){
            if(time == 0){
                num = arr[i];
                time++;
                System.out.println("In process --> num: " + num + ", arr[i]: " + arr[i] + ", time++ --> time: " + time);
            }else {
                if(num == arr[i]){
                    time++;
                    System.out.println("In process --> num: " + num + ", arr[i]: " + arr[i] + ", time++ --> time: " + time);
                }else{
                    time--;
                    System.out.println("In process --> num: " + num + ", arr[i]: " + arr[i] + ", time-- --> time: " + time);
                }
            }
        }

        if(time > 0){
            System.out.println("Result --> num: " + num + ", times: " + time);
            return num;
        }else {
            System.out.println("Result --> num: " + 0 + ", times: " + time);
            return 0;
        }
    }

    public static void main(String[] args){
//        int[] numbers = {3,1,3,2,3,2,3,3,2};
        int[] numbers = {2,1,2,2,3,2,3};
        new OverHalfArray().solution(numbers);
    }
}
