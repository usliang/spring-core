package com.liang.springcore.licode;

public class WildCardMatcher {
    public boolean isMatch(String s, String p) {
        String pattern = removeUnneededStars(p);
        //System.out.println("pattern: " + pattern);
        //System.out.println("s: " + s);
        if (s.isEmpty()) {
            if (pattern.isEmpty()) {
                return true;
            } else {
                return isPatternMatchEmpty(pattern);
            }
        } else {
            if (pattern.isEmpty()) {
                return false;
            }else {
                if (s.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '?') {
                    return isMatch(s.substring(1), pattern.substring(1));
                } else if (pattern.charAt(0) == '*') {
                    if (pattern.length()>1 && (pattern.charAt(1) == '?' || pattern.charAt(1) == s.charAt(0))) {
                        return isMatch(s, pattern.substring(1)) || isMatch(s.substring(1), pattern);
                    } else {
                        return  isMatch(s.substring(1), pattern);
                    }
                } else {
                    return false;
                }
            }
        }
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
}
