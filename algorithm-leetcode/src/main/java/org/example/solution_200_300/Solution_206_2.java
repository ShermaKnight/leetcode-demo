package org.example.solution_200_300;

import org.example.base.ListNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution_206_2 {

    public static void main(String[] args) {
        ListNode.printNodes(reverseList(ListNode.buildNodes(new int[]{1, 2, 3, 4, 5})));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ListNode reverse = new ListNode(-1);
        cur = reverse;
        while (!stack.isEmpty()){
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return reverse.next;
    }
}
