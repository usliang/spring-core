package com.liang.springcore.thread;

public class Producer implements Runnable {
    private ResourcePool pool;
    private ControlButton button;

    public Producer(ResourcePool pool) {
        this.pool = pool;
        button = new ControlButton();
    }


    public void start () {
        button.start();
        run();
    }

    public void stop() {
        button.stop();
    }

    @Override
    public void run() {
        while (button.isRunning()) {
            try {
                pool.addResource(new Resource("A"));
                System.out.println("Produce A");
                Thread.sleep(300);
                pool.addResource(new Resource("B"));
                System.out.println("Produce B the first time");
                Thread.sleep(300);
                pool.addResource(new Resource("B"));
                System.out.println("Produce B the second time");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                button.stop();
            }
        }
        System.out.println("Producer stopped");
    }
}
