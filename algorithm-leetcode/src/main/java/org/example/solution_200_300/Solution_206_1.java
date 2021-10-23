package org.example.solution_200_300;

import org.example.base.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution_206_1 {

    public static void main(String[] args) {
        ListNode.printNodes(reverseList(ListNode.buildNodes(new int[]{1, 2, 3, 4, 5})));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
