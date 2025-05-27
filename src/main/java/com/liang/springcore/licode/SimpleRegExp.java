package com.liang.springcore.licode;

import java.util.Objects;
import java.util.Stack;

public class SimpleRegExp {
    public static void main(String[] args) {

        SimpleRegExp sr = new SimpleRegExp();

        String str ;
        String pattern;

        str = "aaaaaaaaaaaaaaaaaaab";
        pattern = "a*a*a*a*a*a*a*a*a*a*";
        assert(!sr.isMatch(str, pattern));

        str= "acabacbaaabacba";
        pattern = "bc*c*.b*b*.*a*a*.*";
        assert(!sr.isMatch(str, pattern));

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

        str = "";
        pattern = "a*b*c";
        assert(!sr.isMatch(str, pattern));

        str = "aabcbcbcaccbcaabc";
        pattern = ".*a*aa*.*b*.c*.*a*";
        assert(sr.isMatch(str, pattern));


        str = "cbaacacaaccbaabcb";
        pattern = "c*b*b*.*ac*.*bc*a*";
        assert(sr.isMatch(str, pattern));


        //b!=bc*a*
        str = "b";
        pattern = "bc*a*";
        assert(sr.isMatch(str, pattern));
    }
    public boolean isPatternMatchEmpty(String pattern) {
        if (pattern.length() % 2 != 0) {
            return false;
        }
        for (int i = 1; i < pattern.length(); i=i+2) {
            if (pattern.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    public boolean isMatch(String text, String pattern) {
        if ( text.isEmpty() ) {
            if (pattern.isEmpty()) {
                return true;
            } else {
                return isPatternMatchEmpty(pattern);
            }
        } else if (pattern.isEmpty()) {
            return false;
        }
        //if  here text != empty && patter != empty;
        boolean firstMatch = text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.';
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return  isMatch(text, pattern.substring(2)) || firstMatch && isMatch(text.substring(1), pattern);
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    public boolean isAnyMatch(String pattern) {
        return pattern.equalsIgnoreCase(".*");
    }
    public String removeUnneededAnyMatch(String pattern) {
        if (pattern.length() < 4) {
            return pattern;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < pattern.length() -2) {
            if (pattern.charAt(index + 1) != '*') {
                sb.append(pattern.charAt(index));
                index++;
            } else { //index + 1 = *
                sb.append(pattern.charAt(index));
                sb.append(pattern.charAt(index + 1)); //append *
                String substring = pattern.substring(index + 2);
                StringBuilder cut = new StringBuilder();
                while (removeFromHead(substring, pattern.charAt(index), pattern.charAt(index + 1), cut)){
                    substring = cut.toString();
                    cut.setLength(0); //delete all
                    index = index + 2;
                }
                //move index forward
                index = index + 2;
            }
        }
        for (int i = index; i < pattern.length(); i++) {
            sb.append(pattern.charAt(i));
        }
        return sb.toString();
    }

    public boolean removeFromHead(String source, char firstChar, char secondChar, StringBuilder builder ) {
        if (source.length() < 2) {
            return false;
        } else {
            if (source.charAt(0) == firstChar && source.charAt(1) == secondChar) {
                builder.append(source.substring(2));
                return true;
            } else {
                return false;
            }
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

    public boolean isMatchMe(String s, String p) {
        System.out.println("s=" + s);
        System.out.println("pattern= " + p);
        p = removeUnneededAnyMatch(p);

        if (isAnyMatch(p)) {
            return true;
        }

        if (p.length() > 1 ) {
            if (p.charAt(1) == '*' ) {
                int signCount = countSign(p.substring(2));
                int diff = s.length() - p.substring(2).length() + 2 * signCount;
                if (diff < 0) {
                    System.out.println(s + "!=" + p);
                    return false;
                } else {
                    StringBuilder added = new StringBuilder(p.substring(2));
                    for (int i = 0; i <= diff; i++) {
                        if (isMatch(s, added.toString())) {
                            System.out.println(s + "==" + added.toString());
                            return true;
                        } else {
                            added.insert(0, p.charAt(0));
                        }
                    }
                    return false;
                }

            } else { //p.length >=2 and p.chatAt(1) != "*"
                if (s.isEmpty()) {
                    System.out.println(s + "!=" + p);
                    return false;
                } else {
                    if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                        return isMatch(s.substring(1), p.substring(1));
                    } else {
                        System.out.println(s + "!=" + p);
                        return false;
                    }
                }
            }
        } else { //p.length <= 1
            if (s.length() != p.length()) {
                System.out.println(s + "!=" + p);
                return false;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
                        System.out.println(s + "!=" + p);
                        return false;
                    }
                }
                //System.out.println(s + "==" + p);
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
    public boolean isMatchR(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match =
                (!text.isEmpty() &&
                        (pattern.charAt(0) == text.charAt(0) ||
                                pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (
                    isMatch(text, pattern.substring(2)) ||
                            (first_match && isMatch(text.substring(1), pattern))
            );
        } else {
            return (
                    first_match && isMatch(text.substring(1), pattern.substring(1))
            );
        }
    }
}
