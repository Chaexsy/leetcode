package com.chaexsy.practise.leetcode.stack.summary;

import java.util.Stack;

/**
 *  用栈实现队列
 *
 * @author Chaexsy 2019-11-07 8:22
 */
class MyQueue {
    private Stack<Integer> data;

    /** Initialize your data structure here. */
    public MyQueue() {
        data = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        data.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return data.remove(0);
    }

    /** Get the front element. */
    public int peek() {
        return data.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return data.empty();
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
