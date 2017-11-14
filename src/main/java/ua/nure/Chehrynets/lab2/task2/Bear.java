package ua.nure.Chehrynets.lab2.task2;

public class Bear implements Runnable {

    private HoneyPot honeyPot;

    public Bear(HoneyPot honeyPot) {
        this.honeyPot = honeyPot;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (honeyPot) {
                while (!honeyPot.isFullHoneyPot()) {
                    try {
                        honeyPot.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("bear awake");
                honeyPot.emptyPot();
            }
        }
    }
}
