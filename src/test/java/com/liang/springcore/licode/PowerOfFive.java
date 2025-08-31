package com.liang.springcore.licode;

public class PowerOfFive {
    public boolean isPowerOfFive(int n) {

        return n > 0 && 1220703125 % n == 0;
    }
}
