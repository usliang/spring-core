package com.liang.springcore.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final int SERVICES = 3;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(SERVICES);

        // Simulate three services initializing
        new Thread(new Service("Database Service", 1000, latch)).start();
        new Thread(new Service("Cache Service", 1500, latch)).start();
        new Thread(new Service("Messaging Service", 1200, latch)).start();

        System.out.println("Main thread waiting for services to initialize...");

        // Main thread waits until all services call countDown()
        latch.await();

        System.out.println("All services are up. Starting main application.");
    }

    static class Service implements Runnable {
        private final String name;
        private final int startupTime;
        private final CountDownLatch latch;

        public Service(String name, int startupTime, CountDownLatch latch) {
            this.name = name;
            this.startupTime = startupTime;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is starting...");
                Thread.sleep(startupTime); // Simulate startup time
                System.out.println(name + " is up.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Signal that this service is ready
            }
        }
    }
}
