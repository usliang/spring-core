package com.liang.springcore.dynamic;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FabCalInteractiveTest {

    private final FabCalInteractive fabCal = new FabCalInteractive();

    @Test
    void testBaseCases() {
        assertEquals(BigInteger.ZERO, fabCal.calculate(0));
        assertEquals(BigInteger.ONE, fabCal.calculate(1));
    }

    @Test
    void testTypicalValues() {
        assertEquals(BigInteger.valueOf(5), fabCal.calculate(5));
        assertEquals(BigInteger.valueOf(55), fabCal.calculate(10));
        assertEquals(new BigInteger("354224848179261915075"), fabCal.calculate(100));
    }

    @Test
    void testLargeValuePerformance() {
        long start = System.currentTimeMillis();
        BigInteger result = fabCal.calculate(100_000);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Fibonacci(100000) computed in " + elapsed + " ms. Digits: " + result.toString().length());
        assertTrue(result.compareTo(BigInteger.ZERO) > 0);
        assertTrue(elapsed < 3000);
    }

    @Test
    void testNegativeInputThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> fabCal.calculate(-1));
        assertEquals("n should be greater than 0", ex.getMessage());
    }

    @Test
    void testLargeValue1000() {
        long start = System.currentTimeMillis();
        BigInteger result = fabCal.calculate(1000);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Fibonacci(1000) computed in " + elapsed + " ms. Digits: " + result.toString().length());
        assertTrue(result.compareTo(BigInteger.ZERO) > 0);
        assertTrue(elapsed < 3000);
    }
}
