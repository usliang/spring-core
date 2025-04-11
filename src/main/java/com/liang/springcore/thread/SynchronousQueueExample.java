package com.liang.springcore.thread;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            String[] items = {"one", "two", "three"};
            try {
                for (String item : items) {
                    System.out.println("Producer: waiting to transfer - " + item);
                    queue.put(item); // Will block until consumer takes it
                    System.out.println("Producer: transferred - " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Give producer a head start
                for (int i = 0; i < 3; i++) {
                    String item = queue.take(); // Will block until producer puts something
                    System.out.println("Consumer: received - " + item);
                    Thread.sleep(1500); // Simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
