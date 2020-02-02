package com.chaexsy.practise.leetcode.utils;

import com.chaexsy.practise.leetcode.binarytree.TreeNode;

import java.util.List;

/**
 * @author Chaexsy 2020-01-11 12:13
 */
public class PrintUtil {
    private static TreePrinter<TreeNode> treePrinter = new TreePrinter<>(n -> ""+n.getVal(), n -> n.getLeft(), n -> n.getRight());
    private static TreePrinter<TreeNode> treePrinter2 = new TreePrinter<>(n -> ""+n.getVal()+"("+n.count+")", n -> n.getLeft(), n -> n.getRight());


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

    public static void printTree(TreeNode root){
        treePrinter.printTree(root);
    }

    public static void printTreeWithNum(TreeNode root){
        treePrinter2.printTree(root);
    }
}
