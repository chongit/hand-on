package io.chone.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleThreadPrint {

    public static void main(String[] args) {
        FooCountDownLatch fooCountDownLatch = new FooCountDownLatch();
        new Thread(() -> {
            try {
                fooCountDownLatch.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooCountDownLatch.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fooCountDownLatch.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        FooCAS fooCAS = new FooCAS();
        new Thread(() -> {
            try {
                fooCAS.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fooCAS.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fooCAS.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    static class FooCountDownLatch {

        private CountDownLatch countDownLatch2 = new CountDownLatch(1);

        private CountDownLatch countDownLatch3 = new CountDownLatch(1);

        public FooCountDownLatch() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            countDownLatch2.await();
            printSecond.run();
            countDownLatch3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            countDownLatch3.await();
            printThird.run();
        }
    }


    static class FooCAS {

        AtomicInteger state = new AtomicInteger(1);
        public FooCAS() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state.compareAndSet(1,2);
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while(state.get()!=2);
            printSecond.run();
            state.compareAndSet(2,3);
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while(state.get()!=3);
            printThird.run();
        }
    }


    public void MultiThreadPrint() {
//        Semaphore semaphore = new Semaphore(0);
//        Lock lock = new ReentrantLock();
//        //Lock lock2 = new ReentrantLock();
//        //Lock lock3 = new ReentrantLock();
//        Condition condition1 = lock.newCondition();
//        Condition condition2 = lock.newCondition();
//        Condition condition3 = lock.newCondition();
//        Thread thread1 = new PrintThread(1, condition1, condition2);
//        Thread thread2 = new PrintThread(2, condition2, condition3);
//        Thread thread3 = new PrintThread(3, condition3, null);
//        thread1.start();
//        thread2.start();
//        thread3.start();
////        lock1.unlock();
    }

    static class PrintThread extends Thread {


//        PrintThread(int val, Condition condition, Condition condition) {
//            super(new Runnable() {
//                @Override
//                public void run() {
////                    if (lock != null) {
////                        lock.lock();
////                    }
////                    try {
////                        System.out.println(val);
////                        if (next != null) {
////                            next.unlock();
////                        }
////                    } finally {
////                        if (lock != null) lock.unlock();
////                    }
//                }
//            });
//        }


    }
}
