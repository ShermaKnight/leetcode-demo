package org.example.base;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
}
