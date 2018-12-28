package jianzhioffer;

import java.util.ArrayList;
/**
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

public class PrintListFromTailToHead {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> retList = new ArrayList<Integer>();
        if (listNode == null)
            return retList;
        
        ListNode pre = null,
                 cur = listNode,
                 next = null;
        // 链表翻转
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        // 遍历新的链表
        while (pre != null) {
            retList.add(pre.val);
            pre = pre.next;
        }
        
        return retList;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        
        PrintListFromTailToHead solution3 = new PrintListFromTailToHead();
        ArrayList<Integer> retList =  solution3.printListFromTailToHead(n1);
        System.out.println(retList);
    }
}