package com.liang.springcore.thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NonBlockingQueueExample {
    public static void main(String[] args) {
        // Create a non-blocking concurrent queue
        Queue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer thread
        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                System.out.println("Producing " + value);
                boolean succeeded = queue.offer(value); // Non-blocking insertion
                if (!succeeded) {
                    System.out.println("Queue full. Failed to insert " + value);
                }
                value++;
                try {
                    Thread.sleep(500); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            while (true) {
                Integer val = queue.poll(); // Non-blocking retrieval
                if (val != null) {
                    System.out.println("Consuming " + val);
                }
                try {
                    Thread.sleep(1000); // Simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        producer.start();
        consumer.start();
    }
}
