package jianzhioffer;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FibonacciSeq {
    // 使用递归的方式
    public static int Fibonacci(int n) {
        if (n <= 0 || n > 39)
            return 0;

        if (1 == n || 2 == n)
            return 1;
        
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    // 使用非递归的方式
    public static int Fibonacci2(int n) {
        if (n <= 0 || n > 39)
            return 0;   

        int a = 0, b = 1;
        
        while (n > 1) {
            int tmp = a + b;
            a = b;
            b = tmp;
            n --;
        }
        return b;       
    }

    public static void main(String[] args) {
        System.out.println(FibonacciSeq.Fibonacci2(7)); // 13
    }
}