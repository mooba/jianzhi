package jianzhioffer;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Hello world!
 *
 */
public class App {
    /**
     *
     */

    private static final Comparator<Object> REVERSE_ORDER = Collections.reverseOrder();

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

    public static void main( String[] args )
    {
        int[] array = {7,9,2,8,5,4,6};
        // Integer[] array = {new Integer(7), new Integer(9)};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

class ThreadTask extends Thread {
    @Override
    public void run() {
        for (char i = 'a'; i <= 'z'; i ++) 
            System.out.println(i);
    }
}
