package com.liang.springcore.thread;

public class ControlButton {
    private volatile boolean running;

    public ControlButton() {
        this.running = true;
    }
    public void start() {
        running = true;
    }
    public void stop() {
        running = false;
    }
    public boolean isRunning() {
        return running;
    }
}
