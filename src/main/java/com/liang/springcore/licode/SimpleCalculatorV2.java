package com.liang.springcore.licode;

public class SimpleCalculatorV2 {
    public static void main(String[] args) {

    }
    public int calculate(String s) {
        return calculateR(removeSpaces(s));
    }

    public int calculateN(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int counter = 0;
        int result = 0;
        while (counter < s.length()) {
            if (s.charAt(counter)=='-') {
                if (s.charAt(counter + 1) == '(') {
                    String subNoBracket = getNumberBeforeRightBracket(s, counter + 2);
                    result = result - calNoBracket(subNoBracket);
                    counter = counter + subNoBracket.length() + 3;
                } else {
                    String num1 = getNumber(s, counter + 1);
                    result = result - Integer.parseInt(num1);
                    counter = counter + 1 + num1.length();
                }
            } else if (s.charAt(counter) == '+') {
                if (s.charAt(counter + 1) == '(') {
                    String subNoBracket = getNumberBeforeRightBracket(s, counter + 2);
                    result = result + calNoBracket(subNoBracket);
                    counter = counter + subNoBracket.length() + 3;
                } else {
                    String num1 = getNumber(s, counter + 1);
                    result = result + Integer.parseInt(num1);
                    counter = counter + 1 + num1.length();
                }
            } else if (s.charAt(counter) == '(') {
                String subNoBracket = getNumberBeforeRightBracket(s, counter + 1);
                result = result + calNoBracket(subNoBracket);
                counter = counter + 1 + subNoBracket.length();
            }
        }
        return result;
    }

    public int calNoBracket(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int counter = 0;
        int result = 0;
        while (counter < s.length()) {
            if (s.charAt(counter) == '-') {
                String num1 = getNumber(s, counter + 1);
                result = result - Integer.parseInt(num1);
                counter = counter + 1 + num1.length();
            } else if (s.charAt(counter) == '+') {
                String num1 = getNumber(s, counter + 1);
                result = result + Integer.parseInt(num1);
                counter = counter + 1 + num1.length();
            } else {
                String num1 = getNumber(s, counter);
                result = result + Integer.parseInt(num1);
            }
        }
        return result;
    }


    public int calculateR(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0)=='-') {
            if (s.charAt(1)=='(') {
                String subNoBracket = getNumberBeforeRightBracket(s, 2);
                return -calculateR(subNoBracket) + calculateR(s.substring(subNoBracket.length() + 3));
            } else {
                String num1 = getNumber(s, 1);
                if (num1.length() + 1 == s.length()) {
                        return -Integer.parseInt(num1);
                } else {
                    return -Integer.parseInt(num1) + calculateR(s.substring(num1.length() + 1));
                }
            }

        } else if (s.charAt(0)=='(') {
            String subNoBracket = getNumberBeforeRightBracket(s, 1);
            return calculateR(subNoBracket) + calculateR(s.substring(subNoBracket.length() + 2));
        } else if (s.charAt(0)=='+') {
            return calculateR(s.substring(1));
        } else { //a, a+b or a-b
            String num1 = getNumber(s, 0);
            if (num1.length() == s.length()) {
                return Integer.parseInt(num1);
            } else {
                return Integer.parseInt(num1) + calculateR(s.substring(num1.length()));
            }
        }
    }
    public String getNumber(String s, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) !='+' && s.charAt(i) !='-' && s.charAt(i) != '(' && s.charAt(i) != ')') {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public String getNumberBeforeRightBracket(String s, int start) {
        StringBuilder sb = new StringBuilder();
        int leftBracketToMatch = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) =='(') {
                leftBracketToMatch++;
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (leftBracketToMatch > 0) {
                    sb.append(s.charAt(i));
                    leftBracketToMatch--;
                } else {
                    break;
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public String removeSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
