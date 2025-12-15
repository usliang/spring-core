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

    public void moveZeroes(int[] nums) {
        int cursor = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != 0) {
                nums[cursor] = nums[i];
                cursor++;
            }
        }
        for (int i= cursor; i< nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int end = nums.length - 1;
        int begin = 0;
        while (begin < end) {
            if (nums[begin] == 0) {
                //find the next non-zero
                int zeroCount = 1;
                while ((begin + zeroCount < end) && nums[begin + zeroCount] == 0) {
                    zeroCount++;
                    if ((begin + zeroCount) == end + 1) {
                        return; //all the zero are on the end, we are then
                    }
                }
                for (int j = begin; j <= end - zeroCount; j++) {
                    nums[j] = nums[j + zeroCount];
                }
                //move begin by zero count and stop on
                for (int i = 0; i< zeroCount; i++) {
                    begin++;
                    if (nums[begin] == 0) {
                        break;
                    }
                }
                for (int i = 0; i< zeroCount; i++) {
                    nums[end - zeroCount + i + 1] = 0;
                }
                end -= zeroCount;
            } else {
                begin++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        List<int[]> list = findZeroBlock(nums);
        if (list.isEmpty()) {
            return;
        }
        int nextTo = list.getFirst()[0];
        int totalZero = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int[] current = list.get(i);
            int[] next = list.get(i+1);
            int count = next[0] - current[1] -1;
            int from = current[1] + 1;
            shiftZeroes(nums, nextTo, from, count);
            nextTo = nextTo + count;
            totalZero += (current[1] - current[0] + 1);
        }
        //handle the last group
        if (list.getLast()[1] != nums.length - 1) {
            int from = list.getLast()[1] + 1;
            int count = nums.length - list.getLast()[1] - 1;
            shiftZeroes(nums, nextTo, from, count);
        }
        totalZero += (list.getLast()[1] - list.getLast()[0] + 1);
        //set zero on the end
        for (int i = nums.length - totalZero; i<nums.length; i++) {
            nums[i] = 0;
        }
    }

    public List<int[]> findZeroBlock(int[] nums) {
        //find the consecutive 0 block-- n[0] = the index of the beginning 0; n[1] = the index = ending 0
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        list.add(new int[]{i, j-1});
                        i = j;
                        break;
                    } else {
                        j++;
                    }
                }
                //check if from i to the end are all zero
                if (j == nums.length) {
                    list.add(new int[]{i, j-1});
                    i = j;
                }
            } else {
                i++;
            }

        }
        return list;
    }

    public void shiftZeroes(int[] nums, int to, int from, int count) {
        for (int i = 0; i <count; i++) {
            nums[to + i] = nums[from +i];
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public boolean isValidSudoku1(char[][] board) {
        HashSet<Character> charsHorizontal = new HashSet<>();
        HashSet<Character> charsVertical = new HashSet<>();
        HashSet<Character> charsSubBoard = new HashSet<>();

        final int length = 9;
        final int subLen = 3;
        for (int i = 0; i <  length; i++) {
            for (int j = 0; j<length; j++ ) {
                char chHorizontal = board[i][j];
                if (checkSet(chHorizontal, charsHorizontal)) {
                    return false; //duplicate digit
                }
                char chVertical = board[j][i];
                if (checkSet(chVertical, charsVertical)) {
                    return  false;
                }
            }
            charsHorizontal.clear();
            charsVertical.clear();
        }
        for (int i =0 ; i <length; i=i+subLen ) {
            for (int j =0 ; j <length; j=j+subLen ) {
                System.out.println("row: " + i + " col: " + j);
                for (int k =0; k< subLen; k++) {
                    for (int l=0; l<subLen; l++ ){
                        if (checkSet(board[i+k][j+l], charsSubBoard )) {
                            return false;
                        }
                    }
                }
                charsSubBoard.clear();
            }
        }
        return true;

    }
    public boolean checkSet(char ch, Set<Character> set) {
        boolean ret = false;
        if ( ch != '.') {
            if (set.contains(ch)) {
                ret = true;
            } else {
                set.add(ch);
            }
        }
        return ret;
    }

    public boolean isValidSudoku(char[][] board) {
        final int n = 9;
        final int box = 3;

        // rows + cols
        for (int i = 0; i < n; i++) {
            int rowMask = 0;
            int colMask = 0;

            for (int j = 0; j < n; j++) {
                // row
                char r = board[i][j];
                if (r != '.') {
                    int bit = 1 << (r - '1');          // '1' -> bit0, '9' -> bit8
                    if ((rowMask & bit) != 0) return false;
                    rowMask |= bit;
                }

                // col
                char c = board[j][i];
                if (c != '.') {
                    int bit = 1 << (c - '1');
                    if ((colMask & bit) != 0) return false;
                    colMask |= bit;
                }
            }
        }

        // 3x3 sub-boards
        for (int r0 = 0; r0 < n; r0 += box) {
            for (int c0 = 0; c0 < n; c0 += box) {
                int boxMask = 0;

                for (int dr = 0; dr < box; dr++) {
                    for (int dc = 0; dc < box; dc++) {
                        char ch = board[r0 + dr][c0 + dc];
                        if (ch == '.') continue;

                        int bit = 1 << (ch - '1');
                        if ((boxMask & bit) != 0) return false;
                        boxMask |= bit;
                    }
                }
            }
        }

        return true;
    }

}
