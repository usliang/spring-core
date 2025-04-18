package com.liang.springcore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalRemoveExample {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                threadLocal.set("Data for " + threadName);
                System.out.println(threadName + " set value: " + threadLocal.get());

                // simulate doing something
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Always remove ThreadLocal variable when done
                //threadLocal.remove();
                //System.out.println(Thread.currentThread().getName() + " removed value.");
            }
        };

        // Using a thread pool to simulate thread reuse
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(task);
        executor.submit(task); // same thread may be reused
        executor.shutdown();
    }
}
