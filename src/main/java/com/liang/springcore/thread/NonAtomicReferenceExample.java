package com.liang.springcore.thread;

import java.util.concurrent.atomic.AtomicReference;

public class NonAtomicReferenceExample {

    private static String message = "Initial message";

    public static void main(String[] args) throws InterruptedException {
       for (int i = 0; i < 1000; i++) {
           runTest();
       }
    }
    private static void runTest() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            message = "Message from thread1";
            System.out.println("Thread 1 after set: " + message);
        });

        Thread thread2 = new Thread(() -> {
            message = "Message from thread2";
            System.out.println("Thread 2 after set: " + message);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final message: " + message);
        if (message.equalsIgnoreCase("Message from thread1")) {
            System.out.println("Thread 1 has the final saying");
        }
        if (message.equalsIgnoreCase("Message from thread2")) {
            System.out.println("Thread 2 has the final saying");
        }
    }
}
