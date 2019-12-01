package com.chaexsy.practise.leetcode.arrayAndString.exercises;

/**
 * 对角线遍历
 *
 * @author Chaexsy 2019-12-01 21:00
 */
public class DiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int MAX_ROW = matrix.length;
        int MAX_COL = matrix[0].length;
        int[] res = new int[MAX_ROW * MAX_COL];

        int row = 0;
        int col = 0;

        int index = 0;
        boolean down = false;
        while(index < res.length) {
            // 初始化
            res[index++] = matrix[row][col];

            if (!down) {
                // 向斜上方遍历
                if (col == MAX_COL - 1) {
                    row++;
                    down = true;
                } else if (row == 0) {
                    col++;
                    down = true;
                } else {
                    row--;
                    col++;
                }
            }else{
                // 向斜下方遍历
                if (row == MAX_ROW - 1) {
                    col++;
                    down = false;
                } else if (col == 0) {
                    row++;
                    down = false;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return res;
    }
}
