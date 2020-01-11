package com.chaexsy.practise.leetcode.hashtable.exercises;

import com.chaexsy.practise.leetcode.utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个列表的最小索引总和
 *
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * (存在多个餐厅时，这道题需要输出 索引之和最小的餐厅)
 *
 *
 * 示例 1:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 示例 2:
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 * @author yusijia 2020-01-11 20:10
 * @since v.0.1
 */
public class FindRestaurant {
    public String[] solution(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>(1024);
        for(int i=0; i<list1.length; i++){
            map1.put(list1[i], i);
        }

        // 都喜欢的餐厅Map.
        // key：索引和，value：索引和相同的餐厅列表
        Map<Integer, List<String>> repeatMap = new HashMap<>(128);

        int minKey = Integer.MAX_VALUE;
        for(int i=0; i<list2.length; i++){
            if(map1.containsKey(list2[i])){
                // 如果发现重复餐厅，则计算索引和，并将索引和和餐厅加入映射
                int indexSum = i + map1.get(list2[i]);
                repeatMap.putIfAbsent(indexSum, new ArrayList<>());
                repeatMap.get(indexSum).add(list2[i]);

                minKey = Math.min(minKey, indexSum);
            }

            // 当前索引已经大于最小索引和了，没有必要再搜索后面的餐厅了
            // 加入这句主要为了提高效率，减小时间消耗
            if(i > minKey){
                break;
            }
        }


        if(repeatMap.get(minKey) == null){
            return null;
        }

        String[] result = new String[repeatMap.get(minKey).size()];
        repeatMap.get(minKey).toArray(result);
        return result;
    }

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun","KFC", "Tapioca Express","Burger King"};
        String[] list2 = new String[]{"KFC","Shogun","Burger King"};
        PrintUtil.printArray(new FindRestaurant().solution(list1, list2));
    }
}
