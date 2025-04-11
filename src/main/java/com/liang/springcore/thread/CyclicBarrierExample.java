package com.liang.springcore.thread;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    private static final int THREAD_COUNT = 3;
    private static CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
        System.out.println("All threads reached the barrier, proceeding together.");
    });

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is doing some work...");
                Thread.sleep((long) (Math.random() * 2000));

                System.out.println(Thread.currentThread().getName() + " waiting at barrier...");
                barrier.await();  // Thread waits here

                System.out.println(Thread.currentThread().getName() + " passed the barrier.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Start multiple threads
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(task).start();
        }
    }
}
