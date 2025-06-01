package com.liang.springcore.licode;

import java.util.Stack;

public class SimpleCalculator {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        return process(s, stack);
    }

    public int calculate2(String s) {
        Stack<String> stack = new Stack<>();
        return process(s, stack);
    }

    public static void main(String[] args) {

    }

    public int process(String s, Stack<String> stack) {
        if (s.isEmpty()) {
            if (!stack.isEmpty()) {
                return processStack(stack);
            } else {
                return 0;
            }
        } else {
            switch (s.charAt(0)) {
                case '+':
                    stack.push("+");
                    break;
                case '-':
                    stack.push("-");
                    break;
                case ' ':
                    break;
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    //process stack
                    stack.push(")");
                    String res = String.valueOf(processStackWithBrackets(stack));
                    for (int i = 0; i < res.length(); i++) {
                        stack.push(res.substring(i, i + 1));
                    }
                    break;
                default:
                    stack.push(s.substring(0, 1));
                    break;
            }
            s = s.substring(1);
            return process(s, stack);
        }
    }

    public int process1(String s, Stack<String> stack) {
        if (s.isEmpty()) {
            if (!stack.isEmpty()) {
                return processStack(stack);
            } else {
                return 0;
            }
        } else {
            switch (s.charAt(0)) {
                case '+':
                    stack.push("+");
                    break;
                case '-':
                    stack.push("-");
                    break;
                case ' ':
                    break;
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    //process stack
                    stack.push(")");
                    String res = String.valueOf(processStackWithBrackets(stack));
                    for (int i = 0; i < res.length(); i++) {
                        stack.push(res.substring(i, i + 1));
                    }
                    break;
                default:
                    stack.push(s.substring(0, 1));
                    break;
            }
            s = s.substring(1);
            return process(s, stack);
        }
    }

    public int processStack(Stack<String> stack) {
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                return Integer.parseInt(stack.pop());
            } else if (stack.size() >= 3) {
                String b = stack.pop();
                String op = stack.pop();
                String a = stack.pop();
                if (op.equals("+")) {
                    int result = Integer.parseInt(a) + Integer.parseInt(b);
                    stack.push(String.valueOf(result));
                }else {
                    int result = Integer.parseInt(a) - Integer.parseInt(b);
                    stack.push(String.valueOf(result));
                }
            } else {
                throw new ArithmeticException(stack.toString());
            }
        }
        return 0;
    }

    public int processStack1(Stack<String> stack) {
        return 0;
    }

    public int processStackWithBrackets(Stack<String> stack) {
        stack.pop(); // pop ")"
        int res = processStack(stack);
        stack.pop();
        return res;
    }

    public int popNumber(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && !stack.peek().equals("+") && !stack.peek().equals("-") && !stack.peek().equals("(")) {
            sb.append(stack.pop());
        }
        String s = sb.reverse().toString();
        int res = Integer.parseInt(s);
        return res;
    }
}
