package com.liang.springcore.licode;


public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        boolean result = false;
        int power = 1;
        for (int i = 1; i <= 30; i++) {
            power = power * 2;
            if (power == n) {
                result = true;
                break;
            } else if (power > n) {
                break;
            }
        }
        return result;

    }
}
