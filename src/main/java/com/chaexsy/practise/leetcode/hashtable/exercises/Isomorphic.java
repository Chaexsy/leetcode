package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * @author yusijia 2020-01-11 18:53
 * @since v.0.1
 */
public class Isomorphic {
    /**
     * 解法1：
     *
     * 遍历两个字符串
     * 把相互的字符映射关系保存在两个不同的Map中
     * 如果任何一个Map出现不同的映射关系时，返回false
     * 否则返回true
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 注:
     * 什么是同构字符串？
     * 两个个字符串的每个字母都匹配同一个映射关系，
     * 比如egg -> add的映射关系就是：e->a, g->d;
     * foo与bar显然不满足，因为o->a同事o->r；
     * paper和title满足，p->t, a->i, e->l, r->e。
     *
     * 所以需要一个map来存放映射关系，
     * 两个字符串从头开始比较的时候，如果map中没有映射关系那么就插入一对字符映射;
     * 如果有就比较映射关系是否相同，如果不同就说明不是同构字符串返回false，
     * 直到所有的映射关系都满足就返回true。
     */
    public boolean solution(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>(128);
        Map<Character, Character> map2 = new HashMap<>(128);
        for(int i=0; i<s.length(); i++){

            char cs = s.charAt(i);
            char ts = t.charAt(i);

            if(map1.get(cs) != null && map1.get(cs) != ts){
                return false;
            }
            if(map2.get(ts) != null && map2.get(ts) != cs){
                return false;
            }

            map1.put(cs, ts);
            map2.put(ts, cs);
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(new Isomorphic().solution("addxx", "eggks"));
    }
}
