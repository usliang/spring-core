package com.liang.springcore.licode;

import java.util.ArrayList;
import java.util.List;

/****
 * Created by liliang on 5/13/25.
 ****/
public class StrMultiplyProcessor {
    public static void main(String[] args) {
        StrMultiplyProcessor strMultiplyProcessor = new StrMultiplyProcessor();
        String str1 = "100";
        String str2 = "50";
        //String str3 = stringMultiplier.add(str1, str2);
        //System.out.println(str3);
        String str3 = strMultiplyProcessor.multiply(str1, str2);
        System.out.println(str3);

    }
    public  String multiply(String a, String b) {


        if (a.equalsIgnoreCase("0") || b.equalsIgnoreCase("0")) {
            return "0";
        }

        String shortList, longList;
        if (a.length() < b.length()) {
            shortList = a;
            longList = b;
        } else {
            shortList = b;
            longList = a;
        }
        StringBuilder firstNumber = new StringBuilder(longList);
        StringBuilder secondNumber = new StringBuilder(shortList);

        // Reverse both the numbers.
        firstNumber.reverse();
        secondNumber.reverse();
        List<List<Integer>> results = new ArrayList<>(secondNumber.length());
        for (int i = 0; i < secondNumber.length(); i++) {
            results.add(multiplyByOneDigit(firstNumber, secondNumber.charAt(i), i));
        }
        return sumResults(results);
    }



    public List<Integer> multiplyByOneDigit(final StringBuilder integerList, final char digits, final int position) {
        ArrayList<Integer> result = new ArrayList<>();

        if (digits == 0) {
            result.add(0);
            return result;
        }


        for (int i = 0; i < position; i++) {
            result.add(0);
        }
        int carry = 0;
        for (int i = 0; i < integerList.length(); i++) {
            int product = (integerList.charAt(i) - '0') * (digits - '0') + carry;
            carry = product / 10;
            result.add(product % 10);
        }
        if (carry > 0) {
            result.add(carry);
        }
        return result;
    }

    public String sumResults(final List<List<Integer>> results) {
        ArrayList<Integer> answer = new ArrayList<>(results.get(results.size() - 1));
        for (int i = 0; i < results.size() - 1; i++) {
           int carry = 0;
           ArrayList<Integer> current = new ArrayList<>(answer.size());
           for (int j = 0; j<answer.size() || j< results.get(i).size(); j++) {
                int digit1 = j<answer.size() ? answer.get(j) : 0;
                int digit2 = j< results.get(i).size() ? results.get(i).get(j) : 0;
                int sum = digit1 + digit2 + carry;
                carry = sum / 10;
                current.add(sum % 10);
           }
           if (carry > 0) {
               current.add(carry);
           }
           answer = current;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
        }
        return sb.reverse().toString();
    }
}
