package com.liang.springcore.thread;

public class InterruptExample {

    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
                // Restore interrupted status
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thread is exiting...");
            }
        });

        myThread.start();

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt(); // Interrupt the thread after 3.5 seconds
    }
}