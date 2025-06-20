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
        return partition(nums, numList, target, p1, 0);
    }

    public boolean partition(int[] nums, List<Integer> numsList, long target,  List<Integer> p, int index) {
        if (index == nums.length) {
            return false;
        }
        if (!p.isEmpty() && verifyPartition(numsList, target) && verifyPartition(p, target)) {
            return true;
        }
        p.add(nums[index]);
        numsList.remove(Integer.valueOf(nums[index]));
        if (partition(nums, numsList, target, p, index + 1)) {
            return true;
        }

        numsList.add(p.get(p.size() - 1));
        p.remove(p.size() - 1);
        return partition(nums, numsList, target, p, index + 1);
    }

    public boolean partition2(List<Integer> nums, long target,  List<Integer> p) {
        if (nums.isEmpty()) {
            return false;
        }
        if (!p.isEmpty() && verifyPartition(nums, target) && verifyPartition(p, target)) {
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
            if (partition2(remain, target, np)) {
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
