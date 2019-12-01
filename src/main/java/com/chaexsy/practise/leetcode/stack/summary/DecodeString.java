package com.chaexsy.practise.leetcode.stack.summary;

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

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();

        // 数字辅助栈
        Stack<Integer> stack_multi = new Stack<>();
        // 字母辅助栈
        Stack<String> stack_res = new Stack<>();

        // 是否连续遍历到了数字，连续遍历到数字时，需要把连续遍历到的数字看成一个数
        boolean isConsecutiveNumber = false;

        for(Character c : s.toCharArray()) {
            if(c == '[') {
                // 碰到左括号，把之前攒起来的字母压入栈
                // 然后把攒起来的字母清空，重新开始攒
                stack_res.push(res.toString());
                res = new StringBuilder();

                isConsecutiveNumber = false;
            }else if(c == ']') {
                // 碰到右括号
                StringBuilder tmp = new StringBuilder();
                // 先把数字出栈
                int cur_multi = stack_multi.pop();
                // 再把攒起来的字母拿出来计算
                for(int i = 0; i < cur_multi; i++){
                    tmp.append(res);
                }
                // 把 之前压入栈的字母和计算出来的字母拼起来
                res = new StringBuilder(stack_res.pop() + tmp);

                isConsecutiveNumber = false;
            }else if(c >= '0' && c <= '9'){
                int multi = Integer.parseInt(c + "");
                if(isConsecutiveNumber){
                    // 连续遍历到数字时，把之前遍历到的数字视为比当前的数字高10位
                    multi = stack_multi.pop() * 10 + multi;
                }
                stack_multi.push(multi);

                isConsecutiveNumber = true;
            }else{
                // 即不是数字也不是括号，就把字母攒起来
                res.append(c);
                isConsecutiveNumber = false;
            }
        }
        return res.toString();
    }


    public static void main(String[] args){
//        System.out.println("result: " + new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println("result: " + new DecodeString().decodeString("3[a2[c]]"));
//        System.out.println("result: " + new DecodeString().decodeString("100[leetcode]"));
    }
}
