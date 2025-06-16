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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode newHead = list.swapPairs(head);
        assertEquals(2, newHead.val);
        assertEquals(1, newHead.next.val);

        //test 3 nodes
        newHead.next.next = new ListNode(3);
        head = list.swapPairs(newHead);
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(3, head.next.next.val);

        //test 4 nodes
        head.next.next.next = new ListNode(4);
        head = list.swapPairs(head);
        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(3, head.next.next.next.val);

        //test 5 nodes
        head.next.next.next.next = new ListNode(5);
        head = list.swapPairs(head);
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(4, head.next.next.next.val);
        assertEquals(5, head.next.next.next.next.val);

        //test 6 nodes
        head.next.next.next.next.next = new ListNode(6);
        head = list.swapPairs(head);
        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(3, head.next.next.next.val);
        assertEquals(6, head.next.next.next.next.val);
        assertEquals(5, head.next.next.next.next.next.val);
    }
}