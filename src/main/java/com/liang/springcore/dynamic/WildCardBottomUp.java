package com.liang.springcore.dynamic;

public class WildCardBottomUp {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //set dp[1--length][0] to false
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {

            }
        }
    }
}
