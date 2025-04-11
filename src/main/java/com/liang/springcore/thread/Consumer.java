package com.liang.springcore.thread;

public class Consumer implements Runnable {
    private ResourcePool pool;
    private String type;
    private ControlButton button;

    public Consumer(ResourcePool pool, String type) {
        this.pool = pool;
        this.type = type;
        button = new ControlButton();
    }

    public void stop() {
        button.stop();
    }

    @Override
    public void run() {
        while (button.isRunning()) {
            try {
                pool.acquire(type);
                System.out.println("Consumer " + type);
                // Use the resource
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                button.stop();
            }
        }
        System.out.println("Consumer stopped");
    }
}