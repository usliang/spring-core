package com.liang.springcore.licode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/****
 * Created by liliang on 8/8/25.
 ****/
class ReOrderListTest {
    ReOrderList reOrderList = new ReOrderList();
    @Test
    void reOrderList11() {
        ListNode head = new ListNode(1);
        reOrderList.reorderList1(head);
        Assertions.assertNotNull(head);
        Assertions.assertEquals(1, head.val);
    }

    @Test
    void reOrderList12() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        reOrderList.reorderList1(head);
        Assertions.assertNotNull(head);
        Assertions.assertEquals(head.next, node2);
    }

    @Test
    void reOrderList13() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        reOrderList.reorderList1(head);
        Assertions.assertNotNull(head);
        Assertions.assertEquals(head.next, node3);
        Assertions.assertEquals(node3.next, node2);
    }

    @Test
    void reOrderList14() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        reOrderList.reorderList1(head);
        Assertions.assertNotNull(head);
        Assertions.assertEquals(head.next, node4);
        Assertions.assertEquals(node4.next, node2);
        Assertions.assertEquals(node2.next, node3);
    }

    @Test
    void reOrderList15() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reOrderList.reorderList1(head);
        Assertions.assertNotNull(head);
        Assertions.assertEquals(head.next, node5);
        Assertions.assertEquals(node5.next, node2);
        Assertions.assertEquals(node2.next, node4);
        Assertions.assertEquals(node4.next, node3);
    }
    @Test
    void addNode() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode tail = head;
        tail = reOrderList.addNode(tail, node2);
        Assertions.assertNotNull(tail);
        Assertions.assertNull(tail.next);
        Assertions.assertEquals(head.next, node2);
        ListNode node3 = new ListNode(3);
        tail = reOrderList.addNode(tail, node3);
        Assertions.assertNotNull(tail);
        Assertions.assertNull(tail.next);
        Assertions.assertEquals(node2.next, node3);
    }

    @Test
    void reverseList() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newHead = reOrderList.reverse(head);
        Assertions.assertNotNull(newHead);
        Assertions.assertEquals(newHead.next, node3);
        Assertions.assertEquals(node3.next, node2);
        Assertions.assertEquals(node2.next, head);
    }

    @Test
    void mergeList() {
        ListNode head1 = buildList(1,5);
        ListNode head2 = buildList(6,7);
        System.out.println(head1.toString());
        System.out.println(head2.toString());
        reOrderList.mergeList(head1, head2);
        System.out.println(head1);
    }

    @Test
    void reOrderList2() {
        ListNode head = buildList(1, 4);
        System.out.println(head.toString());
        reOrderList.reorderList(head);
        System.out.println(head);
    }

    ListNode buildList(int begin, int end) {
        ListNode head = new ListNode(begin);
        ListNode tail = head;
        for (int i = begin+1; i<= end; i++) {
            ListNode node = new ListNode(i);
            tail = reOrderList.addNode(tail, node);
        }
        return  head;
    }
}