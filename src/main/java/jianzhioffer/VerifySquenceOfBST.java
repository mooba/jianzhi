package jianzhioffer;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if (len == 0)
            return false;
        if (len == 1)
            return true;

        int start = 0;
        int end = len - 1;
        return helper(sequence, start, end);
    }

    public boolean helper(int[] sequence, int start, int end) {
        if (start >= end)
            return true;

        int point = sequence[end];
        int i = start;
        while (sequence[i] < point) 
            i++;
            
        int j = i;
        while (j < end) {
            if (sequence[j] < point)
                return false;
            j++;
        }

        return helper(sequence, start, i - 1) && helper(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        // int[] sequence = {8, 10};
        int[] sequence = {7,9,8,11,18,20,12,10};
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        System.out.println(v.verifySquenceOfBST(sequence));
    }
}