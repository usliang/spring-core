package com.liang.springcore.recursive;

import java.util.HashSet;
import java.util.Set;

public class StringCombination {
    public Set<Set<Character>> combine(final String str) {
        Set<Character> emptySet = new HashSet<>();
        Set<Set<Character>> result = new HashSet<>();
        result.add(emptySet);
        combineRecursive(str, result);
        return result;
    }
    private void combineRecursive(final String str, final Set<Set<Character>> currentSet) {
        if (str.isEmpty()) {
            return ;
        }
        char ch = str.charAt(0);
        Set<Set<Character>> newSets = new HashSet<>();
        for (Set<Character> set : currentSet) {
            Set<Character> newSet = new HashSet<>(set);
            newSet.add(ch);
            newSets.add(newSet);
        }
        currentSet.addAll(newSets);
        combineRecursive(str.substring(1), currentSet);
    }

    public Set<Set<Character>>  combineNoRecursive(final String str) {
        Set<Character> emptySet = new HashSet<>();
        Set<Set<Character>> result = new HashSet<>();
        result.add(emptySet);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            addNewLetter(ch, result);
        }
        return result;
    }
    private void addNewLetter(final char ch, final Set<Set<Character>> currentSet) {

        Set<Set<Character>> newSets = new HashSet<>();
        for (Set<Character> set : currentSet) {
            Set<Character> newSet = new HashSet<>(set);
            newSet.add(ch);
            newSets.add(newSet);
        }
        currentSet.addAll(newSets);
    }
}
