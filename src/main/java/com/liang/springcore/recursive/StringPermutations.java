package com.liang.springcore.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermutations {

    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper(str, "", permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String str, String current, List<String> permutations) {
        permutations.add(current);
        if (str.isEmpty()) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutationsHelper(remaining, current + ch, permutations);
        }
    }

    private static void generatePermutationsHelper(List<Character> str, List<Character> current, List<List<Character>> permutations) {
        permutations.add(current);
        if (str.isEmpty()) {
            return;
        }

        for (int i = 0; i < str.size(); i++) {
            char ch = str.get(i);
            List<Character> remaining = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                remaining.add(str.get(j));
            }
            for (int j = i+1; j < str.size(); j++) {
                remaining.add(str.get(j));
            }
            List<Character> np = new ArrayList<>(current);
            np.add(ch);
            generatePermutationsHelper(remaining, np, permutations);
        }
    }


    public static void main(String[] args) {
        /*
        String input = "abc";
        List<String> permutations = generatePermutations(input);
        System.out.println("Permutations of \"" + input + "\":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
         */
        List<Character> chars = Arrays.asList('a', 'b', 'c');
        List<Character> current = new ArrayList<>();
        List<List<Character>> permutations = new ArrayList<>();
        generatePermutationsHelper(chars, current, permutations);
        System.out.println(permutations);
    }
}