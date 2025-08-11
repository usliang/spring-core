package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoTest {
    PowerOfTwo powerOfTwo = new PowerOfTwo();
    @Test
    void isPowerOfTwo() {
        assertTrue(powerOfTwo.isPowerOfTwo(1));
        assertTrue(powerOfTwo.isPowerOfTwo(2));
        assertTrue(powerOfTwo.isPowerOfTwo(4));
        assertFalse(powerOfTwo.isPowerOfTwo(Integer.MAX_VALUE));
        assertFalse(powerOfTwo.isPowerOfTwo(Integer.MAX_VALUE - 1));
        assertTrue(powerOfTwo.isPowerOfTwo((int)Math.pow(2, 30)));
        assertTrue(powerOfTwo.isPowerOfTwo((int)Math.pow(2, 29)));
    }
}