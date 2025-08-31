package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfFiveTest {
    PowerOfFive powerOfFive = new PowerOfFive();
    @Test
    void isPowerOfThree1() {
        assertTrue(powerOfFive.isPowerOfFive(1));
    }

    @Test
    void isPowerOfThree2() {
        assertTrue(powerOfFive.isPowerOfFive(5));
    }

    @Test
    void isPowerOfThree3() {
        assertTrue(powerOfFive.isPowerOfFive(5 * 5));
    }

    @Test
    void isPowerOfThree4() {
        assertTrue(powerOfFive.isPowerOfFive(5 * 5 * 5));
    }

    @Test
    void isPowerOfThree5() {
        assertTrue(powerOfFive.isPowerOfFive((int)Math.pow(5, 13)));
    }
}