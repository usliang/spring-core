package com.liang.springcore.licode;

import java.util.*;

public class ArrayPartitioner {
    public boolean checkEqualPartitions(int[] nums, long target) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        for (int i : nums) {
            if (target % i != 0) {
                return false;
            }
            numList.add(i);
        }
        return partition(numList, target, p1);
    }
    public boolean partition(List<Integer> nums, long target,  List<Integer> p) {
        if (nums.isEmpty()) {
            return false;
        }
        if (verifyPartition(nums, target) && verifyPartition(p, target)) {
            return true;
        }
        boolean found = false;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            List<Integer> remain = new ArrayList<>();
            for (int j =0; j < i; j++) {
                remain.add(nums.get(j));
            }
            for (int j = i + 1; j < nums.size(); j++) {
                remain.add(nums.get(j));
            }
            List<Integer> np = new ArrayList<>(p);
            np.add(num);
            if (partition(remain, target, np)) {
                found = true;
                break;
            }
        }
        return found;
    }
    public boolean verifyPartition(List<Integer> nums, long target) {

        long product = 1;
        System.out.println();
        for(Integer num : nums) {
            System.out.print(num+",");
            product *= num;
            if (product > target) {
                return false;
            }
        }
        return (product == target);
    }
}
