package com.liang.springcore.licode;

public class MeanFinder {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {3, 3, 3};
        double mean = findMedianSortedArrays(nums1, nums2);
        System.out.println(mean);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = 0;
        int cursor1 = 0;
        int cursor2 = 0;
        int length = nums1.length + nums2.length;
        double mean = 0.0 ;
        int stop;
        if (length % 2 == 1) {
            stop = length / 2;
        } else {
            stop = (length / 2) - 1;
        }
        while (count <= stop) {
            if ((cursor1 < nums1.length) && (cursor2 < nums2.length) && (nums1[cursor1] < nums2[cursor2])) {
                mean = nums1[cursor1];
                cursor1++;
            } else if (cursor2 < nums2.length) {
                mean = nums2[cursor2];
                cursor2++;
            } else if (cursor1 < nums1.length) {
                mean = nums1[cursor1];
                cursor1++;
            }
            count++;
        }
        //for even length, need two number
        if (length % 2 == 0) {
            if (cursor1 < nums1.length && cursor2 < nums2.length) {
                if (nums1[cursor1] < nums2[cursor2]) {
                    mean = (mean + nums1[cursor1]) / 2;
                } else {
                    mean = (mean + nums2[cursor2]) / 2;
                }
            } else if (cursor1 < nums1.length) {
                mean = (mean + nums1[cursor1]) / 2;
            } else {
                mean = (mean + nums2[cursor2]) / 2;
            }
        }
        return mean;
    }
}
