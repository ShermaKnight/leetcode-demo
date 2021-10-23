package org.example.solution_1_100;

import org.example.base.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
@SuppressWarnings("all")
public class Solution_2_2 {

    public static void main(String[] args) {
        ListNode.printNodes(addTwoNumbers(ListNode.buildNodes(new int[]{9, 9, 9}), ListNode.buildNodes(new int[]{9, 9, 9})));
        ListNode.printNodes(addTwoNumbers(ListNode.buildNodes(new int[]{9, 9}), ListNode.buildNodes(new int[]{9, 9, 9})));
        ListNode.printNodes(addTwoNumbers(ListNode.buildNodes(new int[]{9}), ListNode.buildNodes(new int[]{9, 9, 9})));
        ListNode.printNodes(addTwoNumbers(ListNode.buildNodes(new int[]{9, 9, 9, 1, 2}), ListNode.buildNodes(new int[]{9, 9, 9})));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int s = x + y + carry;
            carry = s > 9 ? 1 : 0;
            int v = s % 10;
            current.next = new ListNode(v);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
}
