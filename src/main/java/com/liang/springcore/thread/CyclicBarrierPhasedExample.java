package com.liang.springcore.thread;

import java.util.concurrent.*;

public class CyclicBarrierPhasedExample {
    private static final int THREADS = 3;
    private static final int PHASES = 3;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(THREADS, () -> {
            System.out.println("All threads reached the barrier. Next phase begins.\n");
        });

        Runnable task = () -> {
            try {
                for (int phase = 1; phase <= PHASES; phase++) {
                    System.out.println(Thread.currentThread().getName() + " working in phase " + phase);
                    Thread.sleep((long) (Math.random() * 1000));

                    System.out.println(Thread.currentThread().getName() + " waiting at barrier for phase " + phase);
                    barrier.await();  // Wait for others
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < THREADS; i++) {
            new Thread(task).start();
        }
    }
}
