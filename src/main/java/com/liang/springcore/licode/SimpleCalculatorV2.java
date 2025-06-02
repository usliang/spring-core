package com.liang.springcore.licode;

import java.util.Stack;

public class SimpleCalculatorV2 {
    public static void main(String[] args) {

    }
    public int calculate(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0)=='-') {
            if (s.charAt(1)=='(') {
                return -calculate(s.substring(1));
            } else {
                String num1 = getNumber(s, 1);
                if (num1.length() + 1 == s.length()) {
                    return -Integer.parseInt(removeSpaces(num1));
                }
                char op = s.charAt(num1.length()+1);
                String num2 = getNumber(s, num1.length()+2);
                if (op == '+') {
                    return -Integer.parseInt(removeSpaces(num1)) + Integer.parseInt(removeSpaces(num2)) +
                            calculate (s.substring(num1.length()+num2.length()+2));
                } else {
                    return -Integer.parseInt(removeSpaces(num1)) - Integer.parseInt(removeSpaces(num2)) +
                            calculate (s.substring(num1.length()+num2.length()+2));
                }
            }

        } else if (s.charAt(0)=='(') {
            String subNoBracket = getNumberBeforeRightBracket(s, 1);
            return calculate(subNoBracket) + calculate(s.substring(subNoBracket.length() + 2));
        } else if (s.charAt(0)==' ' || s.charAt(0)=='+') {
            return calculate(s.substring(1));
        } else { //a, a+b or a-b
            String num1 = getNumber(s, 0);
            if (num1.length() == s.length()) {
                return Integer.parseInt(num1);
            }
            char op = s.charAt(num1.length());
            String num2 = getNumber(s, num1.length()+1);
            if (op == '+') {
                return Integer.parseInt(removeSpaces(num1)) + Integer.parseInt(removeSpaces(num2)) +
                        calculate (s.substring(num1.length()+num2.length()+1));
            } else {
                return Integer.parseInt(removeSpaces(num1)) - Integer.parseInt(removeSpaces(num2)) +
                        calculate (s.substring(num1.length()+num2.length()+1));
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
