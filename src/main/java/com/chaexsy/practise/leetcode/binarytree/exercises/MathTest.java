package com.chaexsy.practise.leetcode.binarytree.exercises;

import java.util.Scanner;

/**
 * @author Chaexsy 2020-01-29 22:05
 */
public class MathTest {
    public static void main(String[] args) {
        while (true){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入第1个数：");
                int num1 = scanner.nextInt();
                System.out.print("请输入第2个数：");
                int num2 = scanner.nextInt();
                System.out.print("请输入第3个数：");
                int num3 = scanner.nextInt();
                int sum = num1 + num2 + num3;

                System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + sum);
            }catch (Exception e){
                System.out.println("小朋友，你的输入有错误");
            }

        }
    }
}
