package com.liang.springcore.licode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSequence(a, b, n);
        }
        in.close();
    }
    private static void printSequence(int a, int b, int n) {
        int next = a + b;
        System.out.print(next + " ");
        for (int i = 1; i < n-1; i++) {
            next += (int) Math.pow(2, i) * b;
            System.out.print(next + " ");
        }
        System.out.println(next + (int)Math.pow(2, n-1) * b);
    }
}
