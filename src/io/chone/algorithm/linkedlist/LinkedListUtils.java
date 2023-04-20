package io.chone.algorithm.linkedlist;

public class LinkedListUtils {

    public static void printLinkList(ListNode node) {
        ListNode cur = node;
        StringBuffer sb = new StringBuffer();
        while (cur != null) {
            sb.append(cur.val).append(">");
            cur = cur.next;
        }
        System.out.println(sb);
    }

    public static class ListNode {
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
}
