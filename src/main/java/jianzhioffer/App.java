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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

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
        // int[] array = {7,9,2,8,5,4,6};
        int[][] array2D = {{1,2,3},{4,5,6}};
        // Integer[] array = {new Integer(7), new Integer(9)};
        // Arrays.sort(array);

        ExecutorService exex = Executors.newSingleThreadExecutor();
        exex.submit(new ThreadTask());
    }
}

class ThreadTask extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(i++);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
    }
}
