package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 1.数字 1-9 在每一行只能出现一次。
 * 2.数字 1-9 在每一列只能出现一次。
 * 3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author Chaexsy 2020-01-16 23:33
 */
public class IsValidSudoku {
    /**
     * 该解法多次使用 list.contain方法导致性能较差
     * 可用其他方式代替list
     */
    public boolean solution(char[][] board) {
        // key: 行号，value：出现过的数字
        Map<Integer, List<Character>> rowMap = new HashMap<>();
        // key: 列号，value：出现过的数字
        Map<Integer, List<Character>> colMap = new HashMap<>();
        // key: 宫号，value：出现过的数字
        Map<Integer, List<Character>> palaceMap = new HashMap<>();

        for(int i=0; i<board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.'){
                    rowMap.putIfAbsent(i, new ArrayList<>());
                    colMap.putIfAbsent(j, new ArrayList<>());
                    int palaceIndex = getPalaceIndex2(i,j);
                    palaceMap.putIfAbsent(palaceIndex, new ArrayList<>());

                    if(rowMap.get(i).contains(board[i][j])
                            || colMap.get(j).contains(board[i][j])
                            || palaceMap.get(palaceIndex).contains(board[i][j])){
                        return false;
                    }else{
                        rowMap.get(i).add(board[i][j]);
                        colMap.get(j).add(board[i][j]);
                        palaceMap.get(palaceIndex).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    /**
     * 更好的判断元素属于9宫格的哪一宫的方法
     *
     * @param row 行号
     * @param col 列号
     * @return 宫号
     */
    public Integer getPalaceIndex2(int row, int col){
        return row / 3 * 3 + col / 3;
    }

    /**
     * 判断元素属于9宫格的哪一宫
     *
     * @param row 行号
     * @param col 列号
     * @return 宫号
     */
    public Integer getPalaceIndex(int row, int col){
        if(row <=2 && col<=2)
            return 1;
        else if(row <= 2 && col <= 5)
            return 2;
        else if(row <= 2 && col <= 8)
            return 3;
        else if(row <= 5 && col <= 2)
            return 4;
        else if(row <= 5 && col <= 5)
            return 5;
        else if(row <= 5 && col <= 8)
            return 6;
        else if(row <= 8 && col <= 2)
            return 7;
        else if(row <= 8 && col <= 5)
            return 8;
        else
            return 9;
    }

    public static void main(String[] args) {
        System.out.print(new IsValidSudoku().getPalaceIndex2(0,0));
        System.out.print(new IsValidSudoku().getPalaceIndex2(2,2));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(0,3));
        System.out.print(new IsValidSudoku().getPalaceIndex2(2,5));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(0,6));
        System.out.print(new IsValidSudoku().getPalaceIndex2(2,8));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(3,0));
        System.out.print(new IsValidSudoku().getPalaceIndex2(5,2));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(3,3));
        System.out.print(new IsValidSudoku().getPalaceIndex2(5,5));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(3,6));
        System.out.print(new IsValidSudoku().getPalaceIndex2(5,8));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(6,0));
        System.out.print(new IsValidSudoku().getPalaceIndex2(8,2));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(6,3));
        System.out.print(new IsValidSudoku().getPalaceIndex2(8,5));
        System.out.print(",");
        System.out.print(new IsValidSudoku().getPalaceIndex2(6,6));
        System.out.print(new IsValidSudoku().getPalaceIndex2(8,8));

    }
}
