package com.liang.springcore.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/****
 * Created by liliang on 7/31/25.
 ****/
class WildCardBottomUpTest {

    WildCardBottomUp wildCardBottomUp = new WildCardBottomUp();

    @Test
    void isMatchCase1() {
        assertTrue(wildCardBottomUp.isMatch("", ""));
    }
    @Test
    void isMatchCase2() {
        assertTrue(wildCardBottomUp.isMatch("", "*"));
    }

    @Test
    void isMatchCase3() {
        assertTrue(wildCardBottomUp.isMatch("", "**"));
    }

    @Test
    void isMatchCase4() {
        assertTrue(wildCardBottomUp.isMatch("a", "a"));
    }

    @Test
    void isMatchCase5() {
        assertTrue(wildCardBottomUp.isMatch("a", "?"));
    }

    @Test
    void isMatchCase6() {
        assertTrue(wildCardBottomUp.isMatch("a", "*"));
    }

    @Test
    void isMatchCase7() {
        assertTrue(wildCardBottomUp.isMatch("a", "**"));
    }

    @Test
    void isMatchCase8() {
        assertTrue(wildCardBottomUp.isMatch("ab", "*"));
    }

    @Test
    void isMatchCase9() {
        assertTrue(wildCardBottomUp.isMatch("abc", "*c"));
    }

    @Test
    void isMatchCase10() {
        assertTrue(wildCardBottomUp.isMatch("abcd", "*cd"));
    }

    @Test
    void isMatchCase11() {
        assertTrue(wildCardBottomUp.isMatch("abcd", "**d"));
    }

    @Test
    void isMatchCase12() {
        assertTrue(wildCardBottomUp.isMatch("abcd", "**?d"));
    }

    @Test
    void isMatchCase13() {
        assertTrue(wildCardBottomUp.isMatch("abcd", "a*?d"));
    }

    @Test
    void isMatchCase14() {
        assertTrue(wildCardBottomUp.isMatch("abcefd", "a?*d"));
    }

    @Test
    void isMatchCase15() {
        assertFalse(wildCardBottomUp.isMatch("a", "b"));
    }

    @Test
    void isMatchCase16() {
        assertFalse(wildCardBottomUp.isMatch("ac", "ab"));
    }

    @Test
    void isMatchCase17() {
        assertFalse(wildCardBottomUp.isMatch("abbcd", "*?c"));
    }

    @Test
    void isMatchCase18() {
        assertTrue(wildCardBottomUp.isMatch("adceb", "a*b"));
    }

    @Test
    void isMatchCase19() {
        assertTrue(wildCardBottomUp.isMatch("adceb", "*a*b"));
    }

    @Test
    void isMatchCase20() {
        assertFalse(wildCardBottomUp.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
    }

    @Test
    void isMatchCase21() {
        String s =  "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*";
        assertFalse(wildCardBottomUp.isMatch(s, p));
    }

    @Test
    void isMatchCase22() {
        assertTrue(wildCardBottomUp.isMatch("a", "*a*"));
    }


    @Test
    void isMatchCase23() {
        String s =  "a";
        String p = "*aa*";
        assertFalse(wildCardBottomUp.isMatch(s, p));
    }

}