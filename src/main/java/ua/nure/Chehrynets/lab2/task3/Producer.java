package ua.nure.Chehrynets.lab2.task3;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {

    private Store store;
    private int product;

    Producer(Store store) {
        this.store = store;
        product = store.getMAX_ITEMS_SIZE();
    }

    public void run() {
        try {
            while(product > 0) {
                product = product - store.put();
                System.out.println ("Producer has to make " + product + " item(s)");
                sleep(100);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
