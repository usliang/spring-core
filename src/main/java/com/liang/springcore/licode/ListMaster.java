package com.liang.springcore.licode;

import java.util.*;

public class ListMaster {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode nextNode = node.next;
        while (nextNode.next != null) {
            current.val= nextNode.val;
            current = nextNode;
            nextNode=nextNode.next;
        }
        //when here nextNode is the tail node
        current.val= nextNode.val;
        current.next=null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode cursor = head;
        while (cursor!=null) {
            count++;
            cursor=cursor.next;
        }
        if (count==1) {
            return null;
        }
        //here count>=2;
        ListNode prev = head;
        cursor = head;
        for (int i=0; i< count-n; i++) {
            prev=cursor;
            cursor=cursor.next;
        }
        //when here, cursor is the node to delete
        if (cursor==head) { //to remove head
            ListNode newHead = cursor.next;
            cursor.next=null; //cut the head
            return newHead;
        } else {
            prev.next = cursor.next; //delete cursor from the list
            return head;
        }
    }

    public ListNode reverseList1(ListNode head) {
        if (head==null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cursor = head;
        while (cursor != null) {
            stack.push(cursor);
            cursor=cursor.next;
        }
        ListNode newHead = stack.pop();
        ListNode previous = newHead;
        while (!stack.isEmpty()) {
            cursor=stack.pop();
            previous.next=cursor;
            previous=cursor;
        }
        previous.next=null;
        return newHead;
    }
    public ListNode reverseList3(ListNode head) {
        if (head==null || head.next==null){
            return head;
        } else {
            //find the tail
            ListNode tail = head; //the tail will be the new head
            ListNode prev = null;
            //find the tail node
            while (tail.next != null) {
                prev=tail;
                tail = tail.next;
            }
            prev.next=null; // cut the tail node from the list; the tail will be the head
            head = reverseList3(head);
            tail.next=head;
            return tail;
        }

    }

    public ListNode reverseList(ListNode head) {

        ListNode cursor = head;
        ListNode prev = null;
        ListNode tmp;
        while (cursor != null) {
            tmp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = tmp;
        }
        return prev; //new head
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList4(head.next);

        head.next.next = head; // make next point back to head
        head.next = null;      // cut old forward link

        return newHead;
    }

    public boolean isPalindrome1(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cursor = head;
        while (cursor!=null) {
            sb.append(cursor.val);
            cursor=cursor.next;
        }
        String str = sb.toString();
        int i = 0;
        int j = str.length()-1;
        while (i<j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow=slow.next;
        }

        ListNode headSecondHalf = reverseList(slow);
        ListNode headFirstHalf = head;

        while (headSecondHalf !=null && headFirstHalf.val==headSecondHalf.val) {
            headFirstHalf = headFirstHalf.next;
            headSecondHalf = headSecondHalf.next;
        }

        return headSecondHalf==null;
    }

}
