package com.liang.springcore.thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        try {
            Thread.sleep(2000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + this.getName() + " finished");
    }
}