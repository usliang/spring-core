package com.liang.springcore.licode;

import java.util.Stack;

public class SimpleRegExp {
    public static void main(String[] args) {
        SimpleRegExp sr = new SimpleRegExp();
        String str ;
        String pattern;

        /*
        str = "a";
        pattern = "a";
        assert(sr.isMatch(str, pattern));

        str = "a";
        pattern = "b";
        assert(!sr.isMatch(str, pattern));

        str = "ab";
        pattern = "ab";
        assert(sr.isMatch(str, pattern));

        str = "a";
        pattern = ".";
        assert(sr.isMatch(str, pattern));

        str = "a";
        pattern = "a*";
        assert(sr.isMatch(str, pattern));

        str = "ab";
        pattern = "a*";
        assert(!sr.isMatch(str, pattern));

        str = "aaaa";
        pattern = "a*";
        assert(sr.isMatch(str, pattern));

        str = "aaaab";
        pattern = "a*b";
        assert(sr.isMatch(str, pattern));

        str = "aaaab";
        pattern = "a*.";
        assert(sr.isMatch(str, pattern));

        str = "aaaab";
        pattern = "a*b.";
        assert(!sr.isMatch(str, pattern));

        str = "ab";
        pattern = ".*";
        assert(sr.isMatch(str, pattern));

        str = "aa";
        pattern = "a";
        assert(!sr.isMatch(str, pattern));

        str = "aaaaaaab";
        pattern = "a*ab";
        assert(sr.isMatch(str, pattern));

        str= "aab";
        pattern = "c*a*b";
        assert(sr.isMatch(str, pattern));

        str= "aaa";
        pattern = "ab*a";
        assert(!sr.isMatch(str, pattern));

        str= "a";
        pattern = "ab*";
        assert(sr.isMatch(str, pattern));

        str = "bbbba";
        pattern = ".*a*a";
        assert(sr.isMatch(str, pattern));

        str = "aaa";
        pattern = "ab*a*c*a";
        assert(sr.isMatch(str, pattern));

        str = "aaa";
        pattern = "ac*b*a*c*a";
        assert(sr.isMatch(str, pattern));

        str = "acaa";
        pattern = "ac*.b*a*c*a";
        assert(sr.isMatch(str, pattern));

        str = "a";
        pattern = "..*";
        assert(sr.isMatch(str, pattern));

        str = "a";
        pattern = ".*..a*";
        assert(!sr.isMatch(str, pattern));

        str = "";
        pattern = "a*b*c*";
        assert(sr.isMatch(str, pattern));

        str = "aabcbcbcaccbcaabc";
        pattern = ".*a*aa*.*b*.c*.*a*";
        assert(sr.isMatch(str, pattern));

         */
        str = "cbaacacaaccbaabcb";
        pattern = "c*b*b*.*ac*.*bc*a*"; //"c*b*b*.*ac*.*bc*a*"
        assert(sr.isMatch(str, pattern));
    }
    public boolean isRepeatedAnyMatch(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return false;
        }
        if (pattern.length() % 2 == 1) {
            return false;
        }
        if (pattern.equalsIgnoreCase(".*")) {
            return true;
        } else {
            return isRepeatedAnyMatch(pattern.substring(2));
        }
    }

    public int countSign(String pattern) {
        int result = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                result++;
            }
        }
        return result;
    }

    public boolean isMatch(String s, String p) {
        System.out.println("s=" + s);
        System.out.println("pattern= " + p);
        if (isRepeatedAnyMatch(p)) {
            return true;
        }
        if (p.length() > 1 ) {
            if (p.charAt(1) == '*' ) {
                int signCount = countSign(p.substring(2));
                int diff = s.length() - p.substring(2).length() + 2 * signCount;
                if (diff < 0) {
                    return false;
                } else {
                    StringBuilder added = new StringBuilder(p.substring(2));
                    for (int i = 0; i <= diff; i++) {
                        if (isMatch(s, added.toString())) {
                            return true;
                        } else {
                            added.insert(0, p.charAt(0));
                        }
                    }
                    return false;
                }

            } else { //p.length >=2 and p.chatAt(1) != "*"
                if (s.isEmpty()) {
                    return false;
                } else {
                    if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
                        return false;
                    } else {
                        if (s.length() > 1) {
                            return isMatch(s.substring(1), p.substring(1));
                        } else { //s.length == 1
                            if (p.length() == 3 && p.charAt(2) == '*') { //s=a pattern= ab*
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        } else { //p.length >= 2
            if (s.length() != p.length()) {
                return false;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
                        return false;
                    }
                }
                return true;
            }
        }
    }
    public boolean isMatch1(String s, String p) {
        int i = 0;
        int j = 0;
        boolean res = true;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else if (p.charAt(j) == '.') {
                i++;
                j++;
            } else if ((j + 1) < p.length() && p.charAt(j + 1) == '*') { // * is used as 0
                j = j + 2;
            } else if (p.charAt(j) == '*') {
                if (p.charAt(j - 1) == s.charAt(i) && ((s.length() - i) > (p.length() - j - 1))) {
                    i++;
                } else if ((p.charAt(j - 1) == '.') && ((s.length() - i) > (p.length() - j - 1)) ) {
                    i++;
                } else {
                    if (j == p.length() - 1) {
                        j++;
                        break;
                    } else {
                        j++;
                    }
                }
            } else {
                res = false;
                break;
            }
        }
        if (i != s.length()) {
            res = false;
        }
        if (j != p.length()) {
            res = false;
            //p's last = * or  //p's last two like a* set to ture
            if (j == p.length()-1 && p.charAt(j) == '*' ||  (j == p.length()-2 && p.charAt(j + 1) == '*')) {
                res = true;//p's last = *
            }
        }
        return res;
    }
    public boolean isMatch2(String s, String p) {
        if (p.equalsIgnoreCase(".*")) {
            return true;
        }
        Stack<Character> strStack = new Stack<>();
        Stack<Character> patternStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            strStack.push(s.charAt(i));
        }
        for (int i = 0; i < p.length(); i++) {
            patternStack.push(p.charAt(i));
        }
        while (!strStack.isEmpty() && !patternStack.isEmpty()) {
            char str = strStack.pop();
            char pattern = patternStack.pop();
            if (str != pattern) {
                if (pattern == '.') {
                    continue;
                } else if (pattern == '*') {
                    if(patternStack.peek() == '.') {
                        patternStack.pop(); //pop '.'
                        if (patternStack.isEmpty()) {
                            return true; //.* match to anything
                        } else {
                            char next = patternStack.peek();
                            if (next != '*' && next != '.') {
                                while (!strStack.isEmpty() && strStack.peek() != next) {
                                    strStack.pop();
                                }
                                if (strStack.isEmpty()) {
                                    return false;
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    if (patternStack.peek() != str) {
                        patternStack.pop();
                        strStack.push(str);
                        continue;
                    } else {  //str = a and pattern = a*
                        //check how many the same char in str and how many in pattern
                        StringBuilder builder1 = new StringBuilder();
                        builder1.append(str);
                        while (!strStack.isEmpty() && strStack.peek() == str) {
                            builder1.append(strStack.pop());
                        }
                        //pop the same char out until the substring length = builder1
                        StringBuilder builder2 = new StringBuilder();
                        while (!patternStack.isEmpty() && builder2.length() < builder1.length()) {
                            if (patternStack.peek() == str) {
                                builder2.append(patternStack.pop());
                            } else if (patternStack.peek() == '*') {
                                patternStack.pop(); //*
                                patternStack.pop(); //any
                            } else if (patternStack.peek() == '.') {
                                patternStack.pop();
                                builder2.append(str);
                            } else {
                                break;
                            }
                        }
                        if (builder1.length() + 1 < builder2.length()) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        while (!patternStack.isEmpty()) {
            if (patternStack.peek() == '*') {
                patternStack.pop();
                patternStack.pop();
            } else {
                return false;
            }

        }

        if (strStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
