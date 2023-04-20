package io.chone.algorithm.linkedlist;
import static io.chone.algorithm.linkedlist.LinkedListUtils.*;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ReverseLinkedList().reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            //取出下一个先
            ListNode next = cur.next;
            //下一个的next改为cur
            cur.next = prev;
            //cur成为前置
            prev = cur;
            //迭代下一个
            cur = next;
        }
        printLinkList(prev);
        return prev;
    }

}
