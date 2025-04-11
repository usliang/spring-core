package com.liang.springcore.thread;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread producer = new Thread(() -> {
            String data = "Data from Producer";
            try {
                System.out.println("Producer: preparing data...");
                Thread.sleep(1000);
                System.out.println("Producer: waiting to exchange data");
                String response = exchanger.exchange(data);
                System.out.println("Producer received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            String data = "Ack from Consumer";
            try {
                System.out.println("Consumer: ready to receive data...");
                String received = exchanger.exchange(data);
                System.out.println("Consumer received: " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
