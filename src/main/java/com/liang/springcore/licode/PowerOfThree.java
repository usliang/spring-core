package com.liang.springcore.licode;

import java.util.HashSet;
import java.util.Set;

public class PowerOfThree {
    private final Set<Integer> powerSet;

    public PowerOfThree() {
        this.powerSet = new HashSet<>(25);
        int powerOfThree = 3;
        while (powerOfThree >0) {
            powerSet.add(powerOfThree);
            powerOfThree = multiplyThree(powerOfThree);
        }
    }

    public boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;
    }

    private int multiplyThree(int n) {
        int m = n;
        n = n << 1;
        return n + m;
    }
}
