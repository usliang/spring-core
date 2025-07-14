package com.liang.springcore.licode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildCardMatcherTest {
    WildCardMatcher wildCardMatcher = new WildCardMatcher();

    @Test
    void removeUnneededStars1() {
        assertEquals("*", wildCardMatcher.removeUnneededStars("*****"));
    }

    @Test
    void removeUnneededStars2() {
        assertEquals("a*b*", wildCardMatcher.removeUnneededStars("a*****b**"));
    }

    @Test
    void isMatchCase1() {
        assertTrue(wildCardMatcher.isMatch("", ""));
    }
    @Test
    void isMatchCase2() {
        assertTrue(wildCardMatcher.isMatch("", "*"));
    }

    @Test
    void isMatchCase3() {
        assertTrue(wildCardMatcher.isMatch("", "**"));
    }

    @Test
    void isMatchCase4() {
        assertTrue(wildCardMatcher.isMatch("a", "a"));
    }

    @Test
    void isMatchCase5() {
        assertTrue(wildCardMatcher.isMatch("a", "?"));
    }

    @Test
    void isMatchCase6() {
        assertTrue(wildCardMatcher.isMatch("a", "*"));
    }

    @Test
    void isMatchCase7() {
        assertTrue(wildCardMatcher.isMatch("a", "**"));
    }

    @Test
    void isMatchCase8() {
        assertTrue(wildCardMatcher.isMatch("ab", "*"));
    }

    @Test
    void isMatchCase9() {
        assertTrue(wildCardMatcher.isMatch("abc", "*c"));
    }

    @Test
    void isMatchCase10() {
        assertTrue(wildCardMatcher.isMatch("abcd", "*cd"));
    }

    @Test
    void isMatchCase11() {
        assertTrue(wildCardMatcher.isMatch("abcd", "**d"));
    }

    @Test
    void isMatchCase12() {
        assertTrue(wildCardMatcher.isMatch("abcd", "**?d"));
    }

    @Test
    void isMatchCase13() {
        assertTrue(wildCardMatcher.isMatch("abcd", "a*?d"));
    }

    @Test
    void isMatchCase14() {
        assertTrue(wildCardMatcher.isMatch("abcefd", "a?*d"));
    }

    @Test
    void isMatchCase15() {
        assertFalse(wildCardMatcher.isMatch("a", "b"));
    }

    @Test
    void isMatchCase16() {
        assertFalse(wildCardMatcher.isMatch("ac", "ab"));
    }

    @Test
    void isMatchCase17() {
        assertFalse(wildCardMatcher.isMatch("abbcd", "*?c"));
    }

    @Test
    void isMatchCase18() {
        assertTrue(wildCardMatcher.isMatch("adceb", "a*b"));
    }

    @Test
    void isMatchCase19() {
        assertTrue(wildCardMatcher.isMatch("adceb", "*a*b"));
    }

    @Test
    void isMatchCase20() {
        assertFalse(wildCardMatcher.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
    }
}