package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfThreeTest {
    PowerOfThree powerOfThree = new PowerOfThree();
    @Test
    void isPowerOfThree1() {
        assertTrue(powerOfThree.isPowerOfThree(1));
    }

    @Test
    void isPowerOfThree2() {
        assertTrue(powerOfThree.isPowerOfThree(3));
    }

    @Test
    void isPowerOfThree3() {
        assertTrue(powerOfThree.isPowerOfThree(9));
    }

    @Test
    void isPowerOfThree4() {
        assertTrue(powerOfThree.isPowerOfThree(27));
    }

    @Test
    void isPowerOfThree5() {
        assertTrue(powerOfThree.isPowerOfThree(81));
    }

    @Test
    void isPowerOfThree6() {
        assertTrue(powerOfThree.isPowerOfThree(243));
    }

    @Test
    void isPowerOfThree7() {
        assertTrue(powerOfThree.isPowerOfThree(243 * 3));
    }
    @Test
    void isPowerOfThree8() {
        assertTrue(powerOfThree.isPowerOfThree(243 * 3 * 3));
    }
    @Test
    void isPowerOfThree9() {
        assertFalse(powerOfThree.isPowerOfThree(15));
    }

    @Test
    void isPowerOfThree10() {
        assertFalse(powerOfThree.isPowerOfThree(2147483647
        ));
    }

    @Test
    void isPowerOfThree11() {
        assertTrue(powerOfThree.isPowerOfThree(1162261467));
    }
}