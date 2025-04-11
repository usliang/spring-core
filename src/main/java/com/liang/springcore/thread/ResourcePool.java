package com.liang.springcore.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ResourcePool {
    private Queue<Resource> resources = new LinkedList<>();
    private final int capacity;

    public ResourcePool(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void acquire(String type) throws InterruptedException {
        while (resources.isEmpty() || !resources.peek().getType().equals(type)) {
            wait();
        }
        Resource resource = resources.poll();
        System.out.println(Thread.currentThread().getName() + " acquired resource of type: " + resource.getType());
    }

    public synchronized void release(Resource resource) {
        resources.offer(resource);
        notifyAll(); // Use notifyAll to wake up all waiting threads
        System.out.println(Thread.currentThread().getName() + " released resource of type: " + resource.getType());
    }

    public synchronized void addResource(Resource resource) {
        if (resources.size() < capacity) {
            resources.offer(resource);
            System.out.println(Thread.currentThread().getName() + " produce resource of type: " + resource.getType());
            notifyAll();
        }
    }


}