package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author yusijia 2020-01-12 14:03
 * @since v.0.1
 */
public class FirstUniqChar {
    /**
     * 内部类，存储字符索引以及字符出现的次数
     */
    public class Value{
        int index;
        int times;

        Value(int index, int times){
            this.index = index;
            this.times = times;
        }
    }

    /**
     * 解法1
     */
    public int solution(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Value> map = new HashMap<>(128);
        for(int i=0; i<chars.length; i++){
            Value value = map.get(chars[i]);
            if(value == null){
                map.put(chars[i], new Value(i, 1));
            }else{
                value.times += 1;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for(Map.Entry<Character, Value> entry:map.entrySet()){
            if(entry.getValue().times == 1){
                minIndex = Math.min(minIndex, entry.getValue().index);
            }
        }

        if(minIndex == Integer.MAX_VALUE){
            return -1;
        }

        return minIndex;
    }


    /**
     * 解法2
     */
    public int solution2(String s) {
        int res = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 || res > index) ? index : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().solution("loveleetcode"));
    }
}
