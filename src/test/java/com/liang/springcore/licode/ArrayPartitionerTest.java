package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayPartitionerTest {

    @Test
    void checkEqualPartitions0() {
        int[] nums = new int[]{6,2,3};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertTrue(arrayPartitioner.checkEqualPartitions(nums, 6));
    }

    @Test
    void checkEqualPartitions0_1() {
        int[] nums = new int[]{6,2,3};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertFalse(arrayPartitioner.checkEqualPartitions(nums, 24));
    }

    @Test
    void checkEqualPartitions1() {
        int[] nums = new int[]{3,1,6,8,4};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertTrue(arrayPartitioner.checkEqualPartitions(nums, 24));
    }

    @Test
    void checkEqualPartitions2() {
        int[] nums = new int[]{2,5,3,7};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertFalse(arrayPartitioner.checkEqualPartitions(nums, 15));
    }

    @Test
    void checkEqualPartitions3() {
        int[] nums = new int[]{1,5,3,15};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertTrue(arrayPartitioner.checkEqualPartitions(nums, 15));
    }

    @Test
    void checkEqualPartitions4() {
        int[] nums = new int[]{2,3, 6, 5};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertFalse(arrayPartitioner.checkEqualPartitions(nums, 6));
    }

    @Test
    void checkEqualPartitions5() {
        int[] nums = new int[]{2,3, 6, 1};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertTrue(arrayPartitioner.checkEqualPartitions(nums, 6));
    }
    //11,22,5,10
    @Test
    void checkEqualPartitions6() {
        int[] nums = new int[]{11,22,5,10};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertTrue(arrayPartitioner.checkEqualPartitions(nums, 110));
    }

    @Test
    void checkEqualPartitions7() {
        int[] nums = new int[]{21,7,12,6,24,9};
        ArrayPartitioner arrayPartitioner = new ArrayPartitioner();
        assertTrue(arrayPartitioner.checkEqualPartitions(nums, 1512));
    }
}