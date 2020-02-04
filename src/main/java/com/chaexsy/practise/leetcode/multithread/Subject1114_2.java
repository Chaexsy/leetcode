package com.chaexsy.practise.leetcode.multithread;

/**
 * 按序打印
 *
 * 思路和解法1一样，构造屏障
 * 代码简化
 * 另外使用while自旋锁替代synchronized争抢锁和wait，notifyAll释放锁操作
 *
 * @author Chaexsy 2020-02-04 23:37
 */
public class Subject1114_2 {
    class Foo {

        public Foo() {

        }

        private volatile int count=1;



        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            count++;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (count!=2);
            printSecond.run();
            count++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (count!=3);
            printThird.run();
        }
    }
}
