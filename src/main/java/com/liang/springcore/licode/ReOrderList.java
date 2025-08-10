package com.liang.springcore.licode;

import java.util.Stack;

/****
 * Created by liliang on 8/8/25.
 ****/
public class ReOrderList {
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode last = head.next;
        ListNode nextToLast = head;
        while (last.next != null) {
            nextToLast = last;
            last = last.next;
        }
        nextToLast.next = null;
        ListNode newHead = head.next;
        last.next = newHead;
        head.next = last;
        reorderList1(newHead);
    }

    public void reorderList(ListNode head) {
        //find the middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);
        mergeList(head, newHead);
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public void mergeList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return;
        }
        ListNode cur = head1;
        while (head2 != null) {
            ListNode next1 = cur.next;
            cur.next = head2;
            ListNode next2 = head2.next;
            head2.next = next1;
            cur = next1;
            head2 = next2;
        }
    }
    public ListNode addNode(ListNode tail, ListNode node) {
        tail.next = node;
        node.next = null;
        return node;
    }
}
