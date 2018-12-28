package jianzhioffer;

import java.text.DateFormat;
import java.util.Arrays;
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
    public static void main( String[] args )
    {
        Runnable task = new Runnable(){
            public void run() {
                for (int i = 0; i < 100; i++)
                    System.out.println(i);
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new ThreadTask();
        thread1.start(); // 为线程执行进行初始化操作，然后调用run方法
        thread2.start();
    }
}

class ThreadTask extends Thread {
    @Override
    public void run() {
        for (char i = 'a'; i <= 'z'; i ++) 
            System.out.println(i);
    }
}
