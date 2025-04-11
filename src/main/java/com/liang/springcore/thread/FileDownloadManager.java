package com.liang.springcore.thread;

import java.util.concurrent.Phaser;

public class FileDownloadManager {
    private static final int CHUNKS = 4;

    public static void main(String[] args) {
        Phaser phaser = new Phaser();

        // Register the main thread
        phaser.register();

        for (int i = 0; i < CHUNKS; i++) {
            phaser.register();
            final int chunkId = i;

            new Thread(() -> {
                try {
                    // Phase 0: Download
                    System.out.println("Chunk " + chunkId + " downloading...");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("Chunk " + chunkId + " downloaded.");
                    phaser.arriveAndAwaitAdvance();

                    // Phase 1: Verify
                    System.out.println("Chunk " + chunkId + " verifying...");
                    Thread.sleep((long) (Math.random() * 500));
                    System.out.println("Chunk " + chunkId + " verified.");
                    phaser.arriveAndAwaitAdvance();

                    // Phase 2: Cleanup
                    System.out.println("Chunk " + chunkId + " cleaning up...");
                    Thread.sleep((long) (Math.random() * 300));
                    System.out.println("Chunk " + chunkId + " cleanup done.");
                    phaser.arriveAndDeregister(); // Done with all phases

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        // Main thread waits for each phase to finish
        for (int phase = 0; phase < 3; phase++) {
            phaser.arriveAndAwaitAdvance();
            switch (phase) {
                case 0 -> System.out.println("===> All chunks downloaded.\n");
                case 1 -> System.out.println("===> All chunks verified.\n");
                case 2 -> System.out.println("===> All cleanup complete.\n");
            }
        }

        phaser.arriveAndDeregister();
        System.out.println("File download process complete.");
    }
}
