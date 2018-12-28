package jianzhioffer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) { // 允许额外空间的情况，用空间换时间
        if (array.length == 0)
            return;
        int oddNum = 0;
        int[] tmpArray = new int[array.length];
        int j = 0;
        for (int num: array) {
            if (num % 2 != 0)
                oddNum++;
            tmpArray[j++] = num; // 拷贝
        }

        int evenStart = oddNum;
        int oddStart = 0;
        for (int i = 0; i < array.length; i ++) {
            if (tmpArray[i] % 2 != 0)
                array[oddStart++] = tmpArray[i];
            else
                array[evenStart++] = tmpArray[i];
        }
    }

    public static void reOrderArray2(int[] array) { // 不允许额外空间
        int len = array.length;
        if (len == 0)
            return;

        for (int i = 0; i < len; i ++) {
            if (array[i] % 2 != 0) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                if (array[j] % 2 == 0)
                    continue;
                else {
                    for (int k = j; k > i; k --) {
                        int tmp = array[k];
                        array[k] = array[k - 1];
                        array[k - 1] = tmp;  
                    }
                    break;
                }
            }
        }
    }

    public static void  reOrderArray3(int[] array) { //不允许额外空间的更简单的一种实现
        int len = array.length;
        if (0 == len)
            return;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 != 0)
                continue;
            
            // 元素为偶数
            int j = i + 1;
            while (j < len) {
                if (array[j] % 2 == 0)
                    j ++;
                else
                    break;
            } 
            if (j == len)
                break;
            while (j > i) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        // ReOrderArray.reOrderArray2(array);
        ReOrderArray.reOrderArray3(array);
        System.out.println(Arrays.toString(array));
    }
}