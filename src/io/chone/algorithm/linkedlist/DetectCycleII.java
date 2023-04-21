package io.chone.algorithm.linkedlist;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/solution/
 */
public class DetectCycleII {

    /**
     * 快慢指针法
     * 设fast走的距离是f； 设slow走的距离是s；
     * 设环外距离为a； 设环周长为b； 设n为圈数（未知数，取决于环的长度）；
     * 指针相遇时，有等量关系：
     * 1. f = 2s (fast是slow速度的二倍)
     * 2. f = s+nb (fast比slow多走了n圈)
     * 式1-式2 => s=nb ,即slow指针走了n圈
     * <p>
     * 入环点的距离： a+nb ，（n=0即首次入环，之后没b步都会进入入环点）
     * 此时，slow已经走了nb了，因此再走a，会进入入环点。
     * <p>
     * 如何走a步？ 让fast重新指向head， fast和slow同频走，fast和slow再次相遇，即到了入环点。
     *
     * @param head
     * @return
     */
    public LinkedListUtils.ListNode detectCycle(LinkedListUtils.ListNode head) {
        LinkedListUtils.ListNode fast = head, slow = head;
        while (true) {
            //无环(注每次两步，所以要判断fast.next)
            if (fast == null || fast.next == null) return null;
            //两步
            fast = fast.next.next;
            //一步
            slow = slow.next;
            if (fast == slow) {
                //相遇
                break;
            }
        }
        //fast指针移到head，重新走a步
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
