package com.liang.springcore.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] result = twoSum(nums, 11);
        System.out.println(Arrays.toString(result));
    }
    public static int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> hashMap = new HashMap(nums.length);
       for (int i = 0; i < nums.length; i++) {
           hashMap.put(nums[i], i);
       }
       int[] result = new int[2];
       for (int i = 0; i < nums.length; i++) {
           if (hashMap.containsKey(target - nums[i])) {
               result[0] = i;
               result[1] = hashMap.get(target - nums[i]);
               break;
           }
       }
       return result;
    }
}
