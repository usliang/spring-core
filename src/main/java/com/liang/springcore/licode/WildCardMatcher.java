package com.liang.springcore.licode;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WildCardMatcher {
    private Map<InputPair, Boolean> map;

    public WildCardMatcher() {
        this.map =  new HashMap<>();;
    }

    public boolean isMatch(String s, String p) {
        String pattern = removeUnneededStars(p);
        System.out.println("pattern: " + pattern);
        System.out.println("s: " + s);

        InputPair inputPair = new InputPair(s, pattern); // FIXED
        if (map.containsKey(inputPair)) return map.get(inputPair);

        if (s.isEmpty()) {
            boolean result = isPatternMatchEmpty(pattern);
            map.put(inputPair, result);
            return result;
        }
        if (pattern.isEmpty()) {
            map.put(inputPair, false);
            return false;
        }

        char sc = s.charAt(0), pc = pattern.charAt(0);
        boolean result;
        if (pc == sc || pc == '?') {
            result = isMatch(s.substring(1), pattern.substring(1));
        } else if (pc == '*') {
            result = isMatch(s, pattern.substring(1)) || isMatch(s.substring(1), pattern);
        } else {
            result = false;
        }

        map.put(inputPair, result);
        return result;
    }



    public boolean isPatternMatchEmpty(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    public String removeUnneededStars(String p) {
        if (p.isEmpty()) {
            return p;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p.charAt(0));
        for (int i = 1; i < p.length(); i++) {
            if ((sb.charAt(sb.length() - 1) != '*') || p.charAt(i) != '*' ) {
                sb.append(p.charAt(i));
            }
        }
        return sb.toString();
    }

    static class InputPair {
        String pattern;
        String key;

        public InputPair(String key, String pattern) {
            this.key = key;
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }

        public String getKey() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            InputPair inputPair = (InputPair) o;
            return Objects.equals(getPattern(), inputPair.getPattern()) && Objects.equals(getKey(), inputPair.getKey());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getPattern(), getKey());
        }
    }
}
