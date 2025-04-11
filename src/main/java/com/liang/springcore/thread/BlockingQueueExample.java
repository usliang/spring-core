package com.liang.springcore.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Create a blocking queue with a capacity of 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            int value = 0;
            try {
                while (true) {
                    System.out.println("Producing " + value);
                    queue.put(value);  // blocks if queue is full
                    value++;
                    Thread.sleep(500);  // simulate time-consuming work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer val = queue.take();  // blocks if queue is empty
                    System.out.println("Consuming " + val);
                    Thread.sleep(1000);  // simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start both threads
        producer.start();
        consumer.start();
    }
}
