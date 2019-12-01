package com.chaexsy.practise.leetcode.stack.summary;

import java.util.ArrayList;
import java.util.List;

/**
 * 用队列实现栈
 *
 * @author Chaexsy 2019-12-01 10:29
 */
public class MyStack {
    List<Integer> data;

    /** Initialize your data structure here. */
    public MyStack() {
        data = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        data.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return data.remove(data.size()-1);
    }

    /** Get the top element. */
    public int top() {
        return data.get(data.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.size() == 0;
    }
}
