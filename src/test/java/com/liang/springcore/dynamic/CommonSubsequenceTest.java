package com.liang.springcore.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonSubsequenceTest {
    CommonSubsequence commonSubsequence = new CommonSubsequence();
    @Test
    void longestCommonSubsequence1() {
        String s1 = "a";
        String s2 = "a";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(1, max);
    }

    @Test
    void longestCommonSubsequence2() {
        String s1 = "a";
        String s2 = "aaaa";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(1, max);
    }

    @Test
    void longestCommonSubsequence3() {
        String s1 = "aa";
        String s2 = "aca";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(2, max);
    }

    @Test
    void longestCommonSubsequence4() {
        String s1 = "aaa";
        String s2 = "aaca";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(3, max);
    }

    @Test
    void longestCommonSubsequence5() {
        String s1 = "abcde";
        String s2 = "ace";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(3, max);
    }

    @Test
    void longestCommonSubsequence6() {
        String s1 = "abc";
        String s2 = "abc";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(3, max);
    }

    @Test
    void longestCommonSubsequence7() {
        String s1 = "abc";
        String s2 = "def";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(0, max);
    }

    @Test
    void longestCommonSubsequence8() {
        String s1 = "abc";
        String s2 = "defaebac";
        int max = commonSubsequence.longestCommonSubsequence(s1, s2);
        assertEquals(3, max);
    }
}