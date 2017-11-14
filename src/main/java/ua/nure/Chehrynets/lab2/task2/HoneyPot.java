package ua.nure.Chehrynets.lab2.task2;

public class HoneyPot {

    private int portionAmount;
    private int portions;

    public HoneyPot(int portionAmount) {
        this.portionAmount = portionAmount;
    }

    public void emptyPot() {
        portions = 0;
        System.out.println("Bear ate all honey!!!");
        System.out.println("Bear falls asleep");
    }

    void addPortion() {
        portions++;
        System.out.println(Thread.currentThread().getName() +
                " add a portion, now honey pot contains " + portions + " portions");
    }

    public boolean isFullHoneyPot() {
        return portionAmount == portions;
    }

}
