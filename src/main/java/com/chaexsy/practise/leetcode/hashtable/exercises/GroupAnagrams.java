package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.*;

/**
 * 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author Chaexsy 2020-01-16 11:12
 */
public class GroupAnagrams {
    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            String key = getKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    private String getKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args){
        List<List<String>> result = new GroupAnagrams().solution(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result.toString());
    }
}
