package com.liang.springcore.thread;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // Register 3 parties (threads)

        Thread t1 = new Thread(() -> worker(phaser, "Thread-1"));
        Thread t2 = new Thread(() -> worker(phaser, "Thread-2"));
        Thread t3 = new Thread(() -> worker(phaser, "Thread-3"));

        t1.start();
        t2.start();
        t3.start();
    }

    private static void worker(Phaser phaser, String name) {
        System.out.println(name + " arrived at phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // Arrive and wait for others

        System.out.println(name + " proceeding to phase " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " completed phase " + phaser.getPhase());

        phaser.arriveAndAwaitAdvance();
        System.out.println(name + " added completed phase " + phaser.getPhase());

        phaser.arriveAndAwaitAdvance();
        System.out.println(name + " added by li completed phase " + phaser.getPhase());

        phaser.arriveAndDeregister(); // Arrive and deregister
    }
}