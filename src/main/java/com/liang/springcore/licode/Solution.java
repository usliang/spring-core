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
        s2();
        /*
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            integerList.add(in.nextInt());
        }

        System.out.println(integerList);

         */
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
    private void s1() {
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
    private static void s2() {
        //System.out.printf("please input total of lines%n");
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        //System.out.printf("Need to input %d lines of numbers%n", line);
        List<List<Integer>> lines = new ArrayList<>(line);
        for(int i=1;i<line + 1; i++){
            //System.out.printf("please input number for line %d. The first number is the total numbers in this line %n", i);
            int numberInTheLine = in.nextInt();
            List<Integer> list = new ArrayList<>(numberInTheLine);
            for(int j=0;j<numberInTheLine;j++){
                list.add(in.nextInt());
            }
            lines.add(list);
        }

        //handle query input
        //System.out.println("please input the query count");
        int queryCount = in.nextInt();
        List<List<Integer>> query = new ArrayList<>(queryCount); //each query holds x andy two number

        for(int i=0;i<queryCount;i++){
            List<Integer> list = new ArrayList<>(2);
            //System.out.printf("please input query #  %d%n", i + 1);
            int x = in.nextInt();
            int y = in.nextInt();
            list.add(x);
            list.add(y);
            query.add(list);
        }

        //print out by query
        for(int i=0;i<queryCount;i++){
            int x = query.get(i).get(0);
            int y = query.get(i).get(1);

            if ((x -1) < lines.size() && (y -1) < lines.get(x-1).size()) {
                Integer result = lines.get(x - 1).get(y - 1);
                if (result != null) {
                    System.out.println(result);
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
