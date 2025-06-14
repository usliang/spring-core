package com.liang.springcore.licode;

import java.util.Stack;

public class SimpleCalculatorV2 {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        s=removeSpaces(s);
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * number;
                i--; // step back because the for-loop will increment
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                // Push current result and sign
                stack.push(result);
                stack.push(sign);
                // Reset for inner expression
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
            // ignore whitespace
        }

        return result;
    }
    
    public int calculateLi(String s) {
        return calculateN(removeSpaces(s));
    }

    public int calculateN(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int firstLeft = s.indexOf('(');
        if (firstLeft == -1) {
            return  calNoBracket(s);
        } else {
            String numberBeforeRightBracket = getNumberBeforeRightBracket(s, firstLeft+1);
            String substring = s.substring(firstLeft + numberBeforeRightBracket.length() + 2);
            if (firstLeft == 1) {
                if (s.charAt(0) == '-') {
                    return -calculateN(numberBeforeRightBracket) + calculateN(substring);
                } else {
                    return calculateN(numberBeforeRightBracket) + calculateN(substring);
                }
            }else if (firstLeft == 0) {
                return calculateN(numberBeforeRightBracket) + calculateN(substring);
            } else { //firstLeft > 1
                char sign = s.charAt(firstLeft-1);
                if (sign == '+') {
                    return calNoBracket(s.substring(0, firstLeft-1)) + calculateN(numberBeforeRightBracket) + calculateN(substring);
                } else {
                    return calNoBracket(s.substring(0, firstLeft-1)) - calculateN(numberBeforeRightBracket) + calculateN(substring);
                }
            }
        }
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
                counter = counter + num1.length();
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

    

    public int calculateStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return calNoBracket(sb.reverse().toString());
    }
}
