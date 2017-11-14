package ua.nure.Chehrynets.lab2.task2;

public class Apis implements Runnable {

    private HoneyPot honeyPot;

    public Apis(HoneyPot honeyPot) {
        this.honeyPot = honeyPot;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(honeyPot) {
                if(!honeyPot.isFullHoneyPot()) {
                    honeyPot.addPortion();
                    if (honeyPot.isFullHoneyPot())
                        honeyPot.notifyAll();
                }
            }
        }
    }
}
