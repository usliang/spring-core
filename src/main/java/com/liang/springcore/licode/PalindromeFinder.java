package com.liang.springcore.licode;

public class PalindromeFinder {
    public static void main(String[] args) {
        String s = "9baabccccccbccccccbaab";
        System.out.println(findPalindromeV2(s));
    }
    public static String findPalindromeV1(String s) {
        int longest = s.length();
        while (longest > 1 ) {
            for (int i = 0; i <= s.length() - longest; i++) {
                String sub = s.substring(i, i + longest);
                if (isPalindrome(sub.toCharArray())) {
                    return sub;
                }
            }
            longest--;
        }
        return s.substring(0, 1);
    }

    public static String findPalindromeV2(String s) {
        int longest = 1;
        String longestStr = "";
        while (longest <= s.length() ) {
            int start = 0;
            while (start <= s.length() - longest) {
                String sub = s.substring(start, start + longest);
                if (isPalindrome(sub.toCharArray())) {
                    //save the candidate
                    longestStr = sub;
                    //expand the found from left
                    for (int left = start-1; left >= 0; left--) {
                       if (isPalindrome(s.substring(left, start + longest).toCharArray())) {
                           longestStr = s.substring(left, start + longest);
                       }else {
                           break;
                       }
                    }
                    //expand the found from right
                    for (int right = start + longest + 1; right <= s.length(); right++) {
                        if (isPalindrome(s.substring(start, right).toCharArray())) {
                            longestStr = s.substring(start, right);
                        }else {
                            break;
                        }
                    }
                    //expand from both side
                    int left = start -1;
                    int right = start + longest + 1;
                    while (left >= 0 && right < s.length()) {
                        if (isPalindrome(s.substring(left, right).toCharArray())) {
                            longestStr = s.substring(left, right);
                            left--;
                            right++;
                        }else {
                            break;
                        }
                    }
                    longest = longestStr.length() + 1;
                    break;
                }else {
                    start++;
                }
            }
            longest++;
        }
        return longestStr;
    }


    public static   boolean isPalindrome(char[] input) {
        if (input.length == 1) {
            return  true;
        }

        for (int i = 0; i < input.length / 2; i++) {
            if (input[i] != input[input.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
