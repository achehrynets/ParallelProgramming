package ua.nure.Chehrynets.lab2.task2;

public class Process {

    private static final int HONEY_POT_SIZE = 20;
    private static final int APIS_AMOUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        working();
    }

    private static void working() throws InterruptedException {
        HoneyPot pot = new HoneyPot(HONEY_POT_SIZE);
        Bear bear = new Bear(pot);
        Thread bearThread = new Thread(bear);
        bearThread.start();
        for (int counter = 1; counter <= APIS_AMOUNT; counter++) {
            Thread thread = new Thread(new Apis(pot));
            thread.setName("Apis" + counter);
            thread.start();
        }
        bearThread.join();
    }

}
