package com.liang.springcore.alog;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String longSub = longestSubstring("abacdec");
        System.out.println(longSub);
    }
    public static String longestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        Set<Character> characterSet = new HashSet<>();
        char[]  chars = str.toCharArray();
        String longest = String.valueOf(chars[0]);
        String longestSofar = longest;
        characterSet.add(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (characterSet.contains(chars[i])) {
                if (longestSofar.length() > longest.length()) {
                    longest = longestSofar;
                }
                int foundLocation = longestSofar.indexOf(chars[i]);
                int startIndex = foundLocation + 1;
                longestSofar = longestSofar.substring(startIndex) + chars[i];
            } else  {
                characterSet.add(chars[i]);
                longestSofar  = longestSofar + chars[i];
            }
        }
        if (longestSofar.length() > longest.length()) {
            return longestSofar;
        } else {
            return longest;
        }
    }
}
