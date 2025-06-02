package com.liang.springcore.licode;

import java.util.Stack;

public class SimpleCalculatorV1 {
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
                    int n = popNumber(stack);
                    stack.push(String.valueOf(n));
                    stack.push("+");
                    break;
                case '-':
                    if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")")) {
                        int n2 = popNumber(stack);
                        stack.push(String.valueOf(n2));
                    }
                    stack.push("-");
                    break;
                case ' ':
                    break;
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    //process stack
                    int n3 = popNumber(stack);
                    stack.push(String.valueOf(n3));
                    stack.push(")");
                    String res = String.valueOf(processStackWithBrackets(stack));
                    stack.push(res);
                    break;
                default:
                    stack.push(s.substring(0, 1));
                    if (s.length()==1) { //last letter in s
                        int n4 = popNumber(stack);
                        stack.push(String.valueOf(n4));
                    }
                    break;
            }
            s = s.substring(1);
            return process(s, stack);
        }
    }

    //process a stock without brackets
    public int processStack(Stack<String> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        Stack<String> leftToRight = new Stack<>();
        while (!stack.isEmpty()) {
            leftToRight.push(stack.pop());
        }
        return  processLeftToRight(leftToRight);
    }
    public int processLeftToRight(Stack<String> leftToRight ) {
        //check if the first string is -
        int first;
        if (leftToRight.peek().equals("-")) {
            leftToRight.pop();
            if (!leftToRight.isEmpty()) {
                first = -Integer.parseInt(leftToRight.pop());
            }else {
                throw new IllegalArgumentException("only - in the stack");
            }
            if (leftToRight.isEmpty()) {
                return first;
            }
        } else {
            first = Integer.parseInt(leftToRight.pop());
        }

        while (leftToRight.size() >=2) {
            String op = leftToRight.pop();
            int second = Integer.parseInt(leftToRight.pop());
            if (op.equals("+")) {
                first = first + second;
            } else if (op.equals("-")) {
                first = first - second;
            } else {
                throw new IllegalArgumentException("operator not recognized" + op);
            }

        }
        return first;
    }

    public int processStackWithOneBracket(Stack<String> stack) {
        Stack<String> leftToRight = new Stack<>();
        while (!stack.isEmpty() && !stack.peek().equals("(")){
            leftToRight.push(stack.pop());
        }
        // should not reach here
        return processLeftToRight(leftToRight);
    }

    public int processStack1(Stack<String> stack) {
        return 0;
    }

    public int processStackWithBrackets(Stack<String> stack) {
        stack.pop(); // pop ")"
        int res = processStackWithOneBracket(stack);
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
