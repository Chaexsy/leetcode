package com.chaexsy.practise.leetcode.arrayAndString.exercises;

import java.util.Queue;

/**
 *  二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author Chaexsy 2019-12-09 8:25
 */
public class BinarySum {
    public String addBinary(String a, String b) {
        String result = "";

        int maxLength = Math.max(a.length(), b.length());

        if(a.length() < maxLength){
            int num = maxLength - a.length();
            String prefix = "";
            for(int i=0; i<num; i++){
                prefix += "0";
            }
            a = prefix + a;
        }
        if(b.length() < maxLength){
            int num = maxLength - b.length();
            String prefix = "";
            for(int i=0; i<num; i++){
                prefix += "0";
            }
            b = prefix + b;
        }

        int pointer = maxLength - 1;

        // 进位
        int carry = 0;

        while (pointer>=0) {
            int ca = a.length()>pointer ? a.charAt(pointer) - '0': 0;
            int cb = b.length()>pointer ? b.charAt(pointer) - '0': 0;
            int cc = ca + cb;

            if(carry > 0){
                cc += carry--;
            }

            if(cc == 3){
                result = "1" + result;
                carry++;
            }else if(cc == 2){
                result = "0" + result;
                carry++;
            }else if(cc == 1){
                result = "1" + result;
            }else{
                result = "0" + result;
            }

            pointer--;
        }

        if(carry > 0){
            result = "1" + result;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(new BinarySum().addBinary("11", "1"));
        System.out.println(new BinarySum().addBinary("1010", "1011"));

//        int x = '1' - '0';
//        int y = '0' - '0';
//        System.out.println("x: " + x + ", y:" + y);
    }
}
