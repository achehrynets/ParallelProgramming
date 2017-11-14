package ua.nure.Chehrynets.lab2.task1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Multithreading class fork for philosopher
 */
public class Fork {

    private static AtomicInteger idGenerator = new AtomicInteger();
    private int forkIndex;
    private boolean isUsed;
    private Lock lock;

    public Fork() {
        forkIndex = idGenerator.incrementAndGet();
        isUsed = false;
    }

    public synchronized void getFork() {
        while (isUsed) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " get fork number - " + forkIndex);
        isUsed = true;
        notify();
    }

    public synchronized void putFork() {
        while (!isUsed) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " put fork number - " + forkIndex);
        isUsed = false;
        notify();
    }

}
