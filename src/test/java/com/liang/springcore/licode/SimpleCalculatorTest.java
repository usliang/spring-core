package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void calculate1() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate1_2() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "  ";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate1_3() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "1";
        result = calculator.calculate(s);
        assertEquals(1, result);
    }

    @Test
    void calculate1_4() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "123";
        result = calculator.calculate(s);
        assertEquals(123, result);
    }

    @Test
    void calculate1_5() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "-1";
        result = calculator.calculate(s);
        assertEquals(-1, result);
    }

    @Test
    void calculate1_6() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "-123";
        result = calculator.calculate(s);
        assertEquals(-123, result);
    }

    @Test
    void calculate1_7() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "- 12 3 ";
        result = calculator.calculate(s);
        assertEquals(-123, result);
    }

    @Test
    void calculate2() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s="(2)";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate3() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s="(20)";
        result = calculator.calculate(s);
        assertEquals(20, result);
    }

    @Test
    void calculate3_1() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s="(-20)";
        result = calculator.calculate(s);
        assertEquals(-20, result);
    }

    @Test
    void calculate4() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s="((2))";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate5() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s="(((2)))";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate6() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s="(-2)";
        result = calculator.calculate(s);
        assertEquals(-2, result);
    }

    @Test
    void calculate7() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "1+1";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate8() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "1 + 1";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate8_1() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = " 1  +   1 ";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate9() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "(1+1)";
        result = calculator.calculate(s);
        assertEquals(2, result);
    }

    @Test
    void calculate10() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "-1+1";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate11() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "1+10";
        result = calculator.calculate(s);
        assertEquals(11, result);
    }
    @Test
    void calculate12() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "10+10";
        result = calculator.calculate(s);
        assertEquals(20, result);
    }

    @Test
    void calculate13() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "1-1";
        result = calculator.calculate(s);
        assertEquals(0, result);
    }

    @Test
    void calculate14() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "10+100";
        result = calculator.calculate(s);
        assertEquals(110, result);
    }

    @Test
    void calculate15() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "(1+1)+(2+2)";
        result = calculator.calculate(s);
        assertEquals(6, result);
    }

    @Test
    void calculate16() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
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
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "((1+1)+(2+2)-6)-(3+4)";
        result = calculator.calculate(s);
        assertEquals(-7, result);

    }

    @Test
    void calculate17_1() {
        SimpleCalculatorV2 calculator = new SimpleCalculatorV2();
        String s;
        int result;
        // test edge case
        s = "-(((1+1)+(2+2)-6)-(3+4))";
        result = calculator.calculate(s);
        assertEquals(7, result);

    }
}