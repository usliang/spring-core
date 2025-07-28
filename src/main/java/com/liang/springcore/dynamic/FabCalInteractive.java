package com.liang.springcore.dynamic;

import java.math.BigInteger;

public class FabCalInteractive {

    public BigInteger calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        BigInteger[] result = new BigInteger[n + 1];
        if (n == 0) {
            return new BigInteger("0");
        }
        if (n == 1) {
            return new BigInteger("1");
        }
        result[0] = new BigInteger("0");
        result[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1].add(result[i - 2]);
        }
        return result[n];
    }
}
