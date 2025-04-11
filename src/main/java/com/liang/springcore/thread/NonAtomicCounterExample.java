package com.liang.springcore.thread;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class NonAtomicCounterExample {

    private static final int NUM_THREADS = 1000;
    private static final int NUM_INCREMENTS = 10000;

    public static void main(String[] args) throws InterruptedException {
        // Using AtomicLong
        AtomicLong atomicCounter = new AtomicLong(0);
        testCounter(atomicCounter, "AtomicLong");

        // Using LongAdder
        LongAdder longAdderCounter = new LongAdder();
        testCounter(longAdderCounter, "LongAdder");
        testNonAtomicCounter(0);
    }

    private static void testCounter(Number counter, String counterType) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_INCREMENTS; j++) {
                    if (counter instanceof AtomicLong) {
                        ((AtomicLong) counter).incrementAndGet();
                    } else if (counter instanceof LongAdder) {
                        ((LongAdder) counter).increment();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();

        long finalValue = (counter instanceof AtomicLong) ? ((AtomicLong) counter).get() : ((LongAdder) counter).sum();
        System.out.println(counterType + " final value: " + finalValue);
        System.out.println(counterType + " time taken: " + (endTime - startTime) + "ms");
    }

    private static void testNonAtomicCounter(long counter) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS * NUM_INCREMENTS; i++) {
            counter ++;
        }


        long endTime = System.currentTimeMillis();

        System.out.println("long final value: " + counter);
        System.out.println("long time taken: " + (endTime - startTime) + "ms");
    }
}
