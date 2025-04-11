package com.liang.springcore;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Loggable
    public void doSomething() {
        //some logic
    }

    @Monitor
    public void processData() {
        //some logic
    }
}