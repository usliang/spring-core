package com.liang.springcore.thread;

public class NotifyAllExample {
    public static void main(String[] args) throws InterruptedException {
        ResourcePool pool = new ResourcePool(5);
        Producer producer = new Producer(pool);

        Thread producerThread = new Thread(producer, "Producer");
        Consumer consumerA = new Consumer(pool, "A");
        Consumer consumerB = new Consumer(pool, "B");

        Thread consumer1 = new Thread(consumerA, "Consumer A");
        Thread consumer2 = new Thread(consumerB, "Consumer B");

        producerThread.start();
        consumer1.start();
        consumer2.start();

        System.out.println(" produce and consumers started.");
        Thread.sleep(50000);
        System.out.println("after sleep 5000");

        producer.stop();
        consumerA.stop();
        consumerB.stop();

        //producerThread.interrupt();
        //consumer1.interrupt();
        //consumer2.interrupt();
    }
}