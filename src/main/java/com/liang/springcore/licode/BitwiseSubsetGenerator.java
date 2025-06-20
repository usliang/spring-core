package com.liang.springcore.licode;

import java.util.*;

public class BitwiseSubsetGenerator {

    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        int n = set.length;

        int totalSubsets = 1 << n;  // 2^n subsets

        System.out.println("All subsets:");

        for (int mask = 0; mask < totalSubsets; mask++) {
            StringBuilder subset = new StringBuilder();

            for (int i = 0; i < n; i++) {
                // Check if the ith bit is set in mask
                if ((mask & (1 << i)) != 0) {
                    subset.append(set[i]);
                }
            }

            System.out.println(subset.toString());
        }
    }
}
