package com.chaexsy.practise.leetcode.hashtable.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Chaexsy 2020-01-18 14:46
 */
public class LengthOfLongestSubstring {
    /**
     * 解法1
     * 暴力法 逐个检查所有的子字符串，看它是否不含有重复的字符。
     * 时间复杂度O(n3)
     */
    public int solution1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    /**
     * 判断字符串s的[start, end)子字符串是否是包含重复字符
     *
     * @param s 字符串
     * @param start 左闭区间
     * @param end 右开区间
     * @return true：无重复字符，false：有重复字符
     */
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 解法二：滑动窗口
     *
     */
    public int solution2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println("" + new LengthOfLongestSubstring().solution2(" "));
//        System.out.println("" + new LengthOfLongestSubstring().solution2("abcabcbb"));
//        System.out.println("" + new LengthOfLongestSubstring().solution2("bbbbb"));
//        System.out.println("" + new LengthOfLongestSubstring().solution2("pwwkew"));
        System.out.println("" + new LengthOfLongestSubstring().solution2("dvdvf"));
    }
}
