package com.liang.springcore.thread;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

    private static AtomicReference<String> message = new AtomicReference<>("Initial message");

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            runTest();
        }
    }

    public static void runTest() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            message.compareAndSet("Initial message", "Message from thread1");
            System.out.println("Thread 1: " + message.get());
        });

        Thread thread2 = new Thread(() -> {
            message.compareAndSet("Initial message", "Message from thread2");
            System.out.println("Thread 2: " + message.get());
        });


        thread1.start();
        thread2.start();




        System.out.println("Final message: " + message.get());

        if (message.get().equalsIgnoreCase("Message from thread1")) {
            System.out.println("Thread 1 has the final saying");
        }
        if (message.get().equalsIgnoreCase("Message from thread2")) {
            System.out.println("Thread 2 has the final saying");
        }

    }
}