package com.liang.springcore.recursive;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StringCombinationTest {
    StringCombination stringCombination = new StringCombination();

    @Test
    void combine1() {
        String str = "";
        Set<Set<Character>> result = stringCombination.combine(str);
        assertEquals(1, result.size());
        result = stringCombination.combineNoRecursive(str);
        assertEquals(1, result.size());
    }

    @Test
    void combine2() {
        String str = "a";
        Set<Set<Character>> result = stringCombination.combine(str);
        assertEquals(2, result.size());
        result = stringCombination.combineNoRecursive(str);
        assertEquals(2, result.size());
    }

    @Test
    void combine3() {
        String str = "ab";
        Set<Set<Character>> result = stringCombination.combine(str);
        assertEquals(4, result.size());
        result = stringCombination.combineNoRecursive(str);
        assertEquals(4, result.size());
    }

    @Test
    void combine4() {
        String str = "abc";
        Set<Set<Character>> result = stringCombination.combine(str);
        assertEquals(8, result.size());
        result = stringCombination.combineNoRecursive(str);
        assertEquals(8, result.size());
    }

    @Test
    void combine5() {
        String str = "abcd";
        Set<Set<Character>> result = stringCombination.combine(str);
        assertEquals(16, result.size());
        result = stringCombination.combineNoRecursive(str);
        assertEquals(16, result.size());
    }

    @Test
    void combine6() {
        String str = "abcde";
        Set<Set<Character>> result = stringCombination.combine(str);
        assertEquals(32, result.size());
        result = stringCombination.combineNoRecursive(str);
        assertEquals(32, result.size());
    }
}