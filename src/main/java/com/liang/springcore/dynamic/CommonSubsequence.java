package com.liang.springcore.dynamic;

public class CommonSubsequence {

    public int longestCommonSubsequence2D(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int max = 0;
        for (int i = 1; i <= text1.length(); i++) {
            int j;
            for (j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }  else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
            }
        }
        return max;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // Ensure text2 is the shorter one to minimize memory
        if (n > m) { String t = text1; text1 = text2; text2 = t; m = text1.length(); n = text2.length(); }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prevDiag = 0; // dp[j-1] from previous row
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                char b = text2.charAt(j - 1);
                if (a == b) {
                    dp[j] = prevDiag + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiag = temp;
            }
        }
        return dp[n];
    }
}
