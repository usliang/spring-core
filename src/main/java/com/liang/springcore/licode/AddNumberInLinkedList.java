package com.liang.springcore.licode;

public class AddNumberInLinkedList {
    public void newNode(ListNode head) {
        head.next = new ListNode(1, null);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        AddNumberInLinkedList adder = new AddNumberInLinkedList();
        adder.newNode(head);

        ListNode linKNode1 = new ListNode(9, null);
        ListNode result = adder.addTwoNumbers(linKNode1, linKNode1, 0);
        System.out.println(result);

        linKNode1 = new ListNode(9, null);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(9, linKNode1);
        linKNode1 = new ListNode(1, linKNode1);

        ListNode linKNode2 = new ListNode(9, null);
        result = adder.addTwoNumbers(linKNode1, linKNode2, 0);
        System.out.println(result);

        ListNode linKNode3 = adder.buildListNode(9, 4, 2);
        ListNode linKNode4 = adder.buildListNode(9, 4, 6, 5);
        result = adder.addTwoNumbers(linKNode3, linKNode4, 0);
        System.out.println(result);

    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        int carry = addNode(l1, l2, 0, head);
        ListNode cursor = head;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode();
            carry = addNode(l1, l2, carry, newNode);
            cursor.next = newNode;
            cursor = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode newNode = new ListNode();
            carry = addNode(l1, null, carry, newNode);
            cursor.next = newNode;
            cursor = newNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode newNode = new ListNode();
            carry = addNode(l2, null, carry, newNode);
            cursor.next = newNode;
            cursor = newNode;
            l2 = l2.next;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            cursor.next = newNode;
        }

        return head;
    }


    public ListNode buildListNode(int... number) {
        if (number.length == 0) {
            return null;
        }
        ListNode head = new ListNode(number[0], null);
        for (int i = 1; i < number.length; i++) {
            head = new ListNode(number[i], head);
        }
        return head;
    }

    public int addNode(ListNode node1, ListNode node2, int carry, ListNode cursor) {
        int num1 = 0;
        if (node1 != null) {
            num1 = node1.val;
        }
        int num2 = 0;
        if (node2 != null) {
            num2 = node2.val;
        };
        int sum = num1 + num2 + carry;
        if (sum > 9) {
            sum = sum - 10;
            carry = 1;
        }else {
            carry = 0;
        }
        cursor.val = sum;
        return carry;
    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2, int carry) {
        ListNode head = new ListNode();
        ListNode next = null;

        int num1 = node1==null?0:node1.val;
        int num2 = node2==null?0:node2.val;

        int sum = num1 + num2 + carry;
        if (sum > 9) {
            sum = sum - 10;
            carry = 1;
        } else {
            carry = 0;
        }
        head.val = sum;
        if (node1 != null) {
            node1 = node1.next;
        }
        if (node2 != null) {
            node2 = node2.next;
        }
        if (node1 != null || node2 != null || carry != 0) {
            next = addTwoNumbers(node1, node2, carry);
        }
        head.next = next;
        return head;
    }

    /*
    Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying
    the values in the list's nodes (i.e., only nodes themselves may be changed.)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            ListNode rest = newHead.next;
            newHead.next = head;
            head.next = swapPairs(rest);
            return newHead;
        }
    }
}
