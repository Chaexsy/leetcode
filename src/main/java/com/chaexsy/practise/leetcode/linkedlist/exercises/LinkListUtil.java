package com.chaexsy.practise.leetcode.linkedlist.exercises;


import org.apache.commons.lang3.StringUtils;

/**
 * 链表的一些工具方法
 *
 * @author yusijiayf1 2019-12-16 10:53
 */
public class LinkListUtil {
    public static void printLinkList(String prefix, ListNode head){
        ListNode cur = head;

        if(StringUtils.isNotBlank(prefix)){
            System.out.print(prefix);
        }
        while (cur != null){
            if(cur.next != null){
                System.out.print(cur.val+"-");
            }else{
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public static void printLinkList(String prefix, Node head){
        Node cur = head;

        if(StringUtils.isNotBlank(prefix)){
            System.out.print(prefix);
        }
        while (cur != null){
            if(cur.next != null){
                String curStr = ""+cur.val;
                if(cur.next.prev == cur){
                    System.out.print(curStr+"=");
                }else{
                    System.out.print(curStr+"-");
                }
                if(cur.child != null){
                    System.out.print("(");
                    printLinkList("", cur.child);
                    System.out.print(")-");
                }
            }else{
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
//        System.out.println();
    }
}
