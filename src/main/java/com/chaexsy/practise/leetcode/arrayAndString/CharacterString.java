package com.chaexsy.practise.leetcode.arrayAndString;

/**
 * 字符串简介
 *
 * 字符串实际上是一个 unicode 字符数组。你可以执行几乎所有我们在数组中使用的操作，自己试试看吧。
 *
 * @author Chaexsy 2019-12-02 8:17
 */
public class CharacterString {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));

        System.out.println("字符串的额外操作**************************************************");
        String s10 = "Hello World";
        // 1. concatenate
        s10 += "!";
        System.out.println(s10);
        // 2. find
        System.out.println("The position of first 'o' is: " + s10.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s10.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s10.substring(6, 11));
    }
}
