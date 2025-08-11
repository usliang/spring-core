package com.liang.springcore.recursive;

import java.util.*;

public class RecursiveSubsetGenerator {

    public static void main(String[] args) {
        Set<Character> inputSet = new LinkedHashSet<>(Arrays.asList('a', 'b', 'c', 'd'));
        Set<Set<Character>> result = new LinkedHashSet<>();

        generateSubsets(new ArrayList<>(inputSet), 0, new LinkedHashSet<>(), result);

        printSubsets(result);
    }

    private static void generateSubsets(List<Character> set, int index,
                                        Set<Character> current,
                                        Set<Set<Character>> result) {
        if (index == set.size()) {
            result.add(new LinkedHashSet<>(current)); // Make a copy before adding
            return;
        }

        // Exclude current character
        generateSubsets(set, index + 1, current, result);

        // Include current character
        current.add(set.get(index));
        generateSubsets(set, index + 1, current, result);
        current.remove(set.get(index)); // Backtrack
    }

    private static void printSubsets(Set<Set<Character>> subsets) {
        List<String> formatted = new ArrayList<>();
        for (Set<Character> subset : subsets) {
            StringBuilder sb = new StringBuilder("{");
            for (char ch : subset) {
                sb.append(ch);
            }
            sb.append("}");
            formatted.add(sb.toString());
        }

        Collections.sort(formatted);
        for (String s : formatted) {
            System.out.println(s);
        }
    }
}
