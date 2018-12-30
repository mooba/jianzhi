package normalAlgorithms;

import java.util.Arrays;

/**
 * 常用排序算法
 * 快速排序
 * 冒泡排序
 */
public class Sort {
    public static void quikSort(int[] array, int l, int r) { // 快排
        if (l >= r)
            return;

        int i = l, j = r;
        int x = array[l];
        while (i < j ) {
            while (i < j && array[j] >= x)
                j--;
            if (i < j)
                array[i++] = array[j];
            
            while (i < j && array[i] < x)
                i++;
            if (i < j)
                array[j--] = array[i];
        }
        array[i] = x;
        quikSort(array, l, i - 1);
        quikSort(array, i + 1, r);
    }

    public static void bubbleSort(int[] array) {
        int len = array.length;
        if (0 == len || 1 == len)
            return;

        for (int i = 1; i < len; i ++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return;
    }

    public static void main( String[] args )
    {
        int[] array = {7,9,2,8,5,4,6};
        // quikSort(array, 0, 6);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
