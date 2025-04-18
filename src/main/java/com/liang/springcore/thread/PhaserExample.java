package com.liang.springcore.thread;

import java.util.concurrent.Phaser;

public class PhaserExample {
    private static final int WORKERS = 3;
    private static final int PHASES = 10;

    public static void main(String[] args) {
        Phaser phaser = new Phaser();

        // Register main thread so it can wait for others
        phaser.register();

        for (int i = 0; i < WORKERS; i++) {
            phaser.register(); // Register each worker
            int id = i;
            new Thread(() -> {
                for (int phase = 0; phase < PHASES; phase++) {
                    System.out.println("Worker " + id + " working in phase " + phaser.getPhase());
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Worker " + id + " finished phase " + phase);
                    phaser.arriveAndAwaitAdvance(); // Wait for others
                }

                System.out.println("Worker " + id + " done. Deregistering.");
                phaser.arriveAndDeregister(); // Leave the phaser
            }).start();
        }

        // Wait for all phases to complete
        for (int phase = 0; phase < PHASES; phase++) {
            System.out.println("main thread in phase " + phaser.getPhase() + "\n");
            phaser.arriveAndAwaitAdvance(); // Main thread waits too
            System.out.println("===> Phase " + phase + " complete\n");
        }

        // Deregister main thread
        phaser.arriveAndDeregister();
        System.out.println("Main thread done.");
    }
}
