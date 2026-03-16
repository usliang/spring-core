package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListMasterTest {
    ListMaster listMaster = new ListMaster();
    @Test
    void deleteNode() {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        root.next=node2;
        node2.next=node3;
        listMaster.deleteNode(node2);
        System.out.println(root);
    }

    @Test
    void deleteNode2() {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        root.next=node2;
        node2.next=node3;
        listMaster.deleteNode(root);
        System.out.println(root);
    }

    @Test
    void removeNthFromEnd() {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        root.next=node2;
        node2.next=node3;
        ListNode head = listMaster.removeNthFromEnd(root, 3);
        System.out.println(head);
    }

    @Test
    void removeNthFromEnd2() {
        ListNode root = new ListNode(1);
        ListNode head = listMaster.removeNthFromEnd(root, 1);
        System.out.println(head);
    }

    @Test
    void reverseList() {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        root.next=node2;
        node2.next=node3;
        ListNode head = listMaster.reverseList(root);
        System.out.println(head);
    }

    @Test
    void reverseList2() {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        root.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode head = listMaster.reverseList(root);
        System.out.println(head);
    }
    @Test
    void isPalindrome() {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        //ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        root.next=node2;
        node2.next=node4;
        //node3.next=node4;
        assertTrue(listMaster.isPalindrome(root));
    }
}