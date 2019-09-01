package com.chaexsy.practise.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class MinStack {
    private List<Integer> data;

    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        if (!isEmpty()) {
            data.remove(data.size() - 1);
        }
    }

    public int top() {
        return data.get(data.size()-1);
    }

    public int getMin() {
        if(isEmpty()){
            return -1;
        }

        int min = data.get(0);
        for(int num:data){
            min = Math.min(min, num);
        }
        return min;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
