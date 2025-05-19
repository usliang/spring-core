package com.liang.springcore.licode;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int startPos = 0, endPos = 0;

        for (int i = 0; i < s.length(); i++) {
            int lenOdd = expandLeftNRight(s, i, i);       // Odd length
            int lenEven = expandLeftNRight(s, i, i + 1);   // Even length
            int lenMax = Math.max(lenOdd, lenEven);

            if (lenMax > endPos - startPos) {
                startPos = i - (lenMax - 1) / 2;
                endPos   = i + lenMax / 2;
            }
        }

        return s.substring(startPos, endPos + 1);
    }

    private static int expandLeftNRight(String input, int left, int right) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Adjust because loop exits when mismatch occurs
    }

    public static void main(String[] args) {
        String input = "aaaaaa";
        int times = 1;
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            System.out.println(longestPalindrome(input));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
