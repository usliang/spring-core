package com.liang.springcore.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildCardDynamicTest {

    WildCardDynamic wildCardDynamic = new WildCardDynamic();

    @Test
    void isMatchCase1() {
        assertTrue(wildCardDynamic.isMatch("", ""));
    }
    @Test
    void isMatchCase2() {
        assertTrue(wildCardDynamic.isMatch("", "*"));
    }

    @Test
    void isMatchCase3() {
        assertTrue(wildCardDynamic.isMatch("", "**"));
    }

    @Test
    void isMatchCase4() {
        assertTrue(wildCardDynamic.isMatch("a", "a"));
    }

    @Test
    void isMatchCase5() {
        assertTrue(wildCardDynamic.isMatch("a", "?"));
    }

    @Test
    void isMatchCase6() {
        assertTrue(wildCardDynamic.isMatch("a", "*"));
    }

    @Test
    void isMatchCase7() {
        assertTrue(wildCardDynamic.isMatch("a", "**"));
    }

    @Test
    void isMatchCase8() {
        assertTrue(wildCardDynamic.isMatch("ab", "*"));
    }

    @Test
    void isMatchCase9() {
        assertTrue(wildCardDynamic.isMatch("abc", "*c"));
    }

    @Test
    void isMatchCase10() {
        assertTrue(wildCardDynamic.isMatch("abcd", "*cd"));
    }

    @Test
    void isMatchCase11() {
        assertTrue(wildCardDynamic.isMatch("abcd", "**d"));
    }

    @Test
    void isMatchCase12() {
        assertTrue(wildCardDynamic.isMatch("abcd", "**?d"));
    }

    @Test
    void isMatchCase13() {
        assertTrue(wildCardDynamic.isMatch("abcd", "a*?d"));
    }

    @Test
    void isMatchCase14() {
        assertTrue(wildCardDynamic.isMatch("abcefd", "a?*d"));
    }

    @Test
    void isMatchCase15() {
        assertFalse(wildCardDynamic.isMatch("a", "b"));
    }

    @Test
    void isMatchCase16() {
        assertFalse(wildCardDynamic.isMatch("ac", "ab"));
    }

    @Test
    void isMatchCase17() {
        assertFalse(wildCardDynamic.isMatch("abbcd", "*?c"));
    }

    @Test
    void isMatchCase18() {
        assertTrue(wildCardDynamic.isMatch("adceb", "a*b"));
    }

    @Test
    void isMatchCase19() {
        assertTrue(wildCardDynamic.isMatch("adceb", "*a*b"));
    }

    @Test
    void isMatchCase20() {
        assertFalse(wildCardDynamic.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
    }

    @Test
    void isMatchCase21() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*";
        assertFalse(wildCardDynamic.isMatch(s, p));
    }

    @Test
    void isMatchCase22() {
        assertTrue(wildCardDynamic.isMatch("a", "*a*"));
    }

}