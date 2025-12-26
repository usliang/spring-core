package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMasterTest {
    StringMaster stringMaster = new StringMaster();
    @Test
    void firstUniqChar1() {
        String s = "leetcode";
        assertEquals(0, stringMaster.firstUniqChar(s));
    }

    @Test
    void firstUniqChar2() {
        String s = "loveleetcode";
        assertEquals(2, stringMaster.firstUniqChar(s));
    }

    @Test
    void firstUniqChar3() {
        String s = "aabb";
        assertEquals(-1, stringMaster.firstUniqChar(s));
    }
    @Test
    void isAnagram1() {
        String s = "anagram", t = "nagaram";
        assertTrue(stringMaster.isAnagram(s, t));
    }

    @Test
    void isAnagram2() {
        String s = "rat", t = "car";
        assertFalse(stringMaster.isAnagram(s, t));
    }

    @Test
    void filter1() {
        String s = "AZ";
        String filtered = stringMaster.filter(s);
        assertEquals("az", filtered);
    }

    @Test
    void filter2() {
        String s = "    ";
        String filtered = stringMaster.filter(s);
        assertEquals("", filtered);
    }

    @Test
    void filter3() {
        String s = "az";
        String filtered = stringMaster.filter(s);
        assertEquals("az", filtered);
    }

    @Test
    void filter4() {
        String s = "09";
        String filtered = stringMaster.filter(s);
        assertEquals("09", filtered);
    }

    @Test
    void isPalindrome1() {
        String s = "A man, a plan, a canal: Panama";
        assertTrue(stringMaster.isPalindrome(s));
    }
    @Test
    void isPalindrome2() {
        String s = "race a car";
        assertFalse(stringMaster.isPalindrome(s));
    }

    @Test
    void myAtoi1() {
        String s = "   ";
        int n = stringMaster.myAtoi(s);
        assertEquals(0, n);
    }

    @Test
    void myAtoi2() {
        String s = "-2";
        int n = stringMaster.myAtoi(s);
        assertEquals(-2, n);
    }

    @Test
    void myAtoi3() {
        String s = "3";
        int n = stringMaster.myAtoi(s);
        assertEquals(3, n);
    }

    @Test
    void myAtoi4() {
        String s = "-23";
        int n = stringMaster.myAtoi(s);
        assertEquals(-23, n);
    }

    @Test
    void myAtoi5() {
        String s = "-23456";
        int n = stringMaster.myAtoi(s);
        assertEquals(-23456, n);
    }

    @Test
    void myAtoi6() {
        String s = "23";
        int n = stringMaster.myAtoi(s);
        assertEquals(23, n);
    }

    @Test
    void myAtoi7() {
        String s = "23456";
        int n = stringMaster.myAtoi(s);
        assertEquals(23456, n);
    }

    @Test
    void myAtoi8() {
        String s = "--23";
        int n = stringMaster.myAtoi(s);
        assertEquals(0, n);
    }

    @Test
    void myAtoi9() {
        String s = "-23.1";
        int n = stringMaster.myAtoi(s);
        assertEquals(-23, n);
    }

    @Test
    void myAtoi10() {
        String s = "- 23";
        int n = stringMaster.myAtoi(s);
        assertEquals(0, n);
    }

    @Test
    void myAtoi11() {
        String s = "  -23";
        int n = stringMaster.myAtoi(s);
        assertEquals(-23, n);
    }

    @Test
    void myAtoi12() {
        String s = "2147483647";
        int n = stringMaster.myAtoi(s);
        assertEquals(2147483647, n);
    }

    @Test
    void myAtoi13() {
        String s = "2147483648";
        int n = stringMaster.myAtoi(s);
        assertEquals(2147483647, n);
    }

    @Test
    void myAtoi14() {
        String s = "2147483658";
        int n = stringMaster.myAtoi(s);
        assertEquals(2147483647, n);
    }

    @Test
    void myAtoi15() {
        String s = "-2147483648";
        int n = stringMaster.myAtoi(s);
        assertEquals(-2147483648, n);
    }

    @Test
    void myAtoi16() {
        String s = "-2147483649";
        int n = stringMaster.myAtoi(s);
        assertEquals(-2147483648, n);
    }

    @Test
    void myAtoi17() {
        String s = "-2147483658";
        int n = stringMaster.myAtoi(s);
        assertEquals(-2147483648, n);
    }

    @Test
    void myAtoi18() {
        String s = "-21474a83648";
        int n = stringMaster.myAtoi(s);
        assertEquals(-21474, n);
    }

    @Test
    void myAtoi19() {
        String s = "214748Z3647";
        int n = stringMaster.myAtoi(s);
        assertEquals(214748, n);
    }

    @Test
    void strStr() {
        String haystack = "aaaaaaaaaaaaab";
        String needle = "aaaaab";
        int index = stringMaster.strStr(haystack, needle);
        assertEquals(8, index);    }

    @Test
    void buildLPS1() {
        String needle="a";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(0, rmp[0]);
    }
    @Test
    void buildLPS2() {
        String needle="aa";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(1, rmp[1]);
    }

    @Test
    void buildLPS3() {
        String needle="aaa";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(2, rmp[2]);
    }
    @Test
    void buildLPS4() {
        String needle="ab";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(0, rmp[1]);
    }

    @Test
    void buildLPS5() {
        String needle="aba";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(0, rmp[1]);
    }

    @Test
    void buildLPS6() {
        String needle="abab";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(2, rmp[3]);
    }
    @Test
    void buildLPS7() {
        String needle="ababa";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(3, rmp[4]);
    }

    @Test
    void buildLPS8() {
        String needle="ababab";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(4, rmp[5]);
    }

    //ababaca
    @Test
    void buildLPS9() {
        String needle="ababaca";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(1, rmp[6]);
    }

    //ababaca
    @Test
    void buildLPS10() {
        String needle="aabaaa";
        int[] rmp = stringMaster.buildLPS(needle);
        assertEquals(2, rmp[4]);
        assertEquals(2, rmp[5]);
    }

    @Test
    void longestCommonPrefix() {
        String[] strings = new String[3];
        strings[0] = "abcd";
        strings[1] = "abcd";
        strings[2] = "abc";
        String prefix = stringMaster.longestCommonPrefix(strings);
        assertEquals("abc", prefix);
    }
}