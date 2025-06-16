package com.liang.springcore.licode;

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {
        val = -1;
        next = null;
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
