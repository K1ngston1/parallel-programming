class DualCounter {
    private int counter1 = 0;
    private int counter2 = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void incrementCounter1(String threadName) throws InterruptedException {
        synchronized (lock1) {
            Thread.sleep(150);
            counter1++;
            System.out.println(threadName + " increment counter1: " + counter1);
        }
    }

    public void incrementCounter2(String threadName) throws InterruptedException {
        synchronized (lock2) {
            Thread.sleep(150);
            counter2++;
            System.out.println(threadName + " increment counter2: " + counter2);
        }
    }

    public int valueCounter1() {
        synchronized (lock1) {
            return counter1;
        }
    }

    public int valueCounter2() {
        synchronized (lock2) {
            return counter2;
        }
    }
}

// Без synchronized

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//class DualCounter {
//    private int counter1 = 0;
//    private int counter2 = 0;
//    private final Lock lock1 = new ReentrantLock();
//    private final Lock lock2 = new ReentrantLock();
//
//    public void incrementCounter1(String threadName) throws InterruptedException {
//        lock1.lock();
//        try {
//            Thread.sleep(150);
//            counter1++;
//            System.out.println(threadName + " increment counter1: " + counter1);
//        } finally {
//            lock1.unlock();
//        }
//    }
//
//    public void incrementCounter2(String threadName) throws InterruptedException {
//        lock2.lock();
//        try {
//            Thread.sleep(150);
//            counter2++;
//            System.out.println(threadName + " increment counter2: " + counter2);
//        } finally {
//            lock2.unlock();
//        }
//    }
//
//    public int valueCounter1() {
//        lock1.lock();
//        try {
//            return counter1;
//        } finally {
//            lock1.unlock();
//        }
//    }
//
//    public int valueCounter2() {
//        lock2.lock();
//        try {
//            return counter2;
//        } finally {
//            lock2.unlock();
//        }
//    }
//}
