package org.example.solution_1_100;

import org.example.base.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
@SuppressWarnings("all")
public class Solution_2_1 {

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
        ListNode r = null;
        ListNode f = l1;
        ListNode b = l2;
        boolean label = false;
        while (f != null || b != null) {
            int v = 0;
            if (f != null) {
                v += f.val;
                f = f.next;
            }
            if (b != null) {
                v += b.val;
                b = b.next;
            }
            int vr = v;
            if (label) {
                vr += 1;
                label = false;
            }
            if (vr >= 10) {
                label = true;
                vr %= 10;
            }
            if (r == null) {
                r = new ListNode(vr);
            } else {
                ListNode x = r;
                while (x.next != null) {
                    x = x.next;
                }
                x.next = new ListNode(vr);
            }
        }
        if (label) {
            ListNode x = r;
            while (x.next != null) {
                x = x.next;
            }
            x.next = new ListNode(1);
        }
        return r;
    }
}
