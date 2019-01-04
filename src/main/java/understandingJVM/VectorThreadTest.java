package understandingJVM;

import java.util.Vector;


/**
 * 这段代码使用vector进行测试，说明了没有绝对的线程安全
 * 虽然vector声称是线程安全的类，但是在testA 方法中，调用其内部方法依然可能导致线程不安全
 * 相应地，testB在方法调用之前做了额外的同步措施，就能正常运行
 */
class VectorThreadTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void testA() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread threadA = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++)
                        vector.remove(i);
                }
            };

            Thread threadB = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
            };

            threadA.start();
            threadB.start();

            // 不要产生过多的线程，不然会导致线程假死4
            while (Thread.activeCount() > 20);
        }    
    }

    public static void testB() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread threadA = new Thread() {
                @Override
                public void run() {
                    synchronized(vector) {
                        for (int i = 0; i < vector.size(); i++)
                            vector.remove(i);
                    }
                }
            };

            Thread threadB = new Thread() {
                @Override
                public void run() {
                    synchronized(vector) {
                        for (int i = 0; i < vector.size(); i++) 
                            System.out.println(vector.get(i));
                    }
                }
            };

            threadA.start();
            threadB.start();

            // 不要产生过多的线程，不然会导致线程假死4
            while (Thread.activeCount() > 20);
        }    
    }

    public static void main(String[] args) {
        // testA();
        testB();
    }
}