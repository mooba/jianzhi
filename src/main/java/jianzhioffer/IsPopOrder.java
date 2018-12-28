package jianzhioffer;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

import java.util.Stack;

public class IsPopOrder {
    // 允许使用栈的时候
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) return false;

        Stack<Integer> stack1 = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            stack1.push(pushA[i++]);
            
            while (!stack1.empty() && stack1.peek() == popA[j]) {
                stack1.pop();
                j++;
            }
        }
        return stack1.empty();
     }


     public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        // int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder.isPopOrder(pushA, popA));;
     }
}