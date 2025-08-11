package com.liang.springcore.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowCalTest {
    PowCal powCal = new PowCal();
    @Test
    void pow1() {
        double x= 2.0;
        int n = -2147483648;
        double res = powCal.myPow(x, n);
    }

}