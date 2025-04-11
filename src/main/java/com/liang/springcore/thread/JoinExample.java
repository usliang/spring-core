package com.liang.springcore.thread;

public class JoinExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        try {
            System.out.println("Before Thread " + thread1.getName() + " calling join");
            thread1.join(); // Wait for thread1 to complete
            System.out.println("After Thread " + thread1.getName() + " joined");

            System.out.println("Before Thread " + thread2.getName() + " calling join");
            //thread2.join(); // Wait for thread2 to complete
            System.out.println("After Thread " + thread2.getName() + " joined");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}