package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedListTest {
    @Test
    void mergeTwoListsTest1() {
        ListNode l1 = null;
        ListNode l2 = null;
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        assertNull(result);
    }

    @Test
    void mergeTwoListsTest2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = null;
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 1);
    }

    @Test
    void mergeTwoListsTest3() {
        ListNode l2 = new ListNode(2);
        ListNode l1 = null;
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 2);
    }

    @Test
    void mergeTwoListsTest4() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = null;
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 1,2);
    }

    @Test
    void mergeTwoListsTest5() {
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        ListNode l1 = null;
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 2,3);
    }

    @Test
    void mergeTwoListsTest6() {
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(3);
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 2,3);
    }

    @Test
    void mergeTwoListsTest7() {
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode l1 = new ListNode(3);
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 2,3,4);
    }

    @Test
    void mergeTwoListsTest8() {
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 2,3,4,5);
    }

    @Test
    void mergeTwoListsTest9() {
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(8);
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
        MergeSortedList mergeSortedList = new MergeSortedList();
        ListNode result = mergeSortedList.mergeTwoLists(l1, l2);
        verifyList(result, 2,3,4,5,7,8);
    }

    public void verifyList(ListNode l1, int... values) {
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], l1.val);
            l1 = l1.next;
        }
    }
}