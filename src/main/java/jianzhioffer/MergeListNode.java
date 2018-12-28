package jianzhioffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class MergeListNode {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode head = null,
                point1 = list1,
                point2 = list2,
                tmpPoint = null;
        if (point1.val <= point2.val) {
            head = point1;
            point1 = point1.next;
        } else {
            head = point2;
            point2 = point2.next;
        }
        tmpPoint = head;
    
        while (point1 != null && point2 != null) {
            if (point1.val <= point2.val) {
                tmpPoint.next = point1;
                point1 = point1.next;
                tmpPoint = tmpPoint.next;
            } else {
                tmpPoint.next = point2;
                point2 = point2.next;
                tmpPoint = tmpPoint.next;
            }
        }

        tmpPoint.next = point1 == null ? point2 : point1;
        return head;
    }
}