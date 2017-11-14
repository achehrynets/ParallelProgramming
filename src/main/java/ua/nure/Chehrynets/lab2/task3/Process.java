package ua.nure.Chehrynets.lab2.task3;

public class Process {

    private static final int MAX_ITEMS = 20;

    public static void main(String[] args) {
        working();
    }

    private static void working() {
        Store store = new Store(MAX_ITEMS);
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();
    }

}
