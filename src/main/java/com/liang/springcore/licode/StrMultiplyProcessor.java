package com.liang.springcore.licode;

import java.util.ArrayList;
import java.util.List;

/****
 * Created by liliang on 5/13/25.
 ****/
public class StrMultiplyProcessor {
    public static void main(String[] args) {
        StrMultiplyProcessor strMultiplyProcessor = new StrMultiplyProcessor();
        String str1 = "999";
        String str2 = "99";
        //String str3 = stringMultiplier.add(str1, str2);
        //System.out.println(str3);
        String str3 = strMultiplyProcessor.multiply(str1, str2);
        System.out.println(str3);

    }
    public  String multiply(String a, String b) {
        List<Integer> list1 = toList(a);
        List<Integer> list2 = toList(b);

        if (list1.size() ==1 && list1.get(0) == 0) {
            return "0";
        }
        if (list2.size() ==1 && list2.get(0) == 0) {
            return "0";
        }
        List<Integer> shortList, longList;
        if (list1.size() < list2.size()) {
            shortList = list1;
            longList = list2;
        } else {
            shortList = list2;
            longList = list1;
        }
        List<List<Integer>> results = new ArrayList<>(shortList.size());
        for (int i = 0; i < shortList.size(); i++) {
            List<Integer> oneDigitProduct = multiplyByOneDigit(longList, shortList.get(i), i);
            results.add(oneDigitProduct);
        }
        return sumResults(results);
    }

    public List<Integer> toList(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            list.add(Integer.parseInt(stringBuilder.substring(i, i + 1)));
        }
        return list;
    }

    public List<Integer> multiplyByOneDigit(List<Integer> integerList,  int digits, int position) {
        ArrayList<Integer> result = new ArrayList<>();

        if (digits == 0) {
            result.add(0);
            return result;
        }


        for (int i = 0; i < position; i++) {
            result.add(0);
        }
        int carry = 0;
        for (int i = 0; i < integerList.size(); i++) {
            int product = integerList.get(i) * digits + carry;
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
               answer.add(carry);
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
