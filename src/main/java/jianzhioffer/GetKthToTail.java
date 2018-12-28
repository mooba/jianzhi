package jianzhioffer;
import jianzhioffer.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

// class ListNode {
//     int val;
//     ListNode next = null;

//     ListNode(int val) {
//         this.val = val;
//     }
// }

public class GetKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        
        ListNode point1 = head,
                 point2 = head;

        int i = 1;
        while (i < k) {
            point1 = point1.next;
            i++;
            if (point1 == null)
                return null;
        }

        while(point1.next != null) {
            point1 = point1.next;
            point2 = point2.next;
        }

        return point2;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode rNode = GetKthToTail.FindKthToTail(n1, 2);
        System.out.println(rNode.val);;
    }
}