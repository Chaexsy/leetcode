package com.chaexsy.practise.leetcode.stack.summary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @author Chaexsy 2019-12-01 10:40
 */
public class DecodeString {
    private final String NUMS = "123456789";

    public String decodeString(String s) {
        String result = "";

        Stack<String> stack = new Stack<>();

        boolean search
        for(int i=0; i<s.length(); i++){
            String x = s.substring(i, i+1);
            if(NUMS.contains(x)){
                for(int j=0; j<Integer.parseInt(x); j++){
                    result += r
                }
            }
        }

        result +=
    }
}
