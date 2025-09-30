package com.liang.springcore.licode;

import java.util.*;

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

    public void rotate2(int[] nums, int k) {
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

    class NextItem {
        int index;
        int item;

        public NextItem(int index, int item) {
            this.index = index;
            this.item = item;
        }
    }
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        NextItem nextItem = new NextItem(0, nums[0]);
        boolean[] rotated = new boolean[nums.length];
        do {
            nextItem = move(nums, k, nextItem, rotated);
        } while (nextItem.index != -1);
    }
    private NextItem move(int[] nums, int k, NextItem nextItem, boolean[] rotated) {
        int toIndex = (nextItem.index + k) % nums.length;
        NextItem ret = new NextItem(toIndex, nums[toIndex]);
        nums[toIndex] = nextItem.item;
        rotated[nextItem.index] = true;
        if (rotated[ret.index]) {
            ret.index = nextToMove(rotated);
            if (ret.index != -1) {
                ret.item = nums[ret.index];
            }
        }
        return ret;
    }
    private int nextToMove(boolean[] rotated) {
        for (int i = 0; i < rotated.length; i++) {
            if (!rotated[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }  else {
                i++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller one to save space
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        // Convert list to array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                //continue to check higher bit
            } else {
               digits[i]++;
               return digits;
            }
        }
        //if here, this mean all digits in the array is 9
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < digits.length + 1; i++) {
            res[i] = 0;
        }
        return res;
    }

    public void moveZeroes1(int[] nums) {
        int end = nums.length - 1;
        int begin = 0;
        while (begin < end) {
            if (nums[begin] == 0) {
                for (int j = begin; j <= end -1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[end] = 0;
                end--;
            } else {
                begin++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        List<Integer> zeroPositions = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPositions.add(i);
            }
        }
        if (zeroPositions.isEmpty()) { // no zero
            return;
        }
        for (int i = 0; i < zeroPositions.size() - 1; i++) {
            shiftZeroes(nums, zeroPositions.get(i), zeroPositions.get(i + 1));
        }
        int begin = zeroPositions.getLast();
        if (begin < zeroPositions.size() - 1) {
            shiftZeroes(nums, begin, nums.length);
        }
    }

    public void shiftZeroes(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            nums[i] = nums[i +1];
        }
        nums[end] = 0;
    }

}
