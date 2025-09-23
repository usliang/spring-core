package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

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

}