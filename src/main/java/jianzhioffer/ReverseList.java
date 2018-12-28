package jianzhioffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode  pre = null,
                  cur = head,
                  next = null;
        
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}