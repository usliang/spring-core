package com.liang.springcore.dynamic;

import java.util.HashMap;
import java.util.Map;

public class WildCardDynamic {
    record InputPair(int i, int j) {};
    Map<InputPair, Boolean> map;

    public WildCardDynamic() {
        this.map =  new HashMap<InputPair, Boolean>();
    }

    public boolean isMatch(String s, String p) {
        return isMatchRecursive(s, p, 0, 0);
    }
    private boolean isMatchRecursive(String s, String p, int i, int j) {
        InputPair pair = new InputPair(i, j);
        if (map.containsKey(pair)) {
            return map.get(pair);
        }
        //base case
        if (i == s.length() && j == p.length()) {
            map.put(pair, true);
            return true;
        } else if (i != s.length() && j == p.length()) {
            map.put(pair, false);
            return false;
        } else if (i == s.length()) {
            if (isPatternMatchEmpty(p.substring(j))) {
                map.put(pair, true);
                return true;
            } else  {
                map.put(pair, false);
                return false;
            }
        }
        char sc = s.charAt(i);
        char pc = p.charAt(j);

        if (sc == pc || pc == '?') {
            boolean result = isMatchRecursive(s, p, i + 1, j + 1);
            map.put(pair, result);
            return result;
        }  else if (pc == '*') {
            boolean result = (isMatchRecursive(s, p, i, j + 1) || isMatchRecursive(s, p, i + 1, j));
            map.put(pair, result);
            return result;
        }  else {
            map.put(pair, false);
            return false;
        }
    }
    private boolean isPatternMatchEmpty(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
