package com.liang.springcore.dynamic;

public class WildCardBottomUp {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int j = 1; j <= p.length(); j++) {
            char cp = p.charAt(j - 1);
            for (int i = 1; i <= s.length(); i++) {
                char cs = s.charAt(i - 1);
                if ((cp == cs) || (cp == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }  else if (cp == '*') {
                    dp[i][j] = dp[i - 1][j]  || dp[i ][j - 1];
                }
                else {
                    dp[i][j] = false;
                }

            }
        }
        return dp[s.length()][p.length()];
    }
    public boolean isPatternMatchEmpty(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
