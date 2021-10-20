package org.example.solution_1_100;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
@SuppressWarnings("all")
public class Solution_2_2 {

    public static void main(String[] args) {
        printNodes(addTwoNumbers(buildNodes(new int[]{9, 9, 9}), buildNodes(new int[]{9, 9, 9})));
        printNodes(addTwoNumbers(buildNodes(new int[]{9, 9}), buildNodes(new int[]{9, 9, 9})));
        printNodes(addTwoNumbers(buildNodes(new int[]{9}), buildNodes(new int[]{9, 9, 9})));
        printNodes(addTwoNumbers(buildNodes(new int[]{9, 9, 9, 1, 2}), buildNodes(new int[]{9, 9, 9})));
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

    public static ListNode buildNodes(int[] numbers) {
        ListNode listNode = null;
        for (int i = 0; i < numbers.length; i++) {
            if (listNode == null) {
                listNode = new ListNode(numbers[i]);
            } else {
                ListNode x = listNode;
                while (x.next != null) {
                    x = x.next;
                }
                x.next = new ListNode(numbers[i]);
            }
        }
        return listNode;
    }

    public static void printNodes(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        ListNode r = listNode;
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
        System.out.println();
    }

    private static class ListNode {

        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
