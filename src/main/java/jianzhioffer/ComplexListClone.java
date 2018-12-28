package jianzhioffer;

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/

public class ComplexListClone {
    public static RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;

        RandomListNode curListNode = pHead;
        while (curListNode != null) {
            RandomListNode tmpNode = new RandomListNode(curListNode.label);
            tmpNode.next = curListNode.next;
            tmpNode.random = curListNode.random;
            curListNode.next = tmpNode;
            curListNode = tmpNode.next;
        }

        RandomListNode newHead = pHead.next;
        curListNode  = newHead;
        while (curListNode != null) {
            if (curListNode.random != null) {
                curListNode.random = curListNode.random.next;
            }

            curListNode = curListNode.next == null ? null : curListNode.next.next;
        }

        //把新链表拆分成两个链表
        curListNode = pHead;
        while (curListNode != null) {
            RandomListNode newNode = curListNode.next;
            curListNode.next = newNode.next;
            curListNode = curListNode.next;
            if (curListNode != null)
                newNode.next = curListNode.next;
        }
        
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        n1.next = n2; n1.random = n3;
        n2.next = n3; n2.random = n1;

        RandomListNode newHead =  Clone(n1);
        while (newHead != null) {
            System.out.print(newHead.label);
            if (newHead.random !=  null)
                System.out.print("[" + newHead.random.label + "]");
            newHead = newHead.next;
        }
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}