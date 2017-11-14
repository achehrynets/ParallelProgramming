package ua.nure.Chehrynets.lab2.task3;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {

    private final int MAX_STORE_SIZE;
    private Store store;
    private int product = 0;

    public Consumer(Store store) {
        this.store = store;
        MAX_STORE_SIZE = store.getMAX_ITEMS_SIZE();
    }

    public void run() {
        try {
            while (product < MAX_STORE_SIZE) {
                product = product + store.get();
                System.out.println("Consumer buy " + product + " item(s)");
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
