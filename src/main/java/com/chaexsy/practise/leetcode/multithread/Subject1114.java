package com.chaexsy.practise.leetcode.multithread;

/**
 * 按序打印
 *
 * 解法1：
 * 这是一个典型的执行屏障的问题，可以通过构造屏障来实现。
 *
 * 我们需要构造 2 道屏障，second 线程等待 first 屏障，third 线程等待 second 屏障。
 * first 线程会释放 first 屏障，而 second 线程会释放 second 屏障。
 * Java 中，我们使用线程等待的方式实现执行屏障，使用释放线程等待的方式实现屏障消除。具体代码如下：
 *
 * @author Chaexsy 2020-02-04 23:33
 */
public class Subject1114 {
    class Foo {
        private boolean firstFinished;
        private boolean secondFinished;
        private Object lock = new Object();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (lock) {
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (lock) {
                while(!firstFinished){
                    lock.wait();
                }
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while(!secondFinished){
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                lock.notifyAll();
            }

        }
    }
}
