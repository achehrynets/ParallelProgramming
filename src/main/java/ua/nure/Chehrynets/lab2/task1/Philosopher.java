package ua.nure.Chehrynets.lab2.task1;

import java.util.Random;

public class Philosopher extends Thread {

    private static final int EATING_TIME = 5;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        for (int counter = 0; counter < EATING_TIME; counter++) {
            eating();
            thinking();
        }
        System.out.println(Thread.currentThread().getName() + " finish eating and thinking");
    }

    private void eating() {
        leftFork.getFork();
        rightFork.getFork();
        try {
            Thread.sleep(new Random().nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void thinking() {
        leftFork.putFork();
        rightFork.putFork();
        try {
            Thread.sleep(new Random().nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
