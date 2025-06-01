package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void calculate1() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate2() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s="(2)";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate3() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s="(20)";
        result = calculator.calculate(s);
        assertEquals(20, result);
    }

    @Test
    void calculate4() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s="((2))";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate5() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s="(((2)))";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate6() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s="(-2)";
        result = calculator.calculate(s);
        assertEquals(-2, result);
    }

    @Test
    void calculate7() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "1+1";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate8() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "1 + 1";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate9() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "(1+1)";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate10() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "-1+1";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate11() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "1+10";
        result = calculator.calculate(s);
        assertEquals(11, result);
    }
    @Test
    void calculate12() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "10+10";
        result = calculator.calculate(s);
        assertEquals(20, result);
    }

    @Test
    void calculate13() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "1-1";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate14() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "10+100";
        result = calculator.calculate(s);
        assertEquals(110, result);
    }

    @Test
    void calculate15() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "(1+1)+(2+2)";
        result = calculator.calculate(s);
        assertEquals(6, result);
    }

    @Test
    void calculate16() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        //s = "(1+1)+(2+2)-(3+4)";
        s = "(1+1)+(2+2)-1";
        result = calculator.calculate(s);
        assertEquals(5, result);
    }

    @Test
    void calculate17() {
        SimpleCalculator calculator = new SimpleCalculator();
        String s;
        int result;
        // test edge case
        s = "((1+1)+(2+2)-6)-(3+4)";
        result = calculator.calculate(s);
        assertEquals(-7, result);

    }
}