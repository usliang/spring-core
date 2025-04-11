package com.liang.springcore.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int PRINTERS = 2;
    private static final Semaphore semaphore = new Semaphore(PRINTERS);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            int userId = i;
            new Thread(() -> {
                System.out.println("User " + userId + " trying to access printer...");
                try {
                    semaphore.acquire();
                    System.out.println("User " + userId + " is printing...");
                    Thread.sleep((long) (Math.random() * 2000));
                    System.out.println("User " + userId + " done printing.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("User " + userId + " released the printer.");
                    semaphore.release();
                }
            }).start();
        }
    }
}
