package com.chaexsy.practise.leetcode.utils;

/**
 * @author Chaexsy 2020-01-11 12:13
 */
public class PrintUtil {
    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            if(i == arr.length-1){
                System.out.println();
            }else{
                System.out.print(",");
            }
        }
    }
}
