package io.chone.algorithm.linkedlist;

import static io.chone.algorithm.linkedlist.LinkedListUtils.*;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
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
public class ReverseLinkedListKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = new ReverseLinkedListKGroup().reverseKGroup(head, 2);
        printLinkList(reversed);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //伪头节点，减少首次空的复杂度
        ListNode dummyHead = new ListNode(-1, head);
        int i = 1;
        //分组开始节点
        ListNode groupStart = head;
        //分组前置节点，用于连接新分组，初始化是dummy
        ListNode groupPrev = dummyHead;
        ListNode cur = head;
        //开始遍历链表
        while (cur != null) {
            if (i % k == 0) {
                ListNode groupEnd = cur;
                //记住下一个
                ListNode groupEndNext = cur.next;
                //先断开，这样就可以复用常规的单链表反转
                groupEnd.next = null;
                ListNode reversedGroupHead = singleReverse(groupStart);
                //连接分组：分区前
                groupPrev.next = reversedGroupHead;
                //连接分组：分组后，groupStart会再尾部，连接到原来的next
                groupStart.next = groupEndNext;
                //更新分组前置节点: 分组反转后的的尾部即groupStart
                groupPrev = groupStart;
                //分组重新开始
                groupStart = groupEndNext;
                //更新游标
                cur = groupEndNext;
            } else {
                //非k整数情况，继续迭代
                cur = cur.next;
            }
            i++;
        }
        return dummyHead.next;
    }

    public ListNode singleReverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
