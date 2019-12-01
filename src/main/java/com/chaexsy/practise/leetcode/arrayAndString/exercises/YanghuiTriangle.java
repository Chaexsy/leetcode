package com.chaexsy.practise.leetcode.arrayAndString.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * @author Chaexsy 2019-12-01 22:24
 */
public class YanghuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            List<Integer> list = new ArrayList<>(i);

            for(int j=0; j<i; j++){
                int num;

                int row = i - 2;

                if(row < 0 || j == 0 || j == i-1){
                    num = 1;
                }else{
                    // 用上一行的数据计算得到本行的结果
                    List<Integer> upRow = result.get(row);
                    num = upRow.get(j-1) + upRow.get(j);
                }
                list.add(num);
            }

            result.add(list);
        }

        return result;
    }
}
