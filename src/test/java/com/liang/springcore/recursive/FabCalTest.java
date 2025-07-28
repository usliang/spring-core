package com.liang.springcore.recursive;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FabCalTest {

    @Test
    void testBaseCases() {
        FabCal fabCal = new FabCal();
        assertEquals(BigInteger.ZERO, fabCal.calculateRecursive(0));
        assertEquals(BigInteger.ONE, fabCal.calculateRecursive(1));
    }

    @Test
    void testTypicalValues() {
        FabCal fabCal = new FabCal();
        assertEquals(BigInteger.ONE, fabCal.calculateRecursive(2));
        assertEquals(BigInteger.valueOf(13), fabCal.calculateRecursive(7));
        assertEquals(BigInteger.valueOf(55), fabCal.calculateRecursive(10));
    }

    @Test
    void testLargeValue() {
        FabCal fabCal = new FabCal();
        BigInteger result = fabCal.calculateRecursive(100);
        assertEquals(new BigInteger("354224848179261915075"), result);
    }

    @Test
    void testNegativeInputThrowsException() {
        FabCal fabCal = new FabCal();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> fabCal.calculateRecursive(-5)
        );
        assertEquals("n should be greater than 0", exception.getMessage());
    }

    @Test
    void testPerformance() {
        FabCal fabCal = new FabCal();
        long start = System.currentTimeMillis();
        BigInteger result = fabCal.calculateRecursive(1000);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Fibonacci(1000) has " + result.toString().length() + " digits. Computed in " + elapsed + " ms");
        assertTrue(result.compareTo(BigInteger.ZERO) > 0);
        assertTrue(elapsed < 2000); // adjust threshold if needed
    }
}
