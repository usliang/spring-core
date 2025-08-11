package com.liang.springcore.licode;

public class ListUtil {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cursor = head;
        while (cursor != null) {
            if (cursor.val == val) {
                if (prev == null) {
                    head = cursor.next;
                } else  {
                    prev.next = cursor.next;
                }
                cursor = cursor.next;
            } else {
                prev = cursor;
                cursor = cursor.next;
            }
        }
        return head;
    }
}
