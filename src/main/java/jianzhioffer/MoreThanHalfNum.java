package jianzhioffer;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */


public class MoreThanHalfNum {
    private int targetNum;
    private int halfLen;
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        if (len == 0)
            return 0;

        halfLen = len>>1;
        helper(array, 0, len - 1);

        int cnt = 0;
        for (int item: array)
            if (item == targetNum)
                cnt ++;
        
        if (cnt > halfLen)
            return targetNum;
        else
            return 0;
    }

    public void helper(int[] array, int l, int r) {
        if (l > r)
            return;
        int i = l, j = r;
        int x = array[l];
        while (i < j) {
            while (i < j && array[j] >= x)
                j--;
            if (i < j)
                array[i++] = array[j];

            while (i < j && array[i] < x)
                i++;
            if (i < j)
                array[j--] = array[i]; 
        }
        if (i == halfLen) {
            targetNum = x;
            return;
        } else {
            array[i] = x;
            helper(array, l, i - 1);
            helper(array, i + 1, r);
        }
    }

    public static void main(String[] args) {
        // int[] array = {1,2,3,2,2,2,5,4,2};
        int[] array = {1,2,3,2,4,2,5,2,3};
        // int[] array = {1};
        MoreThanHalfNum solution = new MoreThanHalfNum();
        int target = solution.MoreThanHalfNum_Solution(array);
        System.out.println(target);
    }
}