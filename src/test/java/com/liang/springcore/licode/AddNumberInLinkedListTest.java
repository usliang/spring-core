package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/****
 * Created by liliang on 5/28/25.
 ****/
class AddNumberInLinkedListTest {

    @Test
    void swapPairs() {
        AddNumberInLinkedList list = new AddNumberInLinkedList();
        AddNumberInLinkedList.ListNode head = new AddNumberInLinkedList.ListNode(1);
        AddNumberInLinkedList.ListNode rest = new AddNumberInLinkedList.ListNode(2);
        head.next = rest;

        AddNumberInLinkedList.ListNode newHead = list.swapPairs(head);
        assertEquals(2, newHead.val);
        assertEquals(1, newHead.next.val);
    }
}