package com.liang.springcore.generic;

public class GeneConsumerImpl<T> implements GeneConsumer<T> {
    @Override
    public void consume(T t) {
        System.out.println(t);
    }
}
