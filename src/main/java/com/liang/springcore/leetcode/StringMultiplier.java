package com.liang.springcore.leetcode;

public class StringMultiplier {
    public static void main(String[] args) {
        StringMultiplier stringMultiplier = new StringMultiplier();
        String str1 = "999";
        String str2 = "999999999999";
        //String str3 = stringMultiplier.add(str1, str2);
        //System.out.println(str3);
        String str3 = stringMultiplier.multiply(str1, str2);
        System.out.println(str3);
    }

    public String multiply(String num1, String num2) {
        if (num1.equalsIgnoreCase("0") || num2.equalsIgnoreCase("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] shortChars, longChars;

        if (chars1.length > chars2.length) {
            shortChars = chars2;
            longChars = chars1;
        } else {
            shortChars = chars1;
            longChars = chars2;
        }

        StringBuffer[] interProds = new StringBuffer[shortChars.length];


        for (int i = shortChars.length-1; i >= 0; i--) {
            int carry = 0;
            interProds[i] = new StringBuffer();
            for (int j = longChars.length-1; j >= 0; j--) {
                int product = ((shortChars[i]-'0') * (longChars[j] - '0')) + carry;
                carry = product / 10;
                int digit = product % 10;
                interProds[i].append(digit);
            }
            if (carry > 0) {
                interProds[i].append(carry);
            }
        }
        if (interProds.length == 1) {
            return interProds[0].reverse().toString();
        }
        String sum = null;
        if (interProds.length >= 2) {
            String digit1 = interProds[interProds.length-1].reverse().toString();
            String digit2 = interProds[interProds.length-2].reverse().toString() + "0";
            sum = add(digit1, digit2);

            for (int i = interProds.length - 3; i >= 0; i--) {
                //add the right 0 to the end
                String digitNext = interProds[i].reverse().toString();
                for (int j = interProds.length-1; j > i; j--) {
                    digitNext = digitNext + "0";
                }
                sum = add(digitNext, sum);
            }
        }
        return sum;
    }
    public String add(String num1, String num2) {
        if (num1.equalsIgnoreCase("0")) {
            return num2;
        }
        if (num2.equalsIgnoreCase("0")) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        //pad 0 to short string, so both strings are the same size
        String shortStr;
        String longStr;
        if (num1.length() > num2.length()) {
            shortStr = num2;
            longStr = num1;
        } else {
            shortStr = num1;
            longStr = num2;
        }
        for (int i = 0; i < longStr.length() - shortStr.length(); i++) {
            sb.append("0");
        }
        shortStr = sb.toString() + shortStr;
        sb.setLength(0);
        char[] shortChars = shortStr.toCharArray();
        char[] longChars = longStr.toCharArray();

        int carry = 0;
        for (int i = longChars.length-1; i >= 0; i--) {
                int sum = (shortChars[i]-'0') + (longChars[i] - '0') + carry;
                carry = sum / 10;
                int  digit = sum % 10;
                sb.append(digit);
        }

        if (carry > 0) {
            sb.append( carry);
        }
        return sb.reverse().toString();
    }
}
