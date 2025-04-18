package com.liang.springcore.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLeakExample {
    private static final ThreadLocal<String> userContext = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1); // Only 1 thread, reused

        // First task sets user data
        Runnable task1 = () -> {
            userContext.set("Alice");
            System.out.println(Thread.currentThread().getName() + " - Task1: set user to " + userContext.get());
            userContext.remove();
            // No remove()!
        };

        // Second task expects no user data
        Runnable task2 = () -> {
            String user = userContext.get(); // Should be null ideally
            System.out.println(Thread.currentThread().getName() + " - Task2: user is " + user);
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.shutdown();
    }
}
