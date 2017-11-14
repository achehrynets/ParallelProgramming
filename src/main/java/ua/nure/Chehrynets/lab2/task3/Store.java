package ua.nure.Chehrynets.lab2.task3;

public class Store {

    private final int MAX_ITEMS_SIZE;
    private int counter = 0;

    public Store(int MAX_ITEMS_SIZE) {
        this.MAX_ITEMS_SIZE = MAX_ITEMS_SIZE;
    }

    public int getMAX_ITEMS_SIZE() {
        return MAX_ITEMS_SIZE;
    }

    synchronized int put() {
        if(counter <= MAX_ITEMS_SIZE) {
            counter++;
            System.out.println ("Store contains " + counter + " item(s)");
            return 1;
        }
        return 0;
    }

    synchronized int get() {
        if(counter > 0) {
            counter--;
            System.out.println ("Store contains " + counter + " item(s)");
            return 1;
        }
        return 0;
    }

}
