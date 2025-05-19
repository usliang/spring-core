package com.liang.springcore.licode;

import java.util.ArrayList;
import java.util.List;

public class TwoStrOneCharDiff {
    public static void main(String[] args) {
        String str1 ="aaaa";
        String str2 = "aaaab";
        List<Integer> list = findPositions(str1, str2);
        System.out.println(list);

        str1 ="";
        str2 = "b";
        list = findPositions(str1, str2);
        System.out.println(list);

        str1 ="abbbc";
        str2 = "abbbbc";
        list = findPositions(str1, str2);
        System.out.println(list);

        str1 ="abbbc";
        str2 = "abcbbb";
        list = findPositions(str1, str2);
        System.out.println(list);
    }
    public static List<Integer> findPositions(String str1, String str2) {
        List<Integer> list = new ArrayList<>();
        StringBuilder shortStr;
        StringBuilder longStr;
        if (str1.length() < str2.length()) {
            shortStr = new StringBuilder(str1);
            longStr = new StringBuilder(str2);
        } else if (str2.length() < str1.length()) {
            shortStr = new StringBuilder(str2);
            longStr = new StringBuilder(str1);
        } else { //str1 length = str2 length
            throw new IllegalArgumentException("the length of the longest sequence should be 1 more than the shortest sequence");
        }
        if ((longStr.length() - shortStr.length()) != 1) {
            throw new IllegalArgumentException("the length of the longest sequence should be 1 more than the shortest sequence");
        }


        int diffPosition = -1;
        for (int i = 0; i < str1.length(); i++) {
            if (shortStr.charAt(i) != longStr.charAt(i)) {
                diffPosition = i;
                break;
            }
        }
        if (diffPosition == -1) {  //if longStr contain shortStr return the last char of the long string
            diffPosition = shortStr.length();
        }
        StringBuilder deletedOneChar =new StringBuilder(longStr);
        deletedOneChar.deleteCharAt(diffPosition);
        if (deletedOneChar.toString().equals(shortStr.toString())) {
            //find the other possible positions as well
            int startPosition = -1;
            for (int i = diffPosition - 1; i >= 0; i--) {
                if (shortStr.charAt(i) == longStr.charAt(diffPosition)) {
                    startPosition = i;
                } else {
                    break;
                }
            }
            if (startPosition != -1) {
                for (int i = startPosition; i <= diffPosition; i++) {
                    list.add(i);
                }
            } else {
                list.add(diffPosition);
            }
        } else { //delete the diff; but the two strs is not the same
            list.add(-1);
        }
        return list;
    }
}
