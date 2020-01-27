package com.chaexsy.practise.leetcode.utils;

import java.util.List;

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

    public static void printArray(String[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            if(i == arr.length-1){
                System.out.println();
            }else{
                System.out.print(",");
            }
        }
    }

    public static <T> void  printList(List<T> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != null){
                System.out.print(list.get(i).toString());
            }else{
                System.out.print("null");
            }

            if(i == list.size()-1){
                System.out.println();
            }else{
                System.out.print(",");
            }
        }
    }
}
