package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilTest {
    ListUtil listUtil = new ListUtil();
    @Test
    void removeElements1() {
        ListNode head = null;
        ListNode newHead = listUtil.removeElements(head, 1);
        assertEquals(head, newHead);
    }
    @Test
    void removeElements2() {
        ListNode head = new ListNode(1);
        ListNode newHead = listUtil.removeElements(head, 1);
        assertNull(newHead);
    }
    @Test
    void removeElements3() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        head.next = node2;
        ListNode newHead = listUtil.removeElements(head, 1);
        assertNull(newHead);
    }

    @Test
    void removeElements4() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode newHead = listUtil.removeElements(head, 1);
        assertEquals(newHead, node2);
    }

    @Test
    void removeElements5() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        ListNode newHead = listUtil.removeElements(head, 2);
        assertEquals(newHead, head);
        assertEquals(newHead.next, node3);
    }

    @Test
    void removeElements6() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        ListNode newHead = listUtil.removeElements(head, 3);
        assertEquals(newHead, head);
        assertEquals(newHead.next, node2);
    }

    @Test
    void removeElements7() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newHead = listUtil.removeElements(head, 2);
        assertEquals(newHead, head);
        assertEquals(newHead.next, node4);
        assertNull(node4.next);
    }

    @Test
    void removeElements8() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newHead = listUtil.removeElements(head, 2);
        assertEquals(newHead, head);
        assertEquals(newHead.next, node4);
        assertNull(node4.next);
    }
}