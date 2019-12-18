package com.chaexsy.practise.leetcode.linkedlist.exercises;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang.StringUtils;

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
}
