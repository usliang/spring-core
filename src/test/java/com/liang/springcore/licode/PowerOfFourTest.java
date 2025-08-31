package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfFourTest {
    PowerOfFour powerOfFour = new PowerOfFour();
    @Test
    void isPowerOfFour1() {
        int n = 1073741824 * 4;
        assertTrue(powerOfFour.isPowerOfFour(1));
    }

    @Test
    void isPowerOfFour2() {
        assertTrue(powerOfFour.isPowerOfFour(4));
    }

    @Test
    void isPowerOfFour3() {
        assertFalse(powerOfFour.isPowerOfFour(8));
    }

    @Test
    void isPowerOfFour4() {
        assertTrue(powerOfFour.isPowerOfFour(16));
    }

    @Test
    void isPowerOfFour5() {
        assertFalse(powerOfFour.isPowerOfFour(32));
    }

    @Test
    void isPowerOfFour6() {
        assertTrue(powerOfFour.isPowerOfFour((int) Math.pow(4, 3)));
    }

    @Test
    void isPowerOfFour7() {
        assertTrue(powerOfFour.isPowerOfFour((int) Math.pow(4, 4)));
    }

    @Test
    void isPowerOfFour8() {
        assertTrue(powerOfFour.isPowerOfFour((int) Math.pow(4, 9)));
    }

    @Test
    void isPowerOfFour10() {
        assertTrue(powerOfFour.isPowerOfFour((int) Math.pow(4, 15)));
    }
}