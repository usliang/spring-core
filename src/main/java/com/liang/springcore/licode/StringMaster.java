package com.liang.springcore.licode;

public class StringMaster {
    public void reverseString(char[] s) {
        for (int i=0, j = s.length -1; i<j ; i++, j--) {
            char ch = s[j];
            s[j] = s[i];
            s[i] = ch;
        }
    }

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow before actually multiplying or adding
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }

    public int firstUniqChar(String s) {
       int[] chCounts = new int[26];
       for (int i=0; i<s.length(); i++) {
           chCounts[s.charAt(i)-'a']++;
       }
        for (int i=0; i<s.length(); i++) {
            if (chCounts[s.charAt(i)-'a']==1) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chCounts = new int[26];
        for (int i=0; i<s.length(); i++) {
            chCounts[s.charAt(i)-'a']++;
        }
        for (int i=0; i<t.length(); i++) {
            chCounts[t.charAt(i)-'a']--;
            if (chCounts[t.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        String str = filter(s);
        int len = str.length();
        for (int i=0, j=len-1; i<j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public String filter(final String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch - 'A' + 'a'));
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (!isLetterOrDigit(left)) { i++; continue; }
            if (!isLetterOrDigit(right)) { j--; continue; }

            if (toLower(left) != toLower(right)) return false;

            i++;
            j--;
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9');
    }

    private static char toLower(char c) {
        return (c >= 'A' && c <= 'Z') ? (char)(c - 'A' + 'a') : c;
    }

    public int myAtoi(String s) {
        int i=0;
        int ret=0;
        boolean isNegative = false;
        boolean isSignFound = false;
        while (i<s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (isSignFound) {
                    break;
                }
            } else if (ch == '-') {
                if (!isSignFound) {
                    isSignFound = true;
                    isNegative = true;
                } else {
                    break;
                }
            } else if (ch == '+') {
                if (!isSignFound) {
                    isSignFound = true;
                } else {
                    break;
                }
            } else if (ch>='0' && ch <='9') {
                int number = ch - '0';
                if (isSignFound) {
                    if (isNegative) {
                        number = -number;
                    }
                } else {
                    isSignFound = true;
                }
                if (isNegative) {
                    if (ret < Integer.MIN_VALUE / 10 || (ret == (int)(Integer.MIN_VALUE/10) && number < -8)) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (ret > Integer.MAX_VALUE / 10 || (ret == (int)(Integer.MAX_VALUE/10) && number > 7)) {
                        return Integer.MAX_VALUE;
                    }
                }
                ret = (ret * 10) + number;
            } else {
                break;
            }
            i++;
        }
        return ret;
    }

    public int strStr1(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int i = 0;
        while (i<=haystack.length()-needle.length() ) {
            if (haystack.charAt(i) == needle.charAt(0)){
                boolean match = true;
                for(int j = 1; j< needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)){
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i; //if here, needle found
                }
            }
            i++;
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int stackLen = haystack.length();
        int needleLen = needle.length();
        if (stackLen<needleLen) {
            return -1;
        }
        if (needleLen==0) {
            return 0;
        }
        int i =0;
        int[] lps = buildLPS(needle);
        int j = 0;
        while (i<stackLen) {
            if (haystack.charAt(i) == needle.charAt(j)){
                if (j==needleLen-1) {
                    return i-j;
                }
                i++;
                j++;
            } else {
                if (j>0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public int[] buildLPS(String needle) {
        int size = needle.length();
        int[] lps = new int[size];
        lps[0] = 0;
        int prefixLen = 0; //len the current prefix
        int i = 1;
        while (i<size) {
            if (needle.charAt(i) == needle.charAt(prefixLen)) {
                prefixLen++;
                lps[i]=prefixLen;
                i++;
            } else {
                if (prefixLen>0) {
                    prefixLen = lps[prefixLen-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].isEmpty()) {
            return "";
        }
        int i;
        for (i = 0; i<strs[0].length(); i++) {
            boolean found = true;
            char ch = strs[0].charAt(i);
            for (int j= 1; j< strs.length; j++) {
                if (i<strs[j].length()){
                    if (ch != strs[j].charAt(i)){
                        found = false;
                        break;
                    }
                } else {
                  found = false;
                  break;
                }
            }
            if (!found) {
                break;
            }
        }
        return strs[0].substring(0,i);
    }
}
