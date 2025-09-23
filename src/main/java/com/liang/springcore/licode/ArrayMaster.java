package com.liang.springcore.licode;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayMaster {
    public int removeDuplicates(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //set current to first item
        int currentIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[currentIndex]) {
                arr[++currentIndex] = arr[i];
            }
        }
        return currentIndex + 1;
    }

    public int maxProfit(final int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int buyPrice = prices[0];
        int currentIndex = 0;
        while (currentIndex < prices.length-1) {
            if (prices[currentIndex] > prices[currentIndex + 1]) {
                maxProfit += prices[currentIndex]  - buyPrice;
                buyPrice = prices[currentIndex + 1];
            }
            currentIndex++;
        }
        //add the last range
        if (buyPrice < prices[currentIndex]) {
            maxProfit += prices[currentIndex] - buyPrice;
        }

        return maxProfit;
    }

    public void rotate1(int[] nums, int k) {
        int offset = nums.length - (k % nums.length);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = offset; i < offset + nums.length; i++) {
            int index = i  % nums.length;
            queue.offer(nums[index]);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            rotateRight(nums);
        }
    }

    public void rotateRight(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }
}
