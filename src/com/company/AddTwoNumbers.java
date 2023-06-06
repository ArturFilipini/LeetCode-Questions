package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    public static ListNode addTwoNumberstest(ListNode l1, ListNode l2){
        int count = 0;
        ListNode test = new ListNode();
        while (l1 != null || l2 != null){
            count =  l1.val + l2.val;
            if(count == 10){
                l1.next.val = l1.next.val + 1;
                count = 0;
            }
            test.val = count;
            test.next = l1.next;
            l1 = l1.next;
            l2 = l2.next;
            System.out.println(test.val);
        }
        return test;
    }

    public static ListNode returnNewNode(ListNode node, String test) {
        if (node.next == null) {
            System.out.println(test);
            return node;
        }
        test = test+node.next.val;
        return returnNewNode(node.next, test);
    }

    public static String returnNew(String test, int depht) {
        String a = test;
        for (int i = depht; i > 0; i--) {
            String substring = a.substring(0, i);
            a = substring + substring;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(4, new ListNode(3));
        ListNode num1 = new ListNode(2, test);
        ListNode next = num1.next;

        ListNode test2 = new ListNode(6, new ListNode(4));
        ListNode num2 = new ListNode(5, test2);
        ListNode next2 = num2.next;
        addTwoNumberstest(num1, num2);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}