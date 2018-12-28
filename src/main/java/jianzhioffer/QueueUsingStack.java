package jianzhioffer;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<Integer>(); 
    Stack<Integer> stack2 = new Stack<Integer>(); // 临时存放数据
    
    public void push(int node) {
        if (stack2.empty()) {
            stack1.push(Integer.valueOf(node));
        } else {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(Integer.valueOf(node));
        }
    }
    
    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack solution5 = new QueueUsingStack();
        solution5.push(1);
        solution5.push(2);
        solution5.push(3);
        
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
    }
}