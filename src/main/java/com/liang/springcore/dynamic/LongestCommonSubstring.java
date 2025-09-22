package com.liang.springcore.dynamic;

public class LongestCommonSubstring {

    public static String longestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] = length of longest common string ending at s1[i-1], s2[j-1]
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0; // ending index of the substring in s1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i; // record end position
                    }
                } else {
                    dp[i][j] = 0; // reset since substring must be contiguous
                }
            }
        }

        return s1.substring(endIndex - maxLength, endIndex);
    }

    public static void main(String[] args) {
        String s1 = "ABABC";
        String s2 = "ABABCAC";
        String result = longestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring: " + result);

        s1 = "a";
        s2 = "aaaaa";
        result = longestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring: " + result);

    }
}
