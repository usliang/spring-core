package com.liang.springcore.licode;

import java.util.ArrayList;

/****
 * Created by liliang on 5/13/25.
 ****/
public class StrMultiplyProcessor {
    public static void main(String[] args) {
        StrMultiplyProcessor strMultiplyProcessor = new StrMultiplyProcessor();

    }
    public  String multiply(String a, String b) {

    }
    public String sumResults(final ArrayList<ArrayList<Integer>> results) {
        ArrayList<Integer> answer = new ArrayList<>(results.get(results.size() - 1));
        for (int i = 0; i < results.size() - 1; i++) {
           int carry = 0;
           ArrayList<Integer> current = new ArrayList<>(results.get(i));
           for (int j = 0; j<answer.size() || j< results.get(i).size(); j++) {
                int digit1 = j<answer.size() ? answer.get(j) : 0;
                int digit2 = j< results.get(i).size() ? results.get(i).get(j) : 0;
                int sum = digit1 + digit2 + carry;
           }
        }

    }
}
