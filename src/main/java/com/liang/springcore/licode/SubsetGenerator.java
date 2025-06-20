package com.liang.springcore.licode;

import java.util.*;

public class SubsetGenerator {

    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        List<String> subsets = new ArrayList<>();

        generateSubsets(set, 0, new StringBuilder(), subsets);

        System.out.println("All subsets:");
        for (String subset : subsets) {
            System.out.println(subset);
        }
    }

    // Recursive function to generate all subsets
    private static void generateSubsets(char[] set, int index, StringBuilder current, List<String> result) {
        if (index == set.length) {
            result.add(current.toString());
            return;
        }

        // Include the current character
        current.append(set[index]);
        generateSubsets(set, index + 1, current, result);

        // Exclude the current character (backtrack)
        current.deleteCharAt(current.length() - 1);
        generateSubsets(set, index + 1, current, result);
    }
}
