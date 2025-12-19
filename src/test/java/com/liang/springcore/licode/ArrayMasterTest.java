package com.liang.springcore.licode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMasterTest {
    ArrayMaster arrayMaster = new ArrayMaster();
    @Test
    void maxProfit1() {
        int[] prices = new int[] { 1 };
        int result = arrayMaster.maxProfit(prices);
        assertEquals(0, result);
    }

    @Test
    void maxProfit2() {
        int[] prices = new int[] { 1, 2 };
        int result = arrayMaster.maxProfit(prices);
        assertEquals(1, result);
    }

    @Test
    void maxProfit3() {
        int[] prices = new int[] { 1, 3 };
        int result = arrayMaster.maxProfit(prices);
        assertEquals(2, result);
    }

    @Test
    void maxProfit4() {
        int[] prices = new int[] { 1, 2, 3 };
        int result = arrayMaster.maxProfit(prices);
        assertEquals(2, result);
    }

    @Test
    void maxProfit5() {
        int[] prices = new int[] { 1, 2, 3, 4 };
        int result = arrayMaster.maxProfit(prices);
        assertEquals(3, result);
    }

    @Test
    void maxProfit6() {
        int[] prices = new int[] { 2, 1};
        int result = arrayMaster.maxProfit(prices);
        assertEquals(0, result);
    }

    @Test
    void maxProfit7() {
        int[] prices = new int[] {3,  2, 1};
        int result = arrayMaster.maxProfit(prices);
        assertEquals(0, result);
    }

    @Test
    void maxProfit8() {
        int[] prices = new int[] {7,1,5,3,6,4};
        int result = arrayMaster.maxProfit(prices);
        assertEquals(7, result);
    }

    @Test
    void maxProfit9() {
        int[] prices = new int[] {7,1,5,3,6,4};
        int result = arrayMaster.maxProfit(prices);
        assertEquals(7, result);
    }

    @Test
    void  rotate1() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.rotate(nums, nums.length);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, nums);
    }

    @Test
    void  rotate2() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.rotate(nums, 1);
        assertArrayEquals(new int[] {9, 1, 2, 3, 4, 5, 6, 7, 8}, nums);
    }

    @Test
    void  rotate3() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.rotate(nums, 2);
        assertArrayEquals(new int[] {8, 9, 1, 2, 3, 4, 5, 6, 7}, nums);
    }

    @Test
    void  rotate4() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.rotate(nums, 3);
        assertArrayEquals(new int[] {7, 8, 9, 1, 2, 3, 4, 5, 6}, nums);
    }

    @Test
    void  rotate5() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.rotate(nums, 3 + nums.length * 2);
        assertArrayEquals(new int[] {7, 8, 9, 1, 2, 3, 4, 5, 6}, nums);
    }

    @Test
    void  intersect1() {
        int[] nums1 = new int[] { 1,2,2,1 };
        int[] nums2 = new int[] { 2,2 };
        int[] result = arrayMaster.intersect(nums1, nums2);
        assertArrayEquals(new int[] { 2, 2 }, result);
    }

    @Test
    void  intersect2() {
        int[] nums1 = new int[] { 4,9,5 };
        int[] nums2 = new int[] { 9,4,9,8,4 };
        int[] result = arrayMaster.intersect(nums1, nums2);
        assertArrayEquals(new int[] { 4, 9 }, result);
    }

    @Test
    void plusOne1() {
        int[] nums = new int[] { 1 };
        int[] res = arrayMaster.plusOne(nums);
        assertArrayEquals(new int[] { 2 }, res);
    }

    @Test
    void plusOne2() {
        int[] nums = new int[] { 9 };
        int[] res = arrayMaster.plusOne(nums);
        assertArrayEquals(new int[] { 1, 0 }, res);
    }

    @Test
    void plusOne3() {
        int[] nums = new int[] {1, 9 };
        int[] res = arrayMaster.plusOne(nums);
        assertArrayEquals(new int[] { 2, 0 }, res);
    }

    @Test
    void plusOne4() {
        int[] nums = new int[] {1, 3 };
        int[] res = arrayMaster.plusOne(nums);
        assertArrayEquals(new int[] { 1, 4 }, res);
    }

    @Test
    void plusOne5() {
        int[] nums = new int[] {1, 4,  9 };
        int[] res = arrayMaster.plusOne(nums);
        assertArrayEquals(new int[] { 1, 5, 0 }, res);
    }

    @Test
    void plusOne6() {
        int[] nums = new int[] {9, 9,  9 };
        int[] res = arrayMaster.plusOne(nums);
        assertArrayEquals(new int[] { 1, 0, 0, 0 }, res);
    }

    @Test
    void moveZeroes1() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, nums);
    }

    @Test
    void moveZeroes2() {
        int[] nums = new int[] { 0, 2, 3, 4, 5, 6, 7, 8, 9 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 0 }, nums);
    }

    @Test
    void moveZeroes3() {
        int[] nums = new int[] { 0, 2, 3, 4, 5, 6, 7, 0, 9 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 7, 9, 0, 0 }, nums);
    }

    @Test
    void moveZeroes4() {
        int[] nums = new int[] { 0, 0, 1 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 0, 0 }, nums);
    }

    @Test
    void moveZeroes5() {
        int[] nums = new int[] { 1 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 1 }, nums);
    }

    @Test
    void moveZeroes6() {
        int[] nums = new int[] { 0, 2, 3, 4, 5, 6, 7, 0, 0 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 7, 0, 0, 0 }, nums);
    }

    @Test
    void moveZeroes7() {
        int[] nums = new int[] { 0,1,0 };
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 0, 0 }, nums);
    }

    @Test
    void moveZeroes8() {
        int[] nums = new int[] { 0,0,0,0,-25503,20486,-94356,0,-20253,80325,0,62558,-41932,-63525,0,0,0,0,0,-16051,
                -896,0,-7783,0,0,-26335,19267,-33350,0,73475,0,82325,68084,-60140,0,78072,98839,0,0,-83121,0,-32293,
                16421,48223,0,-8846,73852,-48827,12788,-68476,0,0 };
        int[] expected = new int[] {-25503,20486,-94356,-20253,80325,62558,-41932,-63525,-16051,-896,-7783,-26335,
                19267,-33350,73475,82325,68084,-60140,78072,98839,-83121,-32293,16421,48223,
                -8846,73852,-48827,12788,-68476,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void twoSum1() {
        int[] nums = new int[] { 2,7,11,15};
        int[] result = arrayMaster.twoSum(nums, 9);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }

    @Test
    void twoSum2() {
        int[] nums = new int[] { 3,2,4};
        int[] result = arrayMaster.twoSum(nums, 6);
        assertArrayEquals(new int[] { 1, 2 }, result);
    }
    @Test
    void twoSum3() {
        int[] nums = new int[] { 3};
        int[] result = arrayMaster.twoSum(nums, 3);
        assertArrayEquals(null, result);
    }

    @Test
    void twoSum4() {
        int[] nums = new int[] {3, 3};
        int[] result = arrayMaster.twoSum(nums, 6);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }

    @Test
    void twoSum5() {
        int[] nums = new int[] {3, -3};
        int[] result = arrayMaster.twoSum(nums, 0);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }

    @Test
    void findZeroBlock0() {
        int[] nums = new int[] {};
        List<int[]> list = arrayMaster.findZeroBlock(nums);
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void findZeroBlock1() {
        int[] nums = new int[] {0, 0, 0};
        List<int[]> list = arrayMaster.findZeroBlock(nums);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void findZeroBlock2() {
        int[] nums = new int[] {0, 0, 1, 0, 0};
        List<int[]> list = arrayMaster.findZeroBlock(nums);
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void findZeroBlock3() {
        int[] nums = new int[] {0, 0, 1, 0, 0, 0, 1, 2, 0, 4, 0, 0, 0, 5};
        List<int[]> list = arrayMaster.findZeroBlock(nums);
        Assertions.assertEquals(4, list.size());
        arrayMaster.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 1, 2, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, nums);
    }
    @Test
    void isValidSudoku1() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        //System.out.println(board[0][1]);
        //System.out.println(board[1][0]);
        Assertions.assertTrue(arrayMaster.isValidSudoku(board));
    }

    @Test
    void isValidSudoku2() {
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        //System.out.println(board[0][1]);
        //System.out.println(board[1][0]);
        Assertions.assertFalse(arrayMaster.isValidSudoku(board));
    }

    @Test
    void rotateImage1 () {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] output = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        arrayMaster.rotate(input);
        Assertions.assertArrayEquals(input, output);
    }

    @Test
    void rotateImage2 () {
        int[][] input = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        int[][] output = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };

        arrayMaster.rotate(input);
        Assertions.assertArrayEquals(input, output);
    }
}